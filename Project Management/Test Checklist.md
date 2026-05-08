# Test Checklist

## Core Data Model
- [x] Pokemon object can be created with all required fields
- [x] Optional secondary type works correctly
- [x] toString displays readable information

## Dex Manager
- [x] Add Pokemon works
- [x] Remove Pokemon works
- [x] Search by name works
- [x] Display all Pokemon works

## Filtering and Sorting
- [x] Filter by type works
- [x] Filter by dimension works
- [x] Comparable ordering works as expected
- [x] Custom sorting algorithm works for selected attribute

## Encounter System
- [x] PriorityQueue enqueue works
- [x] Encounter dequeue follows priority rules

## Evolution History
- [x] Evolution events are recorded
- [x] Undo evolution reverts latest event
- [x] Empty stack undo is handled safely

## Team Builder
- [x] Add to team works
- [x] Remove from team works
- [x] Display current team works

## Integration and Stability
- [ ] Console menu navigates all features
- [ ] Invalid user input is handled safely
- [ ] No crashes in normal usage

## Day 6 Execution Priority
1. Complete all Evolution History checks first.
2. Complete all Team Builder checks second.
3. Run full regression after both systems suites pass.
