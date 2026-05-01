# SP2 - Day 2 Plan

## Sprint Goal
Build the core `DexManager` logic so the app can manage Pokemon data reliably through add, remove, search, and display operations.

## Day 2 Objectives
- Implement storage structures in `DexManager`:
  - `ArrayList<Pokemon>` for ordered collection storage
  - `HashMap<String, Pokemon>` for fast name-based lookup
- Build core methods:
  - `addPokemon(Pokemon pokemon)`
  - `removePokemonByName(String name)`
  - `searchByName(String name)`
  - `displayAllPokemon()`
- Define duplicate-name handling rule (reject duplicates by normalized name key).
- Add starter sample data for validation and testing.
- Compile and run sanity tests for manager behavior.

## Planned Tasks
1. Set up `DexManager` fields and constructor initialization.
2. Implement add logic:
	- Validate input is not null.
	- Normalize name key (`trim + toLowerCase`) for consistent map keys.
	- Reject duplicate names.
	- Keep list and map synchronized on successful add.
3. Implement remove logic:
	- Remove from map by normalized key.
	- Remove the same Pokemon instance from list.
	- Return success/failure boolean.
4. Implement search logic:
	- Return Pokemon by normalized name lookup.
	- Return `null` when not found.
5. Implement display logic:
	- Print each Pokemon with `toString()`.
	- Handle empty dex message cleanly.
6. Seed sample data:
	- Add at least 6 Pokemon across multiple types/dimensions.
7. Verify behavior:
	- Add unique Pokemon succeeds.
	- Duplicate add is blocked.
	- Search returns correct entries.
	- Remove updates both list and map.

## Definition of Done
- `DexManager` has working add, remove, search, and display methods.
- List and map stay consistent after each operation.
- Duplicate-name rule is implemented and tested.
- Sample data is available for tomorrow's filtering work.
- Code compiles without errors.

## Risks and Mitigation
- Risk: list/map can get out of sync if remove/add flow is inconsistent.
- Mitigation: always treat map as source for lookup and keep one synchronized update path.
- Risk: inconsistent name casing causes duplicate or missed searches.
- Mitigation: enforce one normalized key strategy in all manager methods.

## Deliverables
- Working `DexManager` core operation methods
- Name normalization and duplicate-check rule in place
- Starter Pokemon dataset for integration and Day 3 filtering features
