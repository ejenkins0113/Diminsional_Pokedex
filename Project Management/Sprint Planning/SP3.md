# SP3 - Day 3 Plan

## Sprint Goal
Complete Milestone 2 by adding filter operations to `DexManager`, and implement the custom sorting algorithm in `CustomSorter` to satisfy Milestone 3 sorting requirements.

## Day 3 Objectives
- Add filter methods to `DexManager`:
  - `filterByType(String type)` — returns all Pokemon matching primary or secondary type
  - `filterByDimension(String dimension)` — returns all Pokemon from a given dimension
- Implement `CustomSorter`:
  - Bubble Sort or Selection Sort algorithm
  - Sort by level, attack, or ID
  - Works on an `ArrayList<Pokemon>`
- Verify `Comparable<Pokemon>` default sort by ID still works alongside custom sorter
- Compile and run tests for all new behavior

## Planned Tasks
1. Add `filterByType(String type)` to `DexManager`:
   - Iterate `pokemonList`
   - Match against `primaryType` and `secondaryType` (case-insensitive)
   - Return a new `ArrayList<Pokemon>` with results
   - Return empty list (not null) if no matches
2. Add `filterByDimension(String dimension)` to `DexManager`:
   - Iterate `pokemonList`
   - Match against `dimension` field (case-insensitive)
   - Return a new `ArrayList<Pokemon>` with results
   - Return empty list (not null) if no matches
3. Implement `CustomSorter`:
   - Define a `SortField` enum: `ID`, `LEVEL`, `ATTACK`
   - Implement one algorithm (Selection Sort) that accepts a list and a `SortField`
   - Sort in ascending order
4. Write `DexManagerFilterTest`:
   - Filter by type returns correct Pokemon
   - Filter by dimension returns correct Pokemon
   - Filter with no matches returns empty list
   - Case-insensitive matching works
5. Write `CustomSorterTest`:
   - Sort by ID produces ascending ID order
   - Sort by level produces ascending level order
   - Sort by attack produces ascending attack order
   - Empty list does not throw
6. Compile everything and run all tests

## Definition of Done
- `filterByType` and `filterByDimension` return correct results from sample data
- Filters return empty list (not null) when no matches found
- `CustomSorter` sorts correctly by ID, level, and attack
- All new tests pass
- Code compiles without errors

## Risks and Mitigation
- Risk: filter results accidentally modify the original list.
- Mitigation: always return a new list, never a sublist or reference to `pokemonList`.
- Risk: sorter mutates the original list when caller expects a copy.
- Mitigation: sort in-place and document that behavior clearly, or accept a copy — decide before implementing.

## Deliverables
- `filterByType` and `filterByDimension` methods in `DexManager`
- `CustomSorter` class with working sort algorithm and `SortField` enum
- `DexManagerFilterTest` and `CustomSorterTest` passing
- Milestone 2 fully completed
- Milestone 3 sorting requirement satisfied
