package systems;

import model.Pokemon;
import java.util.Comparator;
import java.util.PriorityQueue;

// Simulates wild Pokemon encounters using a PriorityQueue.
// Pokemon with higher priority (rarity/level) surface first.
public class EncounterSystem {
    private final PriorityQueue<Pokemon> encounterQueue;

    public EncounterSystem() {
        this.encounterQueue = new PriorityQueue<>(
                Comparator.comparingInt(Pokemon::getLevel).reversed()
        );
    }

    public boolean addEncounter(Pokemon pokemon) {
        if (pokemon == null) {
            return false;
        }
        return encounterQueue.offer(pokemon);
    }

    public Pokemon nextEncounter() {
        return encounterQueue.poll();
    }

    public Pokemon peekNextEncounter() {
        return encounterQueue.peek();
    }

    public boolean hasEncounters() {
        return !encounterQueue.isEmpty();
    }

    public int getEncounterCount() {
        return encounterQueue.size();
    }
}
