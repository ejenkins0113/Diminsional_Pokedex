# SR1 - Day 1 Retro

**Date:** May 1, 2026
**Sprint Goal:** Set up project structure and implement the Pokemon model class.
**Milestone:** Milestone 1 - Foundation Ready | Status: Done

## Day 1 Coverage Summary
Day 1 focused on building the technical foundation for the full project week. I created the Java package structure, implemented the complete Pokemon model with required attributes and Comparable behavior, added skeleton classes for all planned systems, organized the test structure, and verified that the code compiles and runs basic tests successfully.

## Why Day 1 Succeeded
Day 1 succeeded because the work stayed tightly aligned to the sprint goal and avoided scope creep. The tasks were completed in the correct order (structure first, model second, compile/test verification last), which reduced rework and kept momentum high. The result is a clean, stable baseline that is ready for Day 2 manager logic.

## What Went Well
- Project package structure was created cleanly with all five packages: model, manager, systems, sorting, ui.
- Pokemon class came together quickly with all 14 required fields matching the proposal spec.
- Comparable<Pokemon> was decided and implemented. Default sort by ID is clean and logical.
- All skeleton files were created and the entire project compiles with zero errors on the first attempt.
- Milestone 1 was fully completed on Day 1 as planned.

## What Did Not Go Well
- Nothing notable blocked progress today.

## Improvements for Next Sprint
- On Day 2, move straight into DexManager logic without spending too much time reorganizing.
- Add sample Pokemon data early so the manager operations have something to test against.
- Keep methods focused — DexManager should only handle logic, not model concerns.
