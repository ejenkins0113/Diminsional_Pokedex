import random
from pathlib import Path

from PySide6.QtCore import Qt
from PySide6.QtGui import QPixmap
from PySide6.QtWidgets import QMainWindow

from model import PokedexModel
from view import Ui_MainWindow


class PokedexController:
    TYPE_COLORS = {
        "Normal": "#a8a77a",
        "Water": "#6390f0",
        "Electric": "#f7d02c",
        "Fire": "#ee8130",
        "Psychic": "#f95587",
        "Dark": "#705746",
        "Grass": "#7ac74c",
        "Ice": "#96d9d6",
        "Fairy": "#d685ad",
    }

    TYPE_SYMBOLS = {
        "Normal": "⬜",
        "Water": "💧",
        "Electric": "⚡",
        "Fire": "🔥",
        "Psychic": "🔮",
        "Dark": "🌑",
        "Grass": "🍃",
        "Ice": "❄",
        "Fairy": "✨",
    }

    def __init__(self) -> None:
        self.model = PokedexModel()
        self.window = QMainWindow()
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self.window)

        self._populate_dropdown()
        self.ui.comboPokemon.currentIndexChanged.connect(self.on_selection_changed)
        self.ui.buttonRandom.clicked.connect(self.on_random_clicked)
        self.on_selection_changed(self.ui.comboPokemon.currentIndex())

    def _populate_dropdown(self) -> None:
        self.ui.comboPokemon.clear()
        self.ui.comboPokemon.addItems(self.model.get_names())

    def on_selection_changed(self, _index: int) -> None:
        selected_name = self.ui.comboPokemon.currentText()
        pokemon = self.model.get_pokemon(selected_name)
        if pokemon is None:
            self._clear_card()
            return

        symbol = self.TYPE_SYMBOLS.get(pokemon.ptype, "•")

        self.ui.labelStage.setText(pokemon.stage)
        self.ui.labelHP.setText(f"HP {pokemon.hp}")
        self.ui.labelName.setText(pokemon.name)
        self.ui.labelType.setText(f"{symbol} {pokemon.ptype}")
        self.ui.labelAbilityName.setText(f"Ability  ·  {pokemon.ability_name}")
        self.ui.labelAbilityDesc.setText(pokemon.ability_desc)
        self.ui.labelMoveName.setText(f"{symbol} {pokemon.move_name}")
        self.ui.labelMoveDamage.setText(str(pokemon.move_damage))
        self.ui.labelMoveDesc.setText(pokemon.move_desc)
        self.ui.labelWeakness.setText(f"Weakness: {pokemon.weakness}")
        self.ui.labelResistance.setText(f"Resistance: {pokemon.resistance}")
        self.ui.labelRetreat.setText(f"Retreat: {pokemon.retreat_cost}")
        self.ui.labelFooter.setText(
            f"{pokemon.card_number}  •  {pokemon.rarity}  •  {pokemon.set_name}"
        )
        self._apply_type_theme(pokemon.ptype)
        self._set_artwork(pokemon.name)

    def on_random_clicked(self) -> None:
        names = self.model.get_names()
        if not names:
            return
        current = self.ui.comboPokemon.currentText()
        choices = [name for name in names if name != current]
        self.ui.comboPokemon.setCurrentText(random.choice(choices or names))

    def _apply_type_theme(self, ptype: str) -> None:
        color = self.TYPE_COLORS.get(ptype, "#6b7280")
        self.ui.cardFrame.setStyleSheet(
            f"QFrame#cardFrame {{ background-color: #1e293b; border: 3px solid {color}; border-radius: 14px; }}"
            "QLabel { color: #ffffff; }"
            "QWidget { background-color: transparent; }"
        )

    def _set_artwork(self, name: str) -> None:
        base_dir = Path(__file__).resolve().parent
        workspace_root = base_dir.parent.parent
        candidate_dirs = [
            base_dir / "assets",
            workspace_root / "Future Projects" / "Pokemon Images",
            workspace_root / "Future Projects" / "Pokemon Images" / "Pokemon Images",
        ]
        candidate_extensions = [".png", ".jpg", ".jpeg", ".webp", ".avif"]

        normalized_name = name.lower().replace(" ", "_")
        for directory in candidate_dirs:
            for extension in candidate_extensions:
                image_path = directory / f"{normalized_name}{extension}"
                if not image_path.exists():
                    continue
                pixmap = QPixmap(str(image_path))
                if pixmap.isNull():
                    continue
                scaled = pixmap.scaled(
                    self.ui.labelArtwork.size(),
                    Qt.AspectRatioMode.KeepAspectRatio,
                    Qt.TransformationMode.SmoothTransformation,
                )
                self.ui.labelArtwork.setPixmap(scaled)
                self.ui.labelArtwork.setText("")
                return

        self.ui.labelArtwork.setPixmap(QPixmap())
        self.ui.labelArtwork.setText(f"{name} Artwork")

    def _clear_card(self) -> None:
        self.ui.labelStage.setText("-")
        self.ui.labelHP.setText("HP -")
        self.ui.labelName.setText("-")
        self.ui.labelType.setText("-")
        self.ui.labelAbilityName.setText("Ability")
        self.ui.labelAbilityDesc.setText("-")
        self.ui.labelMoveName.setText("-")
        self.ui.labelMoveDamage.setText("0")
        self.ui.labelMoveDesc.setText("-")
        self.ui.labelWeakness.setText("Weakness: -")
        self.ui.labelResistance.setText("Resistance: -")
        self.ui.labelRetreat.setText("Retreat: -")
        self.ui.labelFooter.setText("-")
        self.ui.labelArtwork.setPixmap(QPixmap())
        self.ui.labelArtwork.setText("No Artwork")

    def show(self) -> None:
        self.window.show()
