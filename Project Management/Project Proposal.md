# Dimensional Pokedex

## Overview
Dimensional Dex is a custom-built Pokedex-style application to manage and explore Pokemon across multiple dimensions. Instead of only replicating a traditional Pokedex, this project expands the idea by introducing original Pokemon, alternate dimensional variants, and new evolution paths, including Mega Evolutions.

The goal of this project is to combine creativity with strong programming fundamentals by using core data structures and object-oriented design to build something that is both functional and interesting to work on.

## Objectives
The main objective is to design a system that efficiently stores, retrieves, and organizes Pokemon data while demonstrating understanding of these concepts:

- Lists, Maps, Queues, and Stacks
- Custom object design
- Sorting algorithms and Comparable
- Cleaning and maintaining program structures

## Core Functionality

### Pokemon Storage
All Pokemon will be stored in a dynamic list structure using a custom Pokemon class. This allows flexible management of a growing collection.

- Add, remove, and display Pokemon
- Search for Pokemon by name

### Encounter System
The program will simulate encounters using a PriorityQueue. Pokemon will be prioritized based on attributes such as level and rarity. Using a PriorityQueue instead of a standard queue makes the system more dynamic by allowing rarer Pokemon to appear earlier.

### Evolution History
A stack will be used to track evolution events, including custom evolutions and Mega Evolutions.

- Record evolution events
- Undo the most recent evolution
- View evolution history

### Custom Sorting System
The program will include a custom sorting algorithm to organize Pokemon based on attributes like level or attack.

- The Pokemon class will implement Comparable<Pokemon>
- A custom sorting algorithm, either Bubble Sort or Selection Sort, will be implemented

### Team Builder
The user will be able to create and manage a team of Pokemon.

- Add a Pokemon to a team
- Remove a Pokemon from a team
- Display the current team

## Additional Features
To make the program feel more like an actual Pokedex, it will include the following:

- Seen and caught tracking
- Pokedex ID system
- Description and lore
- Secondary type support
- Filtering by type or dimension

## Data Structures Used
This project will incorporate all required data structures:

- List -> ArrayList<Pokemon>
- Map -> HashMap<String, Pokemon>
- Queue -> PriorityQueue<Pokemon>
- Stack -> Stack<String>

## Custom Object Design
The main object in the program is the Pokemon class. Each Pokemon will include:

- Name
- Primary type
- Secondary type (optional)
- Level
- HP, Attack, Defense
- Dimension
- Evolution stage
- Mega evolution status
- Seen and caught status
- Description
- Unique ID

## Design Approach
The design will stay clean and organized by separating responsibilities:

- The Pokemon class will focus on storing data
- A manager class such as Pokedex or DexManager will handle logic like searching, filtering, and sorting

This approach keeps the code easier to maintain and extend.

## Conclusion
Dimensional Dex is designed to balance creativity with technical requirements. It goes beyond a basic Pokedex by introducing a dimensional system while still staying focused on core programming concepts.

The project demonstrates practical use of data structures, object-oriented programming, and algorithm implementation, while keeping the scope realistic and manageable. It is something that can continue to grow while still standing solidly on its own.