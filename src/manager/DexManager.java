package manager;

import model.Pokemon;
import java.util.ArrayList;
import java.util.HashMap;

// Handles all Pokedex logic: storage, search, filter, and display.
// Uses ArrayList<Pokemon> for the main list and HashMap<String, Pokemon> for name lookup.
public class DexManager {

    // ==== Storage ====
    private ArrayList<Pokemon> pokemonList;
    private HashMap<String, Pokemon> pokemonMap; // key: normalized name (trimmed + lowercase)

    // ==== Constructor ====
    public DexManager() {
        pokemonList = new ArrayList<>();
        pokemonMap = new HashMap<>();
    }

    // ==== Name Normalization ====
    private String normalize(String name) {
        return name.trim().toLowerCase();
    }

    // ==== Add ====
    // Returns true if added successfully, false if duplicate or null.
    public boolean addPokemon(Pokemon pokemon) {
        if (pokemon == null) return false;
        String key = normalize(pokemon.getName());
        if (pokemonMap.containsKey(key)) return false; // reject duplicate
        pokemonList.add(pokemon);
        pokemonMap.put(key, pokemon);
        return true;
    }

    // ==== Remove ====
    // Returns true if found and removed, false if not found.
    public boolean removePokemonByName(String name) {
        if (name == null) return false;
        String key = normalize(name);
        Pokemon target = pokemonMap.remove(key);
        if (target == null) return false;
        pokemonList.remove(target);
        return true;
    }

    // ==== Search ====
    // Returns matching Pokemon or null if not found.
    public Pokemon searchByName(String name) {
        if (name == null) return null;
        return pokemonMap.get(normalize(name));
    }

    // ==== Display All ====
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

    // ==== Getters ====
    public ArrayList<Pokemon> getPokemonList() { return pokemonList; }
    public int getSize() { return pokemonList.size(); }

    // ==== Sample Data ====
    // Seeds the dex with starter Pokemon across multiple types and dimensions.
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
