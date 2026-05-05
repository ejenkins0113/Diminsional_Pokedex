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

## D4 - Filter Return Type
Decision: filterByType and filterByDimension always return a new ArrayList, never null.
Reason: Callers can safely iterate the result without null checks. Consistent with defensive design.
Date: 2026-05-05

## D5 - CustomSorter Design
Decision: CustomSorter uses a static sort method that takes an ArrayList and a SortField enum. Sorts in-place using Selection Sort.
Alternatives Considered: Returning a new sorted list (copy). Decided against to keep memory use simple and document the in-place behavior clearly.
Reason: In-place sort is straightforward for a console app with small datasets. SortField enum keeps call sites readable.
Date: 2026-05-05

## D6 - Encounter Priority Rule
Decision: EncounterSystem uses a max-heap on level — higher level Pokemon surface first.
Alternatives Considered: Priority by ID, priority by attack stat.
Reason: Level is the most intuitive "threat level" signal for wild encounters. Implemented via a Comparator passed to PriorityQueue, keeping Comparable<Pokemon> (sort by ID) fully independent.
Date: 2026-05-05

## New Decision Template
- ID:
- Decision:
- Alternatives Considered:
- Reason:
- Date:
