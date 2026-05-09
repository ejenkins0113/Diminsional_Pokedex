# Dimensional Pokedex

A Java console application for managing Pokemon across dimensions using core data structures and custom system modules.

## Features
- Pokemon data model with readable console output
- Dex management: add, remove, search, display, and filtering
- Custom selection sort by ID, level, or attack
- Encounter simulation using a priority queue
- Evolution history tracking with undo via stack
- Team management with duplicate checks and max size constraints

## Run Demo
Use the one-command launcher from the project root:

```powershell
.\run-demo.cmd
```

Alternative direct PowerShell command:

```powershell
powershell -ExecutionPolicy Bypass -File .\run-demo.ps1
```

## Run Full Regression Tests
From the project root:

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
