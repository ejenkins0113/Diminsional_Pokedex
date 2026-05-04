# SR2 - Day 2 Retro

**Date:** May 4, 2026
**Sprint Goal:** Build the core DexManager logic so the app can manage Pokemon data reliably through add, remove, search, and display operations.
**Milestone:** Milestone 2 - Core Manager Ready | Status: In Progress

## Day 2 Coverage Summary
Day 2 focused on implementing the DexManager class with full core operations. The ArrayList and HashMap storage structures were set up and kept synchronized throughout all operations. Add, remove, search, and display methods were implemented with null checking, duplicate rejection, and name normalization. Eight sample Pokemon were seeded across four dimensions. A full test class was written and all 22 tests passed. A stray .class file issue discovered in src/ was also identified and cleaned up, and the test compilation was corrected to reference the main out/ directory.

## Why Day 2 Succeeded
Day 2 succeeded because the sprint plan was specific and the tasks were clear going in. The normalized name key strategy prevented casing bugs from the start. Writing DexManagerTest immediately after implementation caught no regressions and confirmed all behavior was correct on the first compile. The bonus cleanup of stray .class files left the project in a cleaner state than it started.

## What Went Well
- DexManager implemented cleanly with all four core methods matching the sprint plan exactly.
- Name normalization strategy worked correctly for add, remove, and search operations.
- Duplicate rejection and null handling were straightforward and tested thoroughly.
- 22/22 tests passed on first run with no regressions.
- Stray .class files from earlier skeleton compilation were found and cleaned from src/.
- Test classpath was corrected so test/out/ references main out/ properly — no duplicate Pokemon.class.
- Sample data covers 4 dimensions and 3 evolution stages, ready for Day 3 filtering.

## What Did Not Go Well
- The stray .class files in src/ were a leftover from skeleton compilation without -d out. Should have caught this on Day 1.

## Improvements for Next Sprint
- On Day 3, always compile with -d out from the start to avoid stray .class files.
- Add filter methods to DexManager early so there is time to test both type and dimension filtering before end of day.
- Keep filter logic simple — iterate the ArrayList, do not over-engineer.
