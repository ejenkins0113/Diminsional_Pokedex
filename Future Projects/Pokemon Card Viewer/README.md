# Dimensional Pokedex — Pokemon Card Viewer

## Application Purpose
A desktop GUI application built with PySide6 that displays Pokemon data in a card-style layout. The user selects a Pokemon from a dropdown and the card updates to show its name, type, stats, dimension, and description. Built as a follow-up to the Java Dimensional Pokedex project to demonstrate the MVC design pattern using Qt Designer and PySide6.

---

## MVC Explanation

### Model (`model.py`)
Holds all Pokemon data and business logic. Contains the `Pokemon` dataclass and a `PokedexModel` class that stores the Pokemon list and provides lookup methods. Has zero dependency on PySide6 — pure Python only.

### View (`view.ui` / `view.py`)
Designed entirely in Qt Designer. Contains the visual layout: a `QComboBox` for Pokemon selection and `QLabel` fields for name, type, stats, dimension, and description. No business logic lives here. Exported to `view.py` using `pyside6-uic`.

### Controller (`controller.py`)
Acts as the glue between Model and View. Loads the UI, populates the dropdown from the Model, connects the `QComboBox.currentIndexChanged` signal to a slot that fetches the selected Pokemon from the Model and updates the View labels.

---

## Project Structure

```
Pokemon Card Viewer/
├── main.py          # Entry point: QApplication, Controller init, event loop
├── model.py         # Pokemon dataclass + PokedexModel with lookup logic
├── controller.py    # Loads UI, connects signals, calls model, updates labels
├── view.ui          # Qt Designer source layout file
├── view.py          # view.ui converted to Python via pyside6-uic
└── README.md        # This file
```

---

## How to Run

### 1. Install dependencies
```bash
pip install PySide6
```

### 2. Convert the UI file (if view.py is not already generated)
```bash
pyside6-uic view.ui -o view.py
```

### 3. Run the app
```bash
python main.py
```

---

## Requirements
- Python 3.10 or higher
- PySide6
- Qt Designer (for editing `view.ui`)

---

## Signal-Slot Flow

```
User selects Pokemon in QComboBox
        │
        ▼
currentIndexChanged signal fires
        │
        ▼
Controller.on_selection_changed(index)
        │
        ▼
model.get_pokemon(name) → returns Pokemon object
        │
        ▼
Controller updates QLabel fields in the View
```

---

## Functional Checklist
- [ ] UI designed in Qt Designer
- [ ] MVC pattern with clear separation of concerns
- [ ] Working signal-slot connection
- [ ] UI updates correctly based on model state
- [ ] Runs without errors on Windows, macOS, and Linux

---

## Status
**Planned** — to be built after the Java Dimensional Pokedex project is complete (Day 7).
