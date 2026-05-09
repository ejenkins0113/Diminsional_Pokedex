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

## Demo Walkthrough

This is a step-by-step demo that exercises every feature and data structure. Run the project with `.\run-demo.cmd`, then follow these inputs in order.

---

### Step 1 — Load sample data (ArrayList + HashMap)
**Input:** `1`

Loads 19 built-in Pokemon across four dimensions (Norasua, Megalune, Valurtine, Univi), including Gen 1–5 representatives and the full Eevee evolution line. Populates the internal `ArrayList` and `HashMap`.

```
+------------------------------------------------------------------------...+
| Message                                                                   |
+------------------------------------------------------------------------...+
| Sample data loaded. Entries in dex: 19                                    |
+------------------------------------------------------------------------...+
```

---

### Step 2 — Display all Pokemon (ArrayList iteration)
**Input:** `2`

Iterates the `ArrayList` and prints all 19 entries in a single boxed table.

---

### Step 3 — Search by name (HashMap O(1) lookup)
**Input:** `3`
**Name:** `Eevee`

Demonstrates constant-time name lookup via the internal `HashMap<String, Pokemon>`.

```
+------------------------------------------------------------------------...+
| Message                                                                   |
+------------------------------------------------------------------------...+
| Found: [ID:11] Eevee | Normal | Lv.20 | HP:55 | ATK:55 | DEF:50 | ...    |
+------------------------------------------------------------------------...+
```

---

### Step 4 — Filter by type (ArrayList scan)
**Input:** `4`
**Type:** `Dark`

Scans the `ArrayList` and returns every Dark-type Pokemon (Umbreon, Zoroark, Hydreigon, Tyranitar).

---

### Step 5 — Filter by dimension (ArrayList scan)
**Input:** `5`
**Dimension:** `Norasua`

Returns all Pokemon assigned to the Norasua dimension (Bulbasaur, Gardevoir, Zoroark, Eevee, Espeon).

---

### Step 6 — Sort by Level (Selection Sort)
**Input:** `6`
**Sort field:** `2` (Level)

Runs the custom in-place Selection Sort (`CustomSorter.java`) and redisplays the dex sorted by level ascending.

---

### Step 7 — Queue two encounters (PriorityQueue, higher level first)
**Input:** `7` → Name: `Hydreigon`
**Input:** `7` → Name: `Eevee`

Adds both to the `PriorityQueue`. Hydreigon (Lv.78) ranks above Eevee (Lv.20).

---

### Step 8 — Preview next encounter (PriorityQueue peek)
**Input:** `9`

Calls `peek()` on the queue. Hydreigon appears first because higher-level encounters have higher priority.

```
+------------------------------------------------------------------------...+
| Message                                                                   |
+------------------------------------------------------------------------...+
| Next encounter: [ID:10] Hydreigon | Dragon/Dark | Lv.78 | ...            |
+------------------------------------------------------------------------...+
```

---

### Step 9 — Process encounter (PriorityQueue poll)
**Input:** `8`

Calls `poll()`. Hydreigon is resolved and removed. Eevee becomes next.

---

### Step 10 — Record evolution event (Stack push)
**Input:** `10`
**Event text:** `Eevee evolved to Vaporeon in Megalune`

Pushes the string onto the `Stack<String>` in `EvolutionHistory`.

---

### Step 11 — Peek evolution event (Stack peek)
**Input:** `12`

Reads the top of the stack without removing it.

```
+------------------------------------------------------------------------...+
| Message                                                                   |
+------------------------------------------------------------------------...+
| Latest evolution event: Eevee evolved to Vaporeon in Megalune            |
+------------------------------------------------------------------------...+
```

---

### Step 12 — Undo evolution event (Stack pop)
**Input:** `11`

Pops the top entry off the stack, reverting the last recorded event.

---

### Step 13 — Build a team (LinkedList/ArrayList max-6, no duplicates)
**Input:** `13` → Name: `Pikachu`
**Input:** `13` → Name: `Sylveon`

Adds two Pokemon to the active team. Team size shows 2/6.

---

### Step 14 — Display team
**Input:** `15`

Prints the current team in a boxed view.

---

### Step 15 — Remove from team
**Input:** `14` → Name: `Pikachu`

Removes Pikachu. Team size drops to 1/6.

---

### Step 16 — Display team again
**Input:** `15`

Confirms Pikachu is gone; only Sylveon remains.

---

### Step 17 — Exit
**Input:** `0`

Prints goodbye message and terminates.

---

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
