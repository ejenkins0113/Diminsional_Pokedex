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

/**
 * Console entry point and interactive menu for Dimensional Dex.
 *
 * <p>Integrates dex management, sorting, encounters, evolution history,
 * and team building into a single command-line workflow.</p>
 */
public class MainMenu {
    private static final int BOX_WIDTH = 120;

    private static final Scanner scanner = new Scanner(System.in);

    private static final DexManager dexManager = new DexManager();
    private static final EncounterSystem encounterSystem = new EncounterSystem();
    private static final EvolutionHistory evolutionHistory = new EvolutionHistory();
    private static final TeamBuilder teamBuilder = new TeamBuilder();

    /**
     * Runs the interactive console loop.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        printBoxMessage("Dimensional Dex - Console Ready");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1:
                    loadSampleData();
                    break;
                case 2:
                    displayDexBoxed();
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
                    displayTeamBoxed();
                    break;
                case 0:
                    running = false;
                    printBoxMessage("Exiting Dimensional Dex. Goodbye.");
                    break;
                default:
                    printBoxMessage("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Prints the main command menu.
     */
    private static void printMainMenu() {
        ArrayList<String> menuLines = new ArrayList<>();
        menuLines.add("1. Load sample Pokemon data");
        menuLines.add("2. Display all Pokemon");
        menuLines.add("3. Search Pokemon by name");
        menuLines.add("4. Filter Pokemon by type");
        menuLines.add("5. Filter Pokemon by dimension");
        menuLines.add("6. Sort Pokemon (ID/Level/Attack)");
        menuLines.add("7. Add encounter by Pokemon name");
        menuLines.add("8. Process next encounter");
        menuLines.add("9. Preview next encounter");
        menuLines.add("10. Record evolution event");
        menuLines.add("11. Undo last evolution event");
        menuLines.add("12. Peek last evolution event");
        menuLines.add("13. Add Pokemon to team by name");
        menuLines.add("14. Remove Pokemon from team by name");
        menuLines.add("15. Display current team");
        menuLines.add("0. Exit");
        printBox("Dimensional Dex Menu", menuLines);
    }

    /**
     * Loads built-in sample Pokemon data into the dex once.
     */
    private static void loadSampleData() {
        if (dexManager.getSize() > 0) {
            printBoxMessage("Sample data already loaded or dex already has entries. Skipped.");
            return;
        }
        dexManager.loadSampleData();
        printBoxMessage("Sample data loaded. Entries in dex: " + dexManager.getSize());
    }

    /**
     * Prompts for and searches a Pokemon by name.
     */
    private static void searchPokemon() {
        String name = readText("Enter Pokemon name to search: ");
        Pokemon found = dexManager.searchByName(name);
        if (found == null) {
            printBoxMessage("Pokemon not found: " + name);
            return;
        }
        printBoxMessage("Found: " + found);
    }

    /**
     * Prompts for type filter and prints matching Pokemon.
     */
    private static void filterByType() {
        String type = readText("Enter type (e.g. Fire, Water): ");
        ArrayList<Pokemon> matches = dexManager.filterByType(type);
        printPokemonList("Filter results by type", matches);
    }

    /**
     * Prompts for dimension filter and prints matching Pokemon.
     */
    private static void filterByDimension() {
        String dimension = readText("Enter dimension (e.g. Norasua, Megalune): ");
        ArrayList<Pokemon> matches = dexManager.filterByDimension(dimension);
        printPokemonList("Filter results by dimension", matches);
    }

    /**
     * Prompts for sort field and sorts dex entries in ascending order.
     */
    private static void sortDex() {
        if (dexManager.getPokemonList().isEmpty()) {
            printBoxMessage("Dex is empty. Load sample data first.");
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
                printBoxMessage("Invalid sort option.");
                return;
        }

        CustomSorter.sort(dexManager.getPokemonList(), field);
        printBoxMessage("Pokemon sorted by " + field + " in ascending order.");
        displayDexBoxed();
    }

    /**
     * Queues a dex Pokemon into the encounter system by name.
     */
    private static void addEncounter() {
        if (dexManager.getPokemonList().isEmpty()) {
            printBoxMessage("Dex is empty. Load sample data first.");
            return;
        }

        String name = readText("Enter Pokemon name to queue as encounter: ");
        Pokemon pokemon = dexManager.searchByName(name);
        if (pokemon == null) {
            printBoxMessage("Pokemon not found in dex: " + name);
            return;
        }

        boolean added = encounterSystem.addEncounter(pokemon);
        if (added) {
            printBoxMessage("Encounter queued: " + pokemon.getName() + " | Queued encounters: "
                    + encounterSystem.getEncounterCount());
        } else {
            printBoxMessage("Failed to queue encounter.");
        }
    }

    /**
     * Processes (removes) the next queued encounter.
     */
    private static void processNextEncounter() {
        Pokemon next = encounterSystem.nextEncounter();
        if (next == null) {
            printBoxMessage("No encounters queued.");
            return;
        }
        printBoxMessage("Encounter resolved: " + next + " | Remaining encounters: "
                + encounterSystem.getEncounterCount());
    }

