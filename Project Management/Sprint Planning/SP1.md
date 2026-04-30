# SP1 - Day 1 Plan

## Sprint Goal
Set up the technical foundation of Dimensional Dex by creating the core project structure and the Pokemon model class.

## Day 1 Objectives
- Confirm folder and package structure for source code.
- Create the initial Java class files needed to start development.
- Build the Pokemon class with all required attributes from the proposal.
- Define the default Comparable behavior for Pokemon.

## Planned Tasks
1. Create base classes in src folders:
   - model: Pokemon
   - manager: DexManager
   - systems: EncounterSystem, EvolutionHistory, TeamBuilder
   - sorting: CustomSorter
   - ui: MainMenu or Main
2. Implement Pokemon fields:
   - id, name
   - primaryType, secondaryType
   - level, hp, attack, defense
   - dimension
   - evolutionStage
   - isMega
   - seen, caught
   - description
3. Add constructor, getters, setters, and toString in Pokemon.
4. Implement Comparable<Pokemon> in Pokemon.
5. Decide and document compareTo rule (default sort by id).
6. Compile-check to confirm no syntax errors.

## Definition of Done
- Pokemon class exists and compiles.
- Comparable<Pokemon> is implemented and documented.
- Core class skeletons exist in each package.
- Project is ready for Day 2 manager logic work.

## Risks and Notes
- Risk: Overdesigning class logic on Day 1 can delay progress.
- Mitigation: Keep Day 1 focused on structure and model only.
- Note: Hardcoded sample data can be added on Day 2.

## Deliverables
- Working Pokemon model class
- Initial class skeletons in all key packages
- Clean starting point for SP2
