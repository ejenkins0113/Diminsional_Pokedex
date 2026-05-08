package systems;

public class EvolutionHistoryTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testRecordEvolutionStoresEvent();
        testRecordEvolutionRejectsNullAndBlank();
        testUndoLastEvolutionFollowsLifo();
        testPeekLastEvolutionDoesNotRemove();
        testUndoAndPeekOnEmptyReturnNull();
        testHistoryCountTracksChanges();

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

    private static void testRecordEvolutionStoresEvent() {
        EvolutionHistory history = new EvolutionHistory();
        boolean recorded = history.recordEvolution("Eevee evolved into Vaporeon");

        assertTrue("recordEvolution - valid event returns true", recorded);
        assertTrue("hasHistory - true after valid event", history.hasHistory());
        assertEqual("peekLastEvolution - returns saved event", "Eevee evolved into Vaporeon",
                history.peekLastEvolution());
    }

    private static void testRecordEvolutionRejectsNullAndBlank() {
        EvolutionHistory history = new EvolutionHistory();

        assertTrue("recordEvolution - null rejected", !history.recordEvolution(null));
        assertTrue("recordEvolution - blank rejected", !history.recordEvolution("   "));
        assertEqual("getHistoryCount - remains zero after invalid input", 0, history.getHistoryCount());
    }

    private static void testUndoLastEvolutionFollowsLifo() {
        EvolutionHistory history = new EvolutionHistory();
        history.recordEvolution("Charmander evolved into Charmeleon");
        history.recordEvolution("Charmeleon evolved into Charizard");

        String undone = history.undoLastEvolution();

        assertEqual("undoLastEvolution - removes latest event first",
                "Charmeleon evolved into Charizard", undone);
        assertEqual("peekLastEvolution - previous event becomes top",
                "Charmander evolved into Charmeleon", history.peekLastEvolution());
    }

    private static void testPeekLastEvolutionDoesNotRemove() {
        EvolutionHistory history = new EvolutionHistory();
        history.recordEvolution("Bulbasaur evolved into Ivysaur");

        String peeked = history.peekLastEvolution();

        assertEqual("peekLastEvolution - returns latest event", "Bulbasaur evolved into Ivysaur", peeked);
        assertEqual("peekLastEvolution - does not reduce count", 1, history.getHistoryCount());
    }

    private static void testUndoAndPeekOnEmptyReturnNull() {
        EvolutionHistory history = new EvolutionHistory();

        assertTrue("undoLastEvolution - empty returns null", history.undoLastEvolution() == null);
        assertTrue("peekLastEvolution - empty returns null", history.peekLastEvolution() == null);
    }

    private static void testHistoryCountTracksChanges() {
        EvolutionHistory history = new EvolutionHistory();
        history.recordEvolution("A");
        history.recordEvolution("B");
        history.recordEvolution("C");

        assertEqual("getHistoryCount - count after records", 3, history.getHistoryCount());

        history.undoLastEvolution();
        assertEqual("getHistoryCount - count after undo", 2, history.getHistoryCount());
    }
}