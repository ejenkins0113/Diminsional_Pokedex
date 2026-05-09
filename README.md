# Dimensional Pokedex

Dimensional Pokedex is a Java console project that manages Pokemon across multiple dimensions while demonstrating core object-oriented design and required data structures.

## Repository Overview

This repository contains the full Dimensional Pokedex coursework project, including source code, tests, project planning artifacts, and helper scripts to run the demo quickly.

- src: main Java source code
- test: regression test classes for each subsystem
- Project Management: proposal, scope, milestones, sprint plans, and retrospectives
- run-demo.cmd and run-demo.ps1: one-command launchers for demo flow
- Future Projects: reserved folder for follow-up extensions

## Project Requirement Coverage

This project matches the agreed proposal and scope by implementing:

- Pokemon data model with all required fields (ID, types, stats, dimension, evolution, seen/caught, description)
- Dex manager logic for add, remove, search, display, and filtering
- Team builder subsystem
- Encounter subsystem using PriorityQueue
- Evolution history subsystem using Stack with undo
- Custom Selection Sort implementation with configurable sort field
- Comparable implementation in Pokemon
- Console menu to run all systems from one entry point
- Sample Pokemon dataset for demonstration

## Data Structures Used

- ArrayList: main Pokemon storage and list-based operations
- HashMap: fast name-based lookup in the dex manager
- PriorityQueue: ordered encounter queue (higher level first)
- Stack: LIFO evolution history with undo support

## Source Layout

- src/model: Pokemon object model
- src/manager: Dex manager and lookup/filter logic
- src/sorting: Custom sorting module
- src/systems: Encounter, evolution history, and team builder modules
- src/ui: Console menu entry point and interaction loop
- test: Regression tests for all major modules

## Javadocs

All source classes in src include class-level and method-level Javadocs.

To generate HTML documentation from project root:

```powershell
if (-not (Test-Path docs)) { New-Item -ItemType Directory -Path docs | Out-Null }
$sources = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }
& javadoc -d docs $sources
```

Generated output starts at docs/index.html.

## Run Demo

Use the one-command launcher from project root:

```powershell
.\run-demo.cmd
```

Alternative direct PowerShell command:

```powershell
powershell -ExecutionPolicy Bypass -File .\run-demo.ps1
```

## Menu Options (Console App)

When you run the project, the main menu includes:

- 1: Load sample Pokemon data
- 2: Display all Pokemon
- 3: Search Pokemon by name
- 4: Filter Pokemon by type
- 5: Filter Pokemon by dimension
- 6: Sort Pokemon by ID, Level, or Attack
- 7: Add encounter by Pokemon name
- 8: Process next encounter
- 9: Preview next encounter
- 10: Record evolution event
- 11: Undo last evolution event
- 12: Peek last evolution event
- 13: Add Pokemon to team by name
- 14: Remove Pokemon from team by name
- 15: Display current team
- 0: Exit

All options are available through the console menu implemented in src/ui/MainMenu.java.

## Run Full Regression Tests

From project root:

```powershell
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
$sources = Get-ChildItem -Recurse src,test -Filter *.java | ForEach-Object { $_.FullName }
& javac -d out $sources
java -cp out manager.DexManagerTest
java -cp out manager.DexManagerFilterTest
java -cp out model.PokemonTest
java -cp out sorting.CustomSorterTest
java -cp out systems.EncounterSystemTest
java -cp out systems.EvolutionHistoryTest
java -cp out systems.TeamBuilderTest
```
