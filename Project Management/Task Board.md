# Task Board

## To Do
- Build encounter system using PriorityQueue
- Build evolution history stack with undo
- Build team builder add/remove/display
- Integrate console menu
- Run final testing and cleanup

## In Progress
- None

## Done
- Project management structure created
- Sprint planning converted to markdown files
- Sprint retro converted to markdown files
- src/ package structure created (model, manager, systems, sorting, ui)
- Pokemon class implemented with all fields, constructor, getters, setters, toString, and Comparable
- Skeleton class files created for DexManager, EncounterSystem, EvolutionHistory, TeamBuilder, CustomSorter, MainMenu
- All files compile cleanly
- DexManager core implemented: addPokemon, removePokemonByName, searchByName, displayAllPokemon
- Name normalization and duplicate-rejection logic in place
- 8 sample Pokemon seeded across Prime, Shadow, Ruins, and Storm dimensions
- DexManager compiles cleanly
- filterByType and filterByDimension added to DexManager (case-insensitive, returns empty list on no match)
- CustomSorter implemented: SortField enum (ID, LEVEL, ATTACK) and Selection Sort algorithm
- DexManagerFilterTest written and passing: 14/14
- CustomSorterTest written and passing: 11/11
- Total test count: 88/88 across all suites
