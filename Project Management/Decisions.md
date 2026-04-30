# Technical Decisions Log

## D1 - Application Type
Decision: Build as a console-based Java application.
Reason: Fastest way to deliver required functionality in 7 days.
Date: 2026-04-30

## D2 - Data Structures
Decision:
- Main storage: ArrayList<Pokemon>
- Fast lookup: HashMap<String, Pokemon>
- Encounters: PriorityQueue<Pokemon>
- Evolution events: Stack<String>
Reason: Matches assignment requirements and clear use cases.
Date: 2026-04-30

## D3 - Default Comparable Rule
Decision: Default compareTo will sort by Pokemon ID.
Reason: Stable, deterministic ordering for baseline display.
Date: 2026-04-30

## New Decision Template
- ID:
- Decision:
- Alternatives Considered:
- Reason:
- Date:
