# Test Checklist

## Core Data Model
- [ ] Pokemon object can be created with all required fields
- [ ] Optional secondary type works correctly
- [ ] toString displays readable information

## Dex Manager
- [ ] Add Pokemon works
- [ ] Remove Pokemon works
- [ ] Search by name works
- [ ] Display all Pokemon works

## Filtering and Sorting
- [ ] Filter by type works
- [ ] Filter by dimension works
- [ ] Comparable ordering works as expected
- [ ] Custom sorting algorithm works for selected attribute

## Encounter System
- [ ] PriorityQueue enqueue works
- [ ] Encounter dequeue follows priority rules

## Evolution History
- [ ] Evolution events are recorded
- [ ] Undo evolution reverts latest event
- [ ] Empty stack undo is handled safely

## Team Builder
- [ ] Add to team works
- [ ] Remove from team works
- [ ] Display current team works

## Integration and Stability
- [ ] Console menu navigates all features
- [ ] Invalid user input is handled safely
- [ ] No crashes in normal usage
