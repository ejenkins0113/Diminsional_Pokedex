package systems;

import model.Pokemon;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Simulates wild encounters using a priority queue.
 *
 * <p>Higher-level Pokemon are processed first.</p>
 */
public class EncounterSystem {
    private final PriorityQueue<Pokemon> encounterQueue;

    /**
     * Creates an empty encounter queue ordered by descending level.
     */
    public EncounterSystem() {
        this.encounterQueue = new PriorityQueue<>(
                Comparator.comparingInt(Pokemon::getLevel).reversed()
        );
    }

    /**
     * Adds a Pokemon encounter to the queue.
     *
     * @param pokemon Pokemon to enqueue
     * @return true when queued, false for null input
     */
    public boolean addEncounter(Pokemon pokemon) {
        if (pokemon == null) {
            return false;
        }
        return encounterQueue.offer(pokemon);
    }

    /**
     * Resolves and removes the highest-priority encounter.
     *
     * @return next Pokemon encounter, or null if queue is empty
     */
    public Pokemon nextEncounter() {
        return encounterQueue.poll();
    }

    /**
     * Peeks at the next encounter without removing it.
     *
     * @return next Pokemon encounter, or null if queue is empty
     */
    public Pokemon peekNextEncounter() {
        return encounterQueue.peek();
    }

    /**
     * Checks whether there are pending encounters.
     *
     * @return true when queue has at least one entry
     */
    public boolean hasEncounters() {
        return !encounterQueue.isEmpty();
    }

    /**
     * Returns current queue size.
     *
     * @return number of queued encounters
     */
    public int getEncounterCount() {
        return encounterQueue.size();
    }
}
