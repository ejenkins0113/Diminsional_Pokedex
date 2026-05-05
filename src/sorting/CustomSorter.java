package sorting;

import model.Pokemon;
import java.util.ArrayList;

// Custom sorting using Selection Sort.
// Sorts a list of Pokemon in ascending order by a chosen field.
public class CustomSorter {

    // ==== SortField  ====
    public enum SortField {
        ID, LEVEL, ATTACK
    }

    // ==== Selection Sort ====
    // Sorts the list in-place in ascending order by the given field.
    // Does nothing if the list is null or has fewer than 2 elements.
    public static void sort(ArrayList<Pokemon> list, SortField field) {
        if (list == null || list.size() < 2) 
            return;

        int index = list.size();
        for (int i = 0; i < index - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < index; j++) {
                if (getValue(list.get(j), field) < getValue(list.get(minIndex), field)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Pokemon temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    // ==== Field Value Extractor ====
    private static int getValue(Pokemon p, SortField field) {
        switch (field) {
            case ID:     return p.getId();
            case LEVEL:  return p.getLevel();
            case ATTACK: return p.getAttack();
            default:     return p.getId();
        }
    }
}
