package systems;

import java.util.ArrayList;
import java.util.List;

import model.Pokemon;

/**
 * Manages a trainer team with a fixed maximum size.
 */
public class TeamBuilder {
    private static final int MAX_TEAM_SIZE = 6;

    private final List<Pokemon> team;

    /**
     * Creates an empty team.
     */
    public TeamBuilder() {
        this.team = new ArrayList<>();
    }

    /**
     * Adds a Pokemon to the team if valid, unique, and under capacity.
     *
     * @param pokemon Pokemon to add
     * @return true when successfully added
     */
    public boolean addToTeam(Pokemon pokemon) {
        if (pokemon == null || pokemon.getName() == null || pokemon.getName().trim().isEmpty()) {
            return false;
        }
        if (team.size() >= MAX_TEAM_SIZE || contains(pokemon.getName())) {
            return false;
        }

        team.add(pokemon);
        return true;
    }

    /**
     * Removes a Pokemon by name.
     *
     * @param name Pokemon name to remove
     * @return true when a matching team member is removed
     */
    public boolean removeFromTeamByName(String name) {
        String normalizedName = normalizeName(name);
        if (normalizedName == null) {
            return false;
        }

        for (int index = 0; index < team.size(); index++) {
            Pokemon pokemon = team.get(index);
            if (normalizedName.equals(normalizeName(pokemon.getName()))) {
                team.remove(index);
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether the team already contains a Pokemon by name.
     *
     * @param name name to check
     * @return true when present
     */
    public boolean contains(String name) {
        String normalizedName = normalizeName(name);
        if (normalizedName == null) {
            return false;
        }

        for (Pokemon pokemon : team) {
            if (normalizedName.equals(normalizeName(pokemon.getName()))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns current team size.
     *
     * @return number of Pokemon in team
     */
    public int getTeamSize() {
        return team.size();
    }

    /**
     * Returns a snapshot copy of current team entries.
     *
     * @return list copy of team Pokemon
     */
    public ArrayList<Pokemon> getTeamSnapshot() {
        return new ArrayList<>(team);
    }

    /**
     * Prints the current team to the console.
     */
    public void displayTeam() {
        if (team.isEmpty()) {
            System.out.println("Team is empty.");
            return;
        }

        System.out.println("=== Current Team ===");
        for (Pokemon pokemon : team) {
            System.out.println(pokemon);
        }
    }

    /**
     * Normalizes a Pokemon name for case-insensitive comparisons.
     *
     * @param name raw name input
     * @return normalized lowercase name, or null when invalid
     */
    private String normalizeName(String name) {
        if (name == null) {
            return null;
        }

        String normalized = name.trim();
        if (normalized.isEmpty()) {
            return null;
        }

        return normalized.toLowerCase();
    }
}
