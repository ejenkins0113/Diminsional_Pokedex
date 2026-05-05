package manager;

import model.Pokemon;
import java.util.ArrayList;

public class DexManagerFilterTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testFilterByTypeReturnsMatches();
        testFilterByTypeNoMatches();
        testFilterByTypeCaseInsensitive();
        testFilterByTypeMatchesSecondaryType();
        testFilterByDimensionReturnsMatches();
        testFilterByDimensionNoMatches();
        testFilterByDimensionCaseInsensitive();
        testFilterByTypeNullReturnsEmptyList();
        testFilterByDimensionNullReturnsEmptyList();

        System.out.println("\n--- Results: " + passed + " passed, " + failed + " failed ---");
    }

    // ==== Assertion Helpers ====

    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            failed++;
        }
    }

    private static void assertEqual(String testName, Object expected, Object actual) {
        if (expected.equals(actual)) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            System.out.println("       Expected : " + expected);
            System.out.println("       Actual   : " + actual);
            failed++;
        }
    }

    // ==== Helper ====

    private static DexManager buildSampleDex() {
        DexManager dex = new DexManager();
        dex.addPokemon(new Pokemon(1,   "Bulbasaur",  "Grass",   "Poison",  5,  45, 49, 49, "Prime",  0, false, true, true, "Grass/Poison starter."));
        dex.addPokemon(new Pokemon(4,   "Charmander", "Fire",    null,      5,  39, 52, 43, "Prime",  0, false, true, true, "Fire starter."));
        dex.addPokemon(new Pokemon(7,   "Squirtle",   "Water",   null,      5,  44, 48, 65, "Prime",  0, false, true, true, "Water starter."));
        dex.addPokemon(new Pokemon(25,  "Pikachu",    "Electric",null,     10,  35, 55, 40, "Prime",  1, false, true, true, "Electric mouse."));
        dex.addPokemon(new Pokemon(150, "Mewtwo",     "Psychic", null,     70, 106,110, 90, "Shadow", 2, false, true, true, "Psychic legend."));
        dex.addPokemon(new Pokemon(248, "Tyranitar",  "Rock",    "Dark",   55, 100,134,110, "Ruins",  2, false, true, false, "Rock/Dark titan."));
        dex.addPokemon(new Pokemon(6,   "Charizard",  "Fire",    "Flying", 36,  78, 84, 78, "Prime",  2, false, true, true,  "Fire/Flying powerhouse."));
        return dex;
    }

    // ==== Test Cases ====

    private static void testFilterByTypeReturnsMatches() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByType("Fire");
        assertEqual("filterByType - Fire returns 2 results", 2, results.size());
        boolean hasCharmander = false, hasCharizard = false;
        for (Pokemon p : results) {
            if (p.getName().equals("Charmander")) hasCharmander = true;
            if (p.getName().equals("Charizard"))  hasCharizard  = true;
        }
        assertTrue("filterByType - Fire contains Charmander", hasCharmander);
        assertTrue("filterByType - Fire contains Charizard",  hasCharizard);
    }

    private static void testFilterByTypeNoMatches() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByType("Ice");
        assertTrue("filterByType - no matches returns empty list", results.isEmpty());
    }

    private static void testFilterByTypeCaseInsensitive() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> lower = dex.filterByType("fire");
        ArrayList<Pokemon> upper = dex.filterByType("FIRE");
        assertEqual("filterByType - case-insensitive: lowercase matches", 2, lower.size());
        assertEqual("filterByType - case-insensitive: uppercase matches", 2, upper.size());
    }

    private static void testFilterByTypeMatchesSecondaryType() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByType("Poison");
        assertEqual("filterByType - secondary type Poison returns Bulbasaur", 1, results.size());
        assertEqual("filterByType - secondary type match is Bulbasaur", "Bulbasaur", results.get(0).getName());
    }

    private static void testFilterByDimensionReturnsMatches() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByDimension("Prime");
        assertEqual("filterByDimension - Prime returns 5 results", 5, results.size());
    }

    private static void testFilterByDimensionNoMatches() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByDimension("Storm");
        assertTrue("filterByDimension - no matches returns empty list", results.isEmpty());
    }

    private static void testFilterByDimensionCaseInsensitive() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> lower = dex.filterByDimension("shadow");
        ArrayList<Pokemon> upper = dex.filterByDimension("SHADOW");
        assertEqual("filterByDimension - case-insensitive: lowercase matches", 1, lower.size());
        assertEqual("filterByDimension - case-insensitive: uppercase matches", 1, upper.size());
    }

    private static void testFilterByTypeNullReturnsEmptyList() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByType(null);
        assertTrue("filterByType - null input returns empty list (not null)", results != null && results.isEmpty());
    }

    private static void testFilterByDimensionNullReturnsEmptyList() {
        DexManager dex = buildSampleDex();
        ArrayList<Pokemon> results = dex.filterByDimension(null);
        assertTrue("filterByDimension - null input returns empty list (not null)", results != null && results.isEmpty());
    }
}
