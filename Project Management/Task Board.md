# Task Board

## To Do
- Run final testing and cleanup

## In Progress
- Integrate console menu with all systems
- Add invalid-input handling across menu flows
- Prepare final demo validation pass

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
- EncounterSystem implemented: PriorityQueue with level-descending encounter priority
- EncounterSystemTest written and passing: 13/13
- Full regression suites passing: 101/101
- EvolutionHistory implemented: stack-based record, peek, undo, and count behavior
- EvolutionHistoryTest written and passing: 14/14
- TeamBuilder implemented: max size 6, duplicate rejection, remove/contains/display
- TeamBuilderTest written and passing: 14/14
- Full regression suites passing: 129/129
