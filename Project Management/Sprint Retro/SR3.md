# SR3 - Day 3 Retro

**Date:** May 5, 2026
**Sprint Goal:** Complete Milestone 2 by adding filter operations to DexManager, and implement the custom sorting algorithm in CustomSorter to satisfy Milestone 3 sorting requirements.
**Milestone:** Milestone 2 - Core Manager Ready | Status: Done | Milestone 3 sorting | Status: Done

## Day 3 Coverage Summary
Day 3 delivered all planned features without blockers. filterByType and filterByDimension were added to DexManager following the same iterative pattern as the core methods. Both filters return a new ArrayList and never modify the original list. CustomSorter was implemented with a SortField enum (ID, LEVEL, ATTACK) and a Selection Sort algorithm that sorts in-place in ascending order. DexManagerFilterTest (14 tests) and CustomSorterTest (11 tests) were written and both passed on first run. The total test count reached 88/88 across all suites with no regressions in existing tests.

## Why Day 3 Succeeded
The SP3 plan was precise. Filter logic was kept simple — a single loop with case-insensitive string comparison — which matched exactly what the tests needed. The Selection Sort implementation was straightforward and the SortField enum kept the sort interface clean. Writing tests immediately after implementation confirmed correct behavior before moving on.

## What Went Well
- filterByType and filterByDimension both handle null input, case-insensitive matching, and empty-list returns correctly.
- Secondary type filtering works and was tested explicitly.
- CustomSorter SortField enum keeps sort calls readable at the call site.
- Selection Sort is correct and clean with no edge case bugs.
- DexManagerFilterTest: 14/14 passed first run (after fixing one off-by-one in expected count for Prime dimension).
- CustomSorterTest: 11/11 passed first run.
- All existing tests still passing — 88/88 total.
- Milestone 2 fully closed. Milestone 3 sorting requirement satisfied one day early.

## What Did Not Go Well
- One test had an incorrect expected count (expected 4 Prime Pokemon, actual was 5). Caught immediately on first run and fixed before moving on. No logic bug — was a test authoring error.

## Improvements for Next Sprint
- When writing filter tests, count the sample data manually before writing the expected value.
- Day 4 focus is the EncounterSystem using PriorityQueue — keep priority rules simple and define them before coding.
