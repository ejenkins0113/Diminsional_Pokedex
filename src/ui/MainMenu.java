package ui;

import java.util.ArrayList;
import java.util.Scanner;

import manager.DexManager;
import model.Pokemon;
import sorting.CustomSorter;
import sorting.CustomSorter.SortField;
import systems.EncounterSystem;
import systems.EvolutionHistory;
import systems.TeamBuilder;

// Entry point and console menu for Dimensional Dex.
// Integrates manager, sorting, and all Day 6 systems.
public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);

    private static final DexManager dexManager = new DexManager();
    private static final EncounterSystem encounterSystem = new EncounterSystem();
    private static final EvolutionHistory evolutionHistory = new EvolutionHistory();
    private static final TeamBuilder teamBuilder = new TeamBuilder();

    public static void main(String[] args) {
        System.out.println("Dimensional Dex - Console Ready");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1:
                    loadSampleData();
                    break;
                case 2:
                    dexManager.displayAllPokemon();
                    break;
                case 3:
                    searchPokemon();
                    break;
                case 4:
                    filterByType();
                    break;
                case 5:
                    filterByDimension();
                    break;
                case 6:
                    sortDex();
                    break;
                case 7:
                    addEncounter();
                    break;
                case 8:
                    processNextEncounter();
                    break;
                case 9:
                    previewNextEncounter();
                    break;
                case 10:
                    recordEvolutionEvent();
                    break;
                case 11:
                    undoEvolutionEvent();
                    break;
                case 12:
                    peekEvolutionEvent();
                    break;
                case 13:
                    addToTeam();
                    break;
                case 14:
                    removeFromTeam();
                    break;
                case 15:
                    teamBuilder.displayTeam();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting Dimensional Dex. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n=== Dimensional Dex Menu ===");
        System.out.println("1. Load sample Pokemon data");
        System.out.println("2. Display all Pokemon");
        System.out.println("3. Search Pokemon by name");
        System.out.println("4. Filter Pokemon by type");
        System.out.println("5. Filter Pokemon by dimension");
        System.out.println("6. Sort Pokemon (ID/Level/Attack)");
        System.out.println("7. Add encounter by Pokemon name");
        System.out.println("8. Process next encounter");
        System.out.println("9. Preview next encounter");
        System.out.println("10. Record evolution event");
        System.out.println("11. Undo last evolution event");
        System.out.println("12. Peek last evolution event");
        System.out.println("13. Add Pokemon to team by name");
        System.out.println("14. Remove Pokemon from team by name");
        System.out.println("15. Display current team");
        System.out.println("0. Exit");
    }

    private static void loadSampleData() {
        if (dexManager.getSize() > 0) {
            System.out.println("Sample data already loaded or dex already has entries. Skipped.");
            return;
        }
        dexManager.loadSampleData();
        System.out.println("Sample data loaded. Entries in dex: " + dexManager.getSize());
    }

    private static void searchPokemon() {
        String name = readText("Enter Pokemon name to search: ");
        Pokemon found = dexManager.searchByName(name);
        if (found == null) {
            System.out.println("Pokemon not found: " + name);
            return;
        }
        System.out.println("Found: " + found);
    }

    private static void filterByType() {
        String type = readText("Enter type (e.g. Fire, Water): ");
        ArrayList<Pokemon> matches = dexManager.filterByType(type);
        printPokemonList("Filter results by type", matches);
    }

    private static void filterByDimension() {
        String dimension = readText("Enter dimension (e.g. Prime, Shadow): ");
        ArrayList<Pokemon> matches = dexManager.filterByDimension(dimension);
        printPokemonList("Filter results by dimension", matches);
    }

    private static void sortDex() {
        if (dexManager.getPokemonList().isEmpty()) {
            System.out.println("Dex is empty. Load sample data first.");
            return;
        }

        System.out.println("Sort field: 1) ID  2) Level  3) Attack");
        int sortChoice = readInt("Choose sort field: ");

        SortField field;
        switch (sortChoice) {
            case 1:
                field = SortField.ID;
                break;
            case 2:
                field = SortField.LEVEL;
                break;
            case 3:
                field = SortField.ATTACK;
                break;
            default:
                System.out.println("Invalid sort option.");
                return;
        }

        CustomSorter.sort(dexManager.getPokemonList(), field);
        System.out.println("Pokemon sorted by " + field + " in ascending order.");
        dexManager.displayAllPokemon();
    }

    private static void addEncounter() {
        if (dexManager.getPokemonList().isEmpty()) {
            System.out.println("Dex is empty. Load sample data first.");
            return;
        }

        String name = readText("Enter Pokemon name to queue as encounter: ");
        Pokemon pokemon = dexManager.searchByName(name);
        if (pokemon == null) {
            System.out.println("Pokemon not found in dex: " + name);
            return;
        }

        boolean added = encounterSystem.addEncounter(pokemon);
        if (added) {
            System.out.println("Encounter queued: " + pokemon.getName());
            System.out.println("Queued encounters: " + encounterSystem.getEncounterCount());
        } else {
            System.out.println("Failed to queue encounter.");
        }
    }

    private static void processNextEncounter() {
        Pokemon next = encounterSystem.nextEncounter();
        if (next == null) {
            System.out.println("No encounters queued.");
            return;
        }
        System.out.println("Encounter resolved: " + next);
        System.out.println("Remaining encounters: " + encounterSystem.getEncounterCount());
    }

    private static void previewNextEncounter() {
        Pokemon next = encounterSystem.peekNextEncounter();
        if (next == null) {
            System.out.println("No encounters queued.");
            return;
        }
        System.out.println("Next encounter: " + next);
    }

    private static void recordEvolutionEvent() {
        String event = readText("Enter evolution event text: ");
        boolean recorded = evolutionHistory.recordEvolution(event);
        if (recorded) {
            System.out.println("Evolution event recorded.");
            System.out.println("History size: " + evolutionHistory.getHistoryCount());
        } else {
            System.out.println("Could not record event. Input cannot be blank.");
        }
    }

    private static void undoEvolutionEvent() {
        String undone = evolutionHistory.undoLastEvolution();
        if (undone == null) {
            System.out.println("No evolution events to undo.");
            return;
        }
        System.out.println("Undid: " + undone);
    }

    private static void peekEvolutionEvent() {
        String latest = evolutionHistory.peekLastEvolution();
        if (latest == null) {
            System.out.println("No evolution history recorded yet.");
            return;
        }
        System.out.println("Latest evolution event: " + latest);
    }

    private static void addToTeam() {
        if (dexManager.getPokemonList().isEmpty()) {
            System.out.println("Dex is empty. Load sample data first.");
            return;
        }

        String name = readText("Enter Pokemon name to add to team: ");
        Pokemon pokemon = dexManager.searchByName(name);
        if (pokemon == null) {
            System.out.println("Pokemon not found in dex: " + name);
            return;
        }

        boolean added = teamBuilder.addToTeam(pokemon);
        if (added) {
            System.out.println(pokemon.getName() + " added to team.");
            System.out.println("Team size: " + teamBuilder.getTeamSize() + "/6");
        } else {
            System.out.println("Could not add to team (duplicate, invalid, or team is full).");
        }
    }

    private static void removeFromTeam() {
        String name = readText("Enter Pokemon name to remove from team: ");
        boolean removed = teamBuilder.removeFromTeamByName(name);
        if (removed) {
            System.out.println(name + " removed from team.");
            System.out.println("Team size: " + teamBuilder.getTeamSize() + "/6");
        } else {
            System.out.println("Pokemon not found in team: " + name);
        }
    }

    private static void printPokemonList(String title, ArrayList<Pokemon> list) {
        if (list == null || list.isEmpty()) {
            System.out.println(title + ": no results.");
            return;
        }

        System.out.println("=== " + title + " (" + list.size() + ") ===");
        for (Pokemon pokemon : list) {
            System.out.println(pokemon);
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine();
            try {
                return Integer.parseInt(raw.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please enter a whole number.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Input cannot be blank.");
        }
    }
}
