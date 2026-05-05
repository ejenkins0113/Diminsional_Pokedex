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
