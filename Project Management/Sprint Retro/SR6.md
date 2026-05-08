# SR6 - Day 6 Retro

**Date:** May 8, 2026
**Sprint Goal:** Complete Milestone 4 by implementing EvolutionHistory and TeamBuilder with full tests and no regressions.
**Milestone:** Milestone 4 - Evolution and Team Ready | Status: Done

## Day 6 Coverage Summary
- Implemented `EvolutionHistory` with stack-based record, peek, undo, and count operations.
- Implemented `TeamBuilder` with a max team size of 6, duplicate rejection by name, case-insensitive remove/contains, and team display.
- Added `EvolutionHistoryTest` and `TeamBuilderTest`.
- Ran full regression successfully: 129/129 checks passed.

## What Went Well
- The required Day 6 data structures mapped cleanly to the implementation plan: `Stack<String>` for evolution history and `ArrayList<Pokemon>` for team management.
- Focused tests caught the intended edge cases early, especially empty stack safety and duplicate team prevention.
- Full regression passed immediately after the Day 6 additions, which reduced integration risk heading into Day 7.

## What Did Not Go Well
- No major blockers surfaced during implementation.
- Display behavior is still console-output based, so verification for printed output remains mostly visual rather than assertion-driven.

## Improvements for Next Sprint
- Integrate both Day 6 systems into the console menu first so final testing exercises real user flows instead of isolated class behavior.
- Keep using focused suite-first validation before running full regression to preserve fast feedback.
- If time permits, add more assertion-driven coverage around console output formatting to reduce reliance on manual inspection.
