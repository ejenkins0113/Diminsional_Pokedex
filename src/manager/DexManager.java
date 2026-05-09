package manager;

import model.Pokemon;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Handles core Pokedex operations such as storage, lookup, filtering, and display.
 *
 * <p>Uses an ArrayList for ordered iteration and a HashMap for fast name-based lookup.</p>
 */
public class DexManager {

    // ==== Storage ====
    private ArrayList<Pokemon> pokemonList;
    private HashMap<String, Pokemon> pokemonMap; // key: normalized name (trimmed + lowercase)

    /**
     * Creates an empty dex manager.
     */
    public DexManager() {
        pokemonList = new ArrayList<>();
        pokemonMap = new HashMap<>();
    }

    /**
     * Normalizes a Pokemon name for consistent map keys.
     *
     * @param name raw Pokemon name
     * @return trimmed, lowercase key
     */
    private String normalize(String name) {
        return name.trim().toLowerCase();
    }

    /**
     * Adds a Pokemon to the dex when valid and not already present by name.
     *
     * @param pokemon Pokemon to add
     * @return true when added; false for null or duplicate name
     */
    public boolean addPokemon(Pokemon pokemon) {
        if (pokemon == null) 
            return false;
        String key = normalize(pokemon.getName());

        if (pokemonMap.containsKey(key)) 
            return false; // reject duplicate
            pokemonList.add(pokemon);
            pokemonMap.put(key, pokemon);
            return true;
          
    }

    /**
     * Removes a Pokemon by name.
     *
     * @param name Pokemon name to remove
     * @return true when removed; false when missing or invalid input
     */
    public boolean removePokemonByName(String name) {
        if (name == null) 
            return false;
        String key = normalize(name);
        Pokemon target = pokemonMap.remove(key);

        if (target == null) 
            return false;
            pokemonList.remove(target);
            return true;
    }

    /**
     * Searches for a Pokemon by name.
     *
     * @param name Pokemon name
     * @return matching Pokemon, or null when not found/invalid
     */
    public Pokemon searchByName(String name) {
        if (name == null) 
            return null;
        return pokemonMap.get(normalize(name));
    }

    /**
     * Prints all Pokemon currently stored in the dex.
     */
    public void displayAllPokemon() {
        if (pokemonList.isEmpty()) {
            System.out.println("The Pokedex is empty.");
            return;
        }

        System.out.println("=== Dimensional Pokedex (" + pokemonList.size() + " entries) ===");
        for (Pokemon p : pokemonList) {
            System.out.println(p);
        }
    }

    /**
     * Filters Pokemon by primary or secondary type.
     *
     * @param type type query (case-insensitive)
     * @return list of matches, or empty list if none/invalid input
     */
    public ArrayList<Pokemon> filterByType(String type) {
        ArrayList<Pokemon> results = new ArrayList<>();
        if (type == null) 
            return results;

        String query = type.trim().toLowerCase();
        for (Pokemon p : pokemonList) {
            boolean matchPrimary = p.getPrimaryType() != null &&
                    p.getPrimaryType().toLowerCase().equals(query);
            boolean matchSecondary = p.getSecondaryType() != null &&
                    p.getSecondaryType().toLowerCase().equals(query);
            if (matchPrimary || matchSecondary) {
                results.add(p);
            }
        }
        return results;
    }

    /**
     * Filters Pokemon by dimension.
     *
     * @param dimension dimension query (case-insensitive)
     * @return list of matches, or empty list if none/invalid input
     */
    public ArrayList<Pokemon> filterByDimension(String dimension) {
        ArrayList<Pokemon> results = new ArrayList<>();
        if (dimension == null) 
            return results;     
        
        String query = dimension.trim().toLowerCase();
        for (Pokemon p : pokemonList) {
            if (p.getDimension() != null && p.getDimension().toLowerCase().equals(query)) {
                results.add(p);
            }
        }
        return results;
    }

    /**
     * Returns the underlying dex list.
     *
     * @return mutable pokemon list used by this manager
     */
    public ArrayList<Pokemon> getPokemonList() {
         return pokemonList; }

    /**
     * Returns current number of entries.
     *
     * @return total Pokemon count in the dex
     */
    public int getSize() { 
        return pokemonList.size(); }

    /**
     * Loads a curated sample dataset spanning multiple types and dimensions.
     */
    public void loadSampleData() {
        addPokemon(new Pokemon(1,   "Bulbasaur",   "Grass",  "Poison", 5,  45, 49, 49, "Prime",   0, false, true,  true,  "A strange seed is planted on its back at birth."));
        addPokemon(new Pokemon(4,   "Charmander",  "Fire",   null,     5,  39, 52, 43, "Prime",   0, false, true,  true,  "The flame on its tail indicates its life force."));
        addPokemon(new Pokemon(7,   "Squirtle",    "Water",  null,     5,  44, 48, 65, "Prime",   0, false, true,  true,  "After birth, its back swells and hardens into a shell."));
        addPokemon(new Pokemon(25,  "Pikachu",     "Electric",null,   10,  35, 55, 40, "Prime",   1, false, true,  true,  "It raises its tail to check its surroundings."));
        addPokemon(new Pokemon(150, "Mewtwo",      "Psychic",null,    70, 106,110, 90, "Shadow",  2, false, true,  true,  "A Pokemon created by recombining Mew's genes."));
        addPokemon(new Pokemon(248, "Tyranitar",   "Rock",  "Dark",   55, 100,134,110, "Ruins",   2, false, true,  false, "If it rampages, it knocks down mountains and buries rivers."));
        addPokemon(new Pokemon(445, "Garchomp",    "Dragon","Ground",  60,  95,130, 95, "Storm",  2, false, true,  false, "When it folds up its body and extends its wings, it can fly like a jet plane."));
        addPokemon(new Pokemon(6,   "Charizard",   "Fire",  "Flying", 36,  78, 84, 78, "Prime",   2, false, true,  true,  "It spits fire that is hot enough to melt boulders."));
    }
}
