# SP4 - Day 4 Plan

## Sprint Goal
Complete Milestone 3 by implementing the EncounterSystem using PriorityQueue, so the app can simulate wild Pokemon encounters ordered by priority.

## Day 4 Objectives
- Implement `EncounterSystem` using `PriorityQueue<Pokemon>`:
  - Define encounter priority rule (higher level = higher priority)
  - `addEncounter(Pokemon pokemon)` — adds to the queue
  - `nextEncounter()` — removes and returns the highest-priority Pokemon
  - `peekNextEncounter()` — returns highest-priority without removing
  - `hasEncounters()` — returns true if queue is non-empty
  - `getEncounterCount()` — returns current queue size
- Verify that `Comparable<Pokemon>` default sort (by ID) still works independently of encounter priority
- Compile and run tests for all new behavior

## Planned Tasks
1. Decide priority rule for encounters:
   - Use a max-heap on level: higher level Pokemon surface first
   - Implement via a `Comparator` passed to the PriorityQueue constructor (reverses natural level order)
2. Implement `EncounterSystem`:
   - Field: `PriorityQueue<Pokemon> encounterQueue`
   - Constructor: initialize queue with level-descending comparator
   - `addEncounter` — validates non-null, adds to queue
   - `nextEncounter` — returns null if empty, otherwise polls
   - `peekNextEncounter` — returns null if empty, otherwise peeks
   - `hasEncounters` — delegates to `!encounterQueue.isEmpty()`
   - `getEncounterCount` — delegates to `encounterQueue.size()`
3. Write `EncounterSystemTest`:
   - Add one Pokemon and verify `hasEncounters` is true
   - Add multiple Pokemon and verify `nextEncounter` returns highest-level first
   - Verify `peekNextEncounter` does not remove the entry
   - Verify `nextEncounter` on empty queue returns null
   - Verify `getEncounterCount` is accurate before and after polls
4. Compile everything and run all tests

## Definition of Done
- `EncounterSystem` uses `PriorityQueue` with level-descending priority
- `nextEncounter` always returns the highest-level Pokemon in the queue
- All new tests pass
- No regressions in existing 88 tests

## Risks and Mitigation
- Risk: Java's PriorityQueue is a min-heap by default — must use a comparator to invert to max-heap.
- Mitigation: Pass `Comparator.comparingInt(Pokemon::getLevel).reversed()` in the constructor.
- Risk: Encounter priority rule conflicts with Comparable default (ID).
- Mitigation: Comparable stays untouched — EncounterSystem uses its own Comparator, fully independent.

## Deliverables
- `EncounterSystem` class fully implemented
- `EncounterSystemTest` passing
- Milestone 3 fully completed
