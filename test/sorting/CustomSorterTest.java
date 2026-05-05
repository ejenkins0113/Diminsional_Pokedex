package sorting;

import model.Pokemon;
import java.util.ArrayList;

public class CustomSorterTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testSortById();
        testSortByLevel();
        testSortByAttack();
        testSortEmptyListNoThrow();
        testSortSingleElementNoChange();

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

    // Builds a small unsorted list: IDs 30, 10, 20 | Levels 50, 5, 30 | Attacks 80, 40, 60
    private static ArrayList<Pokemon> buildUnsortedList() {
        ArrayList<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(30, "Alpha",  "Fire",  null, 50, 100, 80, 80, "Prime", 2, false, true, true, "A"));
        list.add(new Pokemon(10, "Beta",   "Water", null,  5,  60, 40, 40, "Prime", 0, false, true, true, "B"));
        list.add(new Pokemon(20, "Gamma",  "Grass", null, 30,  80, 60, 60, "Prime", 1, false, true, true, "C"));
        return list;
    }

    // ==== Test Cases ====

    private static void testSortById() {
        ArrayList<Pokemon> list = buildUnsortedList();
        CustomSorter.sort(list, CustomSorter.SortField.ID);
        assertEqual("sortById - first element has lowest ID",  10, list.get(0).getId());
        assertEqual("sortById - second element has mid ID",    20, list.get(1).getId());
        assertEqual("sortById - third element has highest ID", 30, list.get(2).getId());
    }

    private static void testSortByLevel() {
        ArrayList<Pokemon> list = buildUnsortedList();
        CustomSorter.sort(list, CustomSorter.SortField.LEVEL);
        assertEqual("sortByLevel - first element has lowest level",   5, list.get(0).getLevel());
        assertEqual("sortByLevel - second element has mid level",    30, list.get(1).getLevel());
        assertEqual("sortByLevel - third element has highest level", 50, list.get(2).getLevel());
    }

    private static void testSortByAttack() {
        ArrayList<Pokemon> list = buildUnsortedList();
        CustomSorter.sort(list, CustomSorter.SortField.ATTACK);
        assertEqual("sortByAttack - first element has lowest attack",   40, list.get(0).getAttack());
        assertEqual("sortByAttack - second element has mid attack",     60, list.get(1).getAttack());
        assertEqual("sortByAttack - third element has highest attack",  80, list.get(2).getAttack());
    }

    private static void testSortEmptyListNoThrow() {
        ArrayList<Pokemon> list = new ArrayList<>();
        try {
            CustomSorter.sort(list, CustomSorter.SortField.ID);
            assertTrue("sort - empty list does not throw", true);
        } catch (Exception e) {
            assertTrue("sort - empty list does not throw", false);
        }
    }

    private static void testSortSingleElementNoChange() {
        ArrayList<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(5, "Solo", "Psychic", null, 10, 50, 50, 50, "Shadow", 0, false, true, true, "Alone."));
        CustomSorter.sort(list, CustomSorter.SortField.LEVEL);
        assertEqual("sort - single element list unchanged", "Solo", list.get(0).getName());
    }
}
