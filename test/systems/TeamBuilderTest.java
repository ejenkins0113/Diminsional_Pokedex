package systems;

import model.Pokemon;

public class TeamBuilderTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testAddToTeamSuccess();
        testAddToTeamRejectsNullAndDuplicate();
        testAddToTeamEnforcesMaxSize();
        testRemoveFromTeamByNameFindsExistingCaseInsensitive();
        testRemoveFromTeamByNameReturnsFalseWhenMissing();
        testContainsAndGetTeamSizeStayAccurate();
        testDisplayTeamDoesNotThrow();

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

    private static Pokemon makePokemon(int id, String name) {
        return new Pokemon(id, name, "Normal", null, 10, 50, 50, 50,
                "Norasua", 0, false, true, true, "Team test entry");
    }

    private static TeamBuilder makeFullTeam() {
        TeamBuilder team = new TeamBuilder();
        team.addToTeam(makePokemon(1, "One"));
        team.addToTeam(makePokemon(2, "Two"));
        team.addToTeam(makePokemon(3, "Three"));
        team.addToTeam(makePokemon(4, "Four"));
        team.addToTeam(makePokemon(5, "Five"));
        team.addToTeam(makePokemon(6, "Six"));
        return team;
    }

    private static void testAddToTeamSuccess() {
        TeamBuilder team = new TeamBuilder();
        boolean added = team.addToTeam(makePokemon(25, "Pikachu"));

        assertTrue("addToTeam - valid Pokemon returns true", added);
        assertEqual("getTeamSize - size increments after add", 1, team.getTeamSize());
    }

    private static void testAddToTeamRejectsNullAndDuplicate() {
        TeamBuilder team = new TeamBuilder();
        team.addToTeam(makePokemon(7, "Squirtle"));

        assertTrue("addToTeam - null rejected", !team.addToTeam(null));
        assertTrue("addToTeam - duplicate name rejected", !team.addToTeam(makePokemon(8, "squirtle")));
        assertEqual("getTeamSize - unchanged after invalid adds", 1, team.getTeamSize());
    }

    private static void testAddToTeamEnforcesMaxSize() {
        TeamBuilder team = makeFullTeam();
        boolean added = team.addToTeam(makePokemon(7, "Seven"));

        assertTrue("addToTeam - seventh Pokemon rejected", !added);
        assertEqual("getTeamSize - max size remains six", 6, team.getTeamSize());
    }

    private static void testRemoveFromTeamByNameFindsExistingCaseInsensitive() {
        TeamBuilder team = new TeamBuilder();
        team.addToTeam(makePokemon(133, "Eevee"));

        boolean removed = team.removeFromTeamByName("eevee");

        assertTrue("removeFromTeamByName - existing name removed case-insensitively", removed);
        assertEqual("getTeamSize - size decrements after remove", 0, team.getTeamSize());
    }

    private static void testRemoveFromTeamByNameReturnsFalseWhenMissing() {
        TeamBuilder team = new TeamBuilder();
        team.addToTeam(makePokemon(39, "Jigglypuff"));

        assertTrue("removeFromTeamByName - missing name returns false",
                !team.removeFromTeamByName("Snorlax"));
    }

    private static void testContainsAndGetTeamSizeStayAccurate() {
        TeamBuilder team = new TeamBuilder();
        team.addToTeam(makePokemon(4, "Charmander"));
        team.addToTeam(makePokemon(1, "Bulbasaur"));

        assertTrue("contains - finds uppercase input", team.contains("CHARMANDER"));
        assertTrue("contains - false for missing name", !team.contains("Mewtwo"));
        assertEqual("getTeamSize - count after two adds", 2, team.getTeamSize());
    }

    private static void testDisplayTeamDoesNotThrow() {
        TeamBuilder emptyTeam = new TeamBuilder();
        TeamBuilder filledTeam = new TeamBuilder();
        filledTeam.addToTeam(makePokemon(150, "Mewtwo"));

        try {
            System.out.println("[INFO] displayTeam on empty team:");
            emptyTeam.displayTeam();
            System.out.println("[INFO] displayTeam with one Pokemon:");
            filledTeam.displayTeam();
            assertTrue("displayTeam - executes without throwing", true);
        } catch (Exception e) {
            assertTrue("displayTeam - executes without throwing", false);
        }
    }
}