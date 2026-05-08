package systems;

import java.util.Stack;

// Tracks evolution events using a Stack.
// Supports recording, undoing, and viewing evolution history.
public class EvolutionHistory {
    private final Stack<String> history;

    public EvolutionHistory() {
        this.history = new Stack<>();
    }

    public boolean recordEvolution(String event) {
        if (event == null || event.trim().isEmpty()) {
            return false;
        }
        history.push(event.trim());
        return true;
    }

    public String undoLastEvolution() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }

    public String peekLastEvolution() {
        if (history.isEmpty()) {
            return null;
        }
        return history.peek();
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }

    public int getHistoryCount() {
        return history.size();
    }
}
