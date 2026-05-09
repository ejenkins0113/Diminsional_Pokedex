# SP7 - Day 7 Plan

## Sprint Goal
Complete Milestone 5 by integrating all implemented systems into the console menu, finishing final validation, and preparing the project for demo submission.

## Day 7 Objectives
- Integrate `DexManager`, `CustomSorter`, `EncounterSystem`, `EvolutionHistory`, and `TeamBuilder` into `MainMenu`
- Add safe console navigation and invalid-input handling for all menu flows
- Run the complete test checklist and final regression suites
- Perform final cleanup on console output, prompts, and project documentation

## Planned Tasks
1. Console menu integration:
	- Wire menu options to existing manager, sorting, and system features
	- Ensure sample data can be loaded and exercised from the UI
	- Add clear prompts for viewing, filtering, sorting, encounters, evolution history, and team management
2. Input validation and flow control:
	- Guard against invalid numeric choices and empty text inputs
	- Prevent menu crashes from bad input or empty data states
	- Provide user-friendly fallback messages for unsupported actions
3. Final verification:
	- Re-run all existing test suites
	- Walk through the console menu manually for each feature path
	- Complete the remaining items in the Test Checklist
4. Documentation and release prep:
	- Update Milestones, Task Board, Test Checklist, and SR7
	- Confirm the project is demo-ready with stable output and clear usage flow

## Definition of Done
- `MainMenu` exposes all major project features through working menu options
- Invalid input is handled safely without crashing the program
- Test Checklist is fully completed
- Full regression suites pass with no failures
- Milestone 5 can be marked Done

## Risks and Mitigation
- Risk: Menu integration could expose edge cases not covered by unit tests.
- Mitigation: Pair automated regression with a focused manual walkthrough of every menu path.
- Risk: Input parsing errors could crash the final demo flow.
- Mitigation: Centralize validation and handle invalid selections defensively.
- Risk: Day 7 can expand into UI polish instead of completion.
- Mitigation: Keep scope focused on integration, stability, and demo readiness.

## Deliverables
- `src/ui/MainMenu.java` integrated with all implemented systems
- Final Test Checklist completed
- Milestone 5 marked complete
- Day 7 retro written with final project outcome summary

## Day 7 Execution Outcome (May 8, 2026)
- Status: Completed
- Integration completed:
	- `MainMenu` now wires DexManager, CustomSorter, EncounterSystem, EvolutionHistory, and TeamBuilder
	- Menu navigation includes full input validation for numeric and text prompts
	- Empty-state safety added for dex, encounter queue, and team operations
- Validation results:
	- Compile all source and test files: Passed
	- `manager.DexManagerTest`: 22 passed, 0 failed
	- `manager.DexManagerFilterTest`: 14 passed, 0 failed
	- `model.PokemonTest`: 41 passed, 0 failed
	- `sorting.CustomSorterTest`: 11 passed, 0 failed
	- `systems.EncounterSystemTest`: 13 passed, 0 failed
	- `systems.EvolutionHistoryTest`: 14 passed, 0 failed
	- `systems.TeamBuilderTest`: 14 passed, 0 failed
	- Total: 129 passed, 0 failed
- Manual console walkthrough:
	- Menu navigation confirmed across search, filter, sort, encounter, evolution, and team flows
	- Invalid numeric input handling confirmed (no crash)
	- Exit flow confirmed
