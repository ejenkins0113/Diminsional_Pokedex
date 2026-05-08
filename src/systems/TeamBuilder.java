package systems;

import java.util.ArrayList;
import java.util.List;

import model.Pokemon;

// Manages a team of up to 6 Pokemon.
// Supports add, remove, and display operations.
public class TeamBuilder {
    private static final int MAX_TEAM_SIZE = 6;

    private final List<Pokemon> team;

    public TeamBuilder() {
        this.team = new ArrayList<>();
    }

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

    public int getTeamSize() {
        return team.size();
    }

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
