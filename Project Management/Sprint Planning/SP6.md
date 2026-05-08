# SP6 - Day 6 Plan

## Sprint Goal
Complete Milestone 4 by implementing EvolutionHistory (stack with undo) and TeamBuilder (team management up to 6 Pokemon), with tests and regression validation.

## Day 6 Objectives
- Implement `EvolutionHistory` using `Stack<String>`:
  - `recordEvolution(String event)`
  - `undoLastEvolution()`
  - `peekLastEvolution()`
  - `hasHistory()`
  - `getHistoryCount()`
- Implement `TeamBuilder` for team operations:
  - max team size of 6
  - `addToTeam(Pokemon pokemon)`
  - `removeFromTeamByName(String name)`
  - `contains(String name)`
  - `getTeamSize()`
- Write tests for both systems and run full regression suites

## Planned Tasks
1. EvolutionHistory implementation:
	- Use `Stack<String>` as backing structure
	- Reject null/blank events in `recordEvolution`
	- Return null for undo/peek when history is empty
2. EvolutionHistory test coverage:
	- record + hasHistory behavior
	- LIFO undo correctness
	- empty stack safety for undo/peek
	- count accuracy
3. TeamBuilder implementation:
	- Backing store as `ArrayList<Pokemon>`
	- Reject null, duplicates by name, and size overflow
	- Case-insensitive name operations for remove/contains
4. TeamBuilder test coverage:
	- add success path
	- duplicate reject
	- max size enforcement at 6
	- remove existing/missing behavior
	- contains and size accuracy
5. Validation and closeout:
	- Compile all source and test files
	- Run all suites including new systems tests
	- Update Milestones, Task Board, Test Checklist, and SR6

## Definition of Done
- EvolutionHistory stack operations are implemented and tested
- TeamBuilder operations are implemented and tested
- Milestone 4 can be marked Done
- Full regression suites pass with no failures

## Risks and Mitigation
- Risk: Duplicate team entries create inconsistent team state.
- Mitigation: Normalize names and enforce duplicate check on add.
- Risk: Stack underflow behavior could cause runtime issues.
- Mitigation: Return null safely for undo/peek on empty history.
- Risk: Scope creep into Day 7 integration.
- Mitigation: Keep Day 6 strictly focused on systems + tests.

## Deliverables
- `src/systems/EvolutionHistory.java` implemented
- `src/systems/TeamBuilder.java` implemented
- `test/systems/EvolutionHistoryTest.java` added and passing
- `test/systems/TeamBuilderTest.java` added and passing
- Regression summary documented for Day 6