    /**
     * Displays the next queued encounter without removing it.
     */
    private static void previewNextEncounter() {
        Pokemon next = encounterSystem.peekNextEncounter();
        if (next == null) {
            printBoxMessage("No encounters queued.");
            return;
        }
        printBoxMessage("Next encounter: " + next);
    }

    /**
     * Records a free-text evolution event.
     */
    private static void recordEvolutionEvent() {
        String event = readText("Enter evolution event text: ");
        boolean recorded = evolutionHistory.recordEvolution(event);
        if (recorded) {
            printBoxMessage("Evolution event recorded. History size: " + evolutionHistory.getHistoryCount());
        } else {
            printBoxMessage("Could not record event. Input cannot be blank.");
        }
    }

    /**
     * Undoes the most recently recorded evolution event.
     */
    private static void undoEvolutionEvent() {
        String undone = evolutionHistory.undoLastEvolution();
        if (undone == null) {
            printBoxMessage("No evolution events to undo.");
            return;
        }
        printBoxMessage("Undid: " + undone);
    }

    /**
     * Peeks at the latest evolution event without removing it.
     */
    private static void peekEvolutionEvent() {
        String latest = evolutionHistory.peekLastEvolution();
        if (latest == null) {
            printBoxMessage("No evolution history recorded yet.");
            return;
        }
        printBoxMessage("Latest evolution event: " + latest);
    }

    /**
     * Adds a Pokemon from the dex to the active team.
     */
    private static void addToTeam() {
        if (dexManager.getPokemonList().isEmpty()) {
            printBoxMessage("Dex is empty. Load sample data first.");
            return;
        }

        String name = readText("Enter Pokemon name to add to team: ");
        Pokemon pokemon = dexManager.searchByName(name);
        if (pokemon == null) {
            printBoxMessage("Pokemon not found in dex: " + name);
            return;
        }

        boolean added = teamBuilder.addToTeam(pokemon);
        if (added) {
            printBoxMessage(pokemon.getName() + " added to team. Team size: " + teamBuilder.getTeamSize() + "/6");
        } else {
            printBoxMessage("Could not add to team (duplicate, invalid, or team is full).");
        }
    }

    /**
     * Removes a Pokemon from the active team by name.
     */
    private static void removeFromTeam() {
        String name = readText("Enter Pokemon name to remove from team: ");
        boolean removed = teamBuilder.removeFromTeamByName(name);
        if (removed) {
            printBoxMessage(name + " removed from team. Team size: " + teamBuilder.getTeamSize() + "/6");
        } else {
            printBoxMessage("Pokemon not found in team: " + name);
        }
    }

    /**
     * Prints a titled list of Pokemon.
     *
     * @param title section title
     * @param list Pokemon entries to print
     */
    private static void printPokemonList(String title, ArrayList<Pokemon> list) {
        if (list == null || list.isEmpty()) {
            printBoxMessage(title + ": no results.");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();
        for (Pokemon pokemon : list) {
            lines.add(pokemon.toString());
        }
        printBox(title + " (" + list.size() + ")", lines);
    }

    private static void displayDexBoxed() {
        ArrayList<Pokemon> list = dexManager.getPokemonList();
        if (list.isEmpty()) {
            printBoxMessage("The Pokedex is empty.");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();
        for (Pokemon pokemon : list) {
            lines.add(pokemon.toString());
        }
        printBox("Dimensional Pokedex (" + list.size() + " entries)", lines);
    }

    private static void displayTeamBoxed() {
        ArrayList<Pokemon> team = teamBuilder.getTeamSnapshot();
        if (team.isEmpty()) {
            printBoxMessage("Team is empty.");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();
        for (Pokemon pokemon : team) {
            lines.add(pokemon.toString());
        }
        printBox("Current Team (" + team.size() + "/6)", lines);
    }

    private static void printBoxMessage(String message) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(message);
        printBox("Message", lines);
    }

    private static void printBox(String title, ArrayList<String> lines) {
        String horizontal = repeat('-', BOX_WIDTH - 2);
        System.out.println();
        System.out.println("+" + horizontal + "+");
        System.out.println("| " + padRight(title, BOX_WIDTH - 4) + " |");
        System.out.println("+" + horizontal + "+");

        for (String line : lines) {
            ArrayList<String> chunks = wrapLine(line, BOX_WIDTH - 4);
            for (String chunk : chunks) {
                System.out.println("| " + padRight(chunk, BOX_WIDTH - 4) + " |");
            }
        }

        System.out.println("+" + horizontal + "+");
    }

    private static ArrayList<String> wrapLine(String text, int width) {
        ArrayList<String> chunks = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            chunks.add("");
            return chunks;
        }

        int start = 0;
        while (start < text.length()) {
            int end = Math.min(start + width, text.length());
            chunks.add(text.substring(start, end));
            start = end;
        }
        return chunks;
    }

    private static String padRight(String value, int width) {
        if (value.length() >= width) {
            return value.substring(0, width);
        }
        return value + repeat(' ', width - value.length());
    }

    private static String repeat(char c, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * Repeatedly prompts until a valid integer is entered.
     *
     * @param prompt input prompt text
     * @return parsed integer value
     */
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

    /**
     * Repeatedly prompts until non-blank text is entered.
     *
     * @param prompt input prompt text
     * @return trimmed non-empty text
     */
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
