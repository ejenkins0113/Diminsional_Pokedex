package sorting;

import model.Pokemon;
import java.util.ArrayList;

/**
 * Provides custom in-place sorting for Pokemon collections using Selection Sort.
 */
public class CustomSorter {

    /**
     * Supported sort keys.
     */
    public enum SortField {
        ID, LEVEL, ATTACK
    }

    /**
     * Sorts the provided list in ascending order by the selected field.
     *
     * @param list list to sort in-place
     * @param field attribute used for ordering
     */
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

    /**
     * Extracts the numeric value used for comparison.
     *
     * @param p Pokemon to evaluate
     * @param field selected sort field
     * @return integer value corresponding to the chosen field
     */
    private static int getValue(Pokemon p, SortField field) {
        switch (field) {
            case ID:     return p.getId();
            case LEVEL:  return p.getLevel();
            case ATTACK: return p.getAttack();
            default:     return p.getId();
        }
    }
}
