package systems;

import model.Pokemon;

public class EncounterSystemTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testAddEncounterSetsHasEncountersTrue();
        testNextEncounterReturnsHighestLevelFirst();
        testPeekDoesNotRemoveEntry();
        testNextEncounterOnEmptyReturnsNull();
        testEncounterCountBeforeAndAfterPolls();
        testNaturalComparableByIdRemainsIndependent();

        System.out.println("\n--- Results: " + passed + " passed, " + failed + " failed ---");
    }

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

    private static Pokemon makePokemon(int id, String name, int level) {
        return new Pokemon(id, name, "Normal", null, level, 50, 50, 50,
                "Norasua", 0, false, true, true, "Test entry");
    }

    private static void testAddEncounterSetsHasEncountersTrue() {
        EncounterSystem encounters = new EncounterSystem();
        boolean added = encounters.addEncounter(makePokemon(25, "Pikachu", 12));

        assertTrue("addEncounter - returns true for non-null", added);
        assertTrue("hasEncounters - true after one add", encounters.hasEncounters());
    }

    private static void testNextEncounterReturnsHighestLevelFirst() {
        EncounterSystem encounters = new EncounterSystem();
        encounters.addEncounter(makePokemon(7, "Squirtle", 20));
        encounters.addEncounter(makePokemon(4, "Charmander", 35));
        encounters.addEncounter(makePokemon(1, "Bulbasaur", 28));

        Pokemon first = encounters.nextEncounter();
        assertEqual("nextEncounter - highest level returned first", 35, first.getLevel());
        assertEqual("nextEncounter - first Pokemon is Charmander", "Charmander", first.getName());
    }

    private static void testPeekDoesNotRemoveEntry() {
        EncounterSystem encounters = new EncounterSystem();
        encounters.addEncounter(makePokemon(133, "Eevee", 14));
        encounters.addEncounter(makePokemon(39, "Jigglypuff", 18));

        Pokemon peeked = encounters.peekNextEncounter();
        assertEqual("peekNextEncounter - returns highest level", 18, peeked.getLevel());
        assertEqual("peekNextEncounter - does not remove entry", 2, encounters.getEncounterCount());
    }

    private static void testNextEncounterOnEmptyReturnsNull() {
        EncounterSystem encounters = new EncounterSystem();
        Pokemon result = encounters.nextEncounter();

        assertTrue("nextEncounter - empty queue returns null", result == null);
    }

    private static void testEncounterCountBeforeAndAfterPolls() {
        EncounterSystem encounters = new EncounterSystem();
        encounters.addEncounter(makePokemon(10, "Caterpie", 3));
        encounters.addEncounter(makePokemon(11, "Metapod", 7));
        encounters.addEncounter(makePokemon(12, "Butterfree", 15));

        assertEqual("getEncounterCount - count after adds", 3, encounters.getEncounterCount());

        encounters.nextEncounter();
        assertEqual("getEncounterCount - count after one poll", 2, encounters.getEncounterCount());

        encounters.nextEncounter();
        encounters.nextEncounter();
        assertEqual("getEncounterCount - count after all polls", 0, encounters.getEncounterCount());
        assertTrue("hasEncounters - false when queue empty", !encounters.hasEncounters());
    }

    private static void testNaturalComparableByIdRemainsIndependent() {
        Pokemon lowId = makePokemon(1, "Alpha", 99);
        Pokemon highId = makePokemon(100, "Beta", 1);

        assertTrue("Comparable by ID - lower ID sorts before higher ID", lowId.compareTo(highId) < 0);
        assertTrue("Comparable by ID - higher ID sorts after lower ID", highId.compareTo(lowId) > 0);
    }
}
