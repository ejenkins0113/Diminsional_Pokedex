package manager;

import model.Pokemon;

public class DexManagerTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testAddUnique();
        testAddDuplicateRejected();
        testAddNull();
        testRemoveExisting();
        testRemoveNonExistent();
        testSearchFound();
        testSearchNotFound();
        testSearchCaseInsensitive();
        testDisplayEmpty();
        testDisplayNonEmpty();
        testLoadSampleData();
        testSizeAfterOperations();

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

    // ==== Helpers ====

    private static Pokemon makePokemon(int id, String name) {
        return new Pokemon(id, name, "Fire", null, 10, 40, 40, 40, "Prime", 0, false, true, true, "Test entry.");
    }

    // ==== Test Cases ====

    private static void testAddUnique() {
        DexManager dex = new DexManager();
        boolean result = dex.addPokemon(makePokemon(1, "Charmander"));
        assertTrue("addPokemon - unique entry returns true", result);
        assertEqual("addPokemon - size increments to 1", 1, dex.getSize());
    }

    private static void testAddDuplicateRejected() {
        DexManager dex = new DexManager();
        dex.addPokemon(makePokemon(1, "Pikachu"));
        boolean result = dex.addPokemon(makePokemon(2, "Pikachu")); // same name, different id
        assertTrue("addPokemon - duplicate name rejected", !result);
        assertEqual("addPokemon - size stays at 1 after duplicate", 1, dex.getSize());
    }

    private static void testAddNull() {
        DexManager dex = new DexManager();
        boolean result = dex.addPokemon(null);
        assertTrue("addPokemon - null rejected", !result);
        assertEqual("addPokemon - size stays 0 after null", 0, dex.getSize());
    }

    private static void testRemoveExisting() {
        DexManager dex = new DexManager();
        dex.addPokemon(makePokemon(4, "Squirtle"));
        boolean result = dex.removePokemonByName("Squirtle");
        assertTrue("removePokemonByName - existing entry returns true", result);
        assertEqual("removePokemonByName - size is 0 after remove", 0, dex.getSize());
        assertTrue("removePokemonByName - search returns null after remove", dex.searchByName("Squirtle") == null);
    }

    private static void testRemoveNonExistent() {
        DexManager dex = new DexManager();
        boolean result = dex.removePokemonByName("Mewtwo");
        assertTrue("removePokemonByName - missing entry returns false", !result);
    }

    private static void testSearchFound() {
        DexManager dex = new DexManager();
        Pokemon p = makePokemon(25, "Bulbasaur");
        dex.addPokemon(p);
        Pokemon result = dex.searchByName("Bulbasaur");
        assertTrue("searchByName - found returns correct Pokemon", result == p);
    }

    private static void testSearchNotFound() {
        DexManager dex = new DexManager();
        Pokemon result = dex.searchByName("Gengar");
        assertTrue("searchByName - not found returns null", result == null);
    }

    private static void testSearchCaseInsensitive() {
        DexManager dex = new DexManager();
        dex.addPokemon(makePokemon(7, "Eevee"));
        assertTrue("searchByName - uppercase match",  dex.searchByName("EEVEE")  != null);
        assertTrue("searchByName - lowercase match",  dex.searchByName("eevee")  != null);
        assertTrue("searchByName - mixed case match", dex.searchByName("eEvEe")  != null);
    }

    private static void testDisplayEmpty() {
        DexManager dex = new DexManager();
        System.out.println("[INFO] displayAllPokemon on empty dex:");
        dex.displayAllPokemon(); // Should print "The Pokedex is empty."
        passed++;                // Visual confirmation only
    }

    private static void testDisplayNonEmpty() {
        DexManager dex = new DexManager();
        dex.addPokemon(makePokemon(1, "Alpha"));
        dex.addPokemon(makePokemon(2, "Beta"));
        System.out.println("[INFO] displayAllPokemon with 2 entries:");
        dex.displayAllPokemon(); // Should print header + 2 lines
        passed++;                // Visual confirmation only
    }

    private static void testLoadSampleData() {
        DexManager dex = new DexManager();
        dex.loadSampleData();
        assertTrue("loadSampleData - dex is not empty", dex.getSize() > 0);
        assertTrue("loadSampleData - Bulbasaur present", dex.searchByName("Bulbasaur") != null);
        assertTrue("loadSampleData - Mewtwo present",    dex.searchByName("Mewtwo")    != null);
        assertTrue("loadSampleData - Pikachu present",   dex.searchByName("Pikachu")   != null);
    }

    private static void testSizeAfterOperations() {
        DexManager dex = new DexManager();
        dex.addPokemon(makePokemon(1, "A"));
        dex.addPokemon(makePokemon(2, "B"));
        dex.addPokemon(makePokemon(3, "C"));
        dex.removePokemonByName("B");
        assertEqual("getSize - correct after add/remove", 2, dex.getSize());
    }
}
