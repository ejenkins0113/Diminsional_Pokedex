package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokemonTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testConstructorAndGetters();
        testToStringSingleType();
        testToStringDualType();
        testToStringMega();
        testToStringSeenNotCaught();
        testToStringUnseen();
        testSetters();
        testCompareTo();
        testSortByIdWithCollections();

        System.out.println("\n--- Results: " + passed + " passed, " + failed + " failed ---");
    }

    // =============================assertion helpers ===================================== 

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

    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            failed++;
        }
    }

    // ============================= test cases =====================================

    private static void testConstructorAndGetters() {
        Pokemon p = new Pokemon(1, "Flamora", "Fire", null,
                10, 45, 50, 30, "Prime", 0, false, true, true,
                "A flame-type starter from the Prime dimension.");

        assertEqual("Constructor - id",          1,        p.getId());
        assertEqual("Constructor - name",        "Flamora", p.getName());
        assertEqual("Constructor - primaryType", "Fire",    p.getPrimaryType());
        assertEqual("Constructor - level",       10,        p.getLevel());
        assertEqual("Constructor - hp",          45,        p.getHp());
        assertEqual("Constructor - attack",      50,        p.getAttack());
        assertEqual("Constructor - defense",     30,        p.getDefense());
        assertEqual("Constructor - dimension",   "Prime",   p.getDimension());
        assertEqual("Constructor - evolutionStage", 0,      p.getEvolutionStage());
        assertTrue ("Constructor - isMega false",          !p.isMega());
        assertTrue ("Constructor - seen true",              p.isSeen());
        assertTrue ("Constructor - caught true",            p.isCaught());
    }

    private static void testToStringSingleType() {
        Pokemon p = new Pokemon(5, "Aqualis", "Water", null,
                15, 60, 40, 55, "Aqua", 1, false, true, true, "Water guardian.");
        String out = p.toString();
        assertTrue("toString - single type no /", !out.contains("/"));
        assertTrue("toString - contains name",     out.contains("Aqualis"));
        assertTrue("toString - contains #005",     out.contains("#005"));
        assertTrue("toString - contains Caught",   out.contains("Caught"));
    }

    private static void testToStringDualType() {
        Pokemon p = new Pokemon(7, "Terravine", "Grass", "Ground",
                20, 55, 48, 60, "Terra", 1, false, true, true, "Dual-type titan.");
        String out = p.toString();
        assertTrue("toString - dual type contains /", out.contains("Grass/Ground"));
    }

    private static void testToStringMega() {
        Pokemon p = new Pokemon(9, "Megaflare", "Fire", "Dragon",
                50, 100, 130, 80, "Prime", 2, true, true, true, "Mega evolved.");
        String out = p.toString();
        assertTrue("toString - MEGA tag present", out.contains("[MEGA]"));
    }

    private static void testToStringSeenNotCaught() {
        Pokemon p = new Pokemon(3, "Shadowix", "Ghost", null,
                12, 40, 35, 25, "Shadow", 0, false, true, false, "A ghostly form.");
        String out = p.toString();
        assertTrue("toString - Seen (not caught)", out.contains("Seen"));
        assertTrue("toString - not Caught",       !out.contains("Caught"));
    }

    private static void testToStringUnseen() {
        Pokemon p = new Pokemon(4, "Mistral", "Flying", null,
                8, 38, 30, 28, "Sky", 0, false, false, false, "Wind wanderer.");
        String out = p.toString();
        assertTrue("toString - Unseen status", out.contains("Unseen"));
    }

    private static void testSetters() {
        Pokemon p = new Pokemon(2, "Boulok", "Rock", null,
                5, 35, 25, 70, "Prime", 0, false, false, false, "Rocky starter.");

        p.setLevel(20);
        p.setHp(80);
        p.setAttack(60);
        p.setDefense(90);
        p.setSeen(true);
        p.setCaught(true);
        p.setMega(true);
        p.setSecondaryType("Ground");
        p.setDimension("Terra");
        p.setEvolutionStage(1);
        p.setName("Boulokus");
        p.setPrimaryType("Rock");
        p.setDescription("Evolved form.");
        p.setId(22);

        assertEqual("Setter - level",         20,       p.getLevel());
        assertEqual("Setter - hp",            80,       p.getHp());
        assertEqual("Setter - attack",        60,       p.getAttack());
        assertEqual("Setter - defense",       90,       p.getDefense());
        assertTrue ("Setter - seen",                    p.isSeen());
        assertTrue ("Setter - caught",                  p.isCaught());
        assertTrue ("Setter - mega",                    p.isMega());
        assertEqual("Setter - secondaryType", "Ground", p.getSecondaryType());
        assertEqual("Setter - dimension",     "Terra",  p.getDimension());
        assertEqual("Setter - evolutionStage", 1,       p.getEvolutionStage());
        assertEqual("Setter - name",          "Boulokus", p.getName());
        assertEqual("Setter - description",   "Evolved form.", p.getDescription());
        assertEqual("Setter - id",            22,       p.getId());
    }

    private static void testCompareTo() {
        Pokemon a = new Pokemon(1, "Alpha", "Fire", null, 10, 40, 40, 40, "Prime", 0, false, false, false, "");
        Pokemon b = new Pokemon(5, "Beta",  "Water", null, 10, 40, 40, 40, "Prime", 0, false, false, false, "");
        Pokemon c = new Pokemon(5, "Gamma", "Grass", null, 10, 40, 40, 40, "Prime", 0, false, false, false, "");

        assertTrue("compareTo - lower id comes first",  a.compareTo(b) < 0);
        assertTrue("compareTo - higher id comes after", b.compareTo(a) > 0);
        assertEqual("compareTo - same id returns 0",    0, a.compareTo(a));
        assertEqual("compareTo - equal ids return 0",   0, b.compareTo(c));
    }

    private static void testSortByIdWithCollections() {
        Pokemon p1 = new Pokemon(10, "Zephyr",  "Flying", null, 5, 30, 30, 30, "Sky",   0, false, false, false, "");
        Pokemon p2 = new Pokemon(3,  "Crysol",  "Ice",    null, 5, 30, 30, 30, "Frost", 0, false, false, false, "");
        Pokemon p3 = new Pokemon(7,  "Emberon", "Fire",   null, 5, 30, 30, 30, "Prime", 0, false, false, false, "");

        List<Pokemon> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list);

        assertEqual("Collections.sort - first is id 3",  3,  list.get(0).getId());
        assertEqual("Collections.sort - second is id 7", 7,  list.get(1).getId());
        assertEqual("Collections.sort - third is id 10", 10, list.get(2).getId());
    }
}
