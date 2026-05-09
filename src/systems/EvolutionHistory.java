package systems;

import java.util.Stack;

/**
 * Tracks evolution events using a stack (LIFO).
 */
public class EvolutionHistory {
    private final Stack<String> history;

    /**
     * Creates an empty evolution history.
     */
    public EvolutionHistory() {
        this.history = new Stack<>();
    }

    /**
     * Records a new evolution event.
     *
     * @param event event description
     * @return true when event is non-empty and recorded
     */
    public boolean recordEvolution(String event) {
        if (event == null || event.trim().isEmpty()) {
            return false;
        }
        history.push(event.trim());
        return true;
    }

    /**
     * Undoes the most recent evolution event.
     *
     * @return removed event, or null when no history exists
     */
    public String undoLastEvolution() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }

    /**
     * Returns the most recent evolution event without removing it.
     *
     * @return latest event, or null when history is empty
     */
    public String peekLastEvolution() {
        if (history.isEmpty()) {
            return null;
        }
        return history.peek();
    }

    /**
     * Checks whether any evolution events are stored.
     *
     * @return true when history has at least one event
     */
    public boolean hasHistory() {
        return !history.isEmpty();
    }

    /**
     * Returns number of events currently stored.
     *
     * @return history size
     */
    public int getHistoryCount() {
        return history.size();
    }
}
