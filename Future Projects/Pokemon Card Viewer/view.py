from PySide6.QtCore import Qt
from PySide6.QtWidgets import (
    QComboBox,
    QFrame,
    QHBoxLayout,
    QLabel,
    QMainWindow,
    QPushButton,
    QSizePolicy,
    QVBoxLayout,
    QWidget,
)


class Ui_MainWindow:
    def setupUi(self, main_window: QMainWindow) -> None:
        if main_window.objectName() == "":
            main_window.setObjectName("MainWindow")

        main_window.resize(393, 852)
        main_window.setFixedSize(393, 852)
        main_window.setWindowTitle("Dimensional Pokedex - Card Viewer")
        main_window.setStyleSheet("background-color: #1a1a2e;")

        self.central_widget = QWidget(main_window)
        self.central_widget.setObjectName("central_widget")
        self.central_widget.setStyleSheet(
            "QWidget#central_widget { background-color: #1a1a2e; }"
            "QComboBox {"
            "  color: #111827; background-color: #ffffff;"
            "  border: 1px solid #d1d5db; border-radius: 6px; padding: 4px 8px;"
            "}"
            "QComboBox QAbstractItemView {"
            "  color: #111827; background-color: #ffffff;"
            "  selection-background-color: #e5e7eb;"
            "}"
            "QPushButton {"
            "  color: #111827; background-color: #f3f4f6;"
            "  border: 1px solid #d1d5db; border-radius: 6px; padding: 4px 12px;"
            "}"
            "QPushButton:hover { background-color: #e5e7eb; }"
        )

        self.root_layout = QVBoxLayout(self.central_widget)
        self.root_layout.setContentsMargins(16, 16, 16, 16)
        self.root_layout.setSpacing(10)

        # ── Title ─────────────────────────────────────────────────────────────
        self.labelTitle = QLabel("Dimensional Pokedex")
        self.labelTitle.setObjectName("labelTitle")
        self.labelTitle.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.labelTitle.setStyleSheet("font-size: 22px; font-weight: 700; color: #ffffff;")

        # ── Selector row ──────────────────────────────────────────────────────
        self.selector_layout = QHBoxLayout()
        self.labelSelect = QLabel("Choose:")
        self.labelSelect.setStyleSheet("color: #ffffff; font-weight: 600;")
        self.comboPokemon = QComboBox()
        self.comboPokemon.setObjectName("comboPokemon")
        self.comboPokemon.setSizePolicy(QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Fixed)
        self.buttonRandom = QPushButton("Random")
        self.buttonRandom.setObjectName("buttonRandom")
        self.buttonRandom.setCursor(Qt.CursorShape.PointingHandCursor)
        self.selector_layout.addWidget(self.labelSelect)
        self.selector_layout.addWidget(self.comboPokemon)
        self.selector_layout.addWidget(self.buttonRandom)

        # ── Card frame ────────────────────────────────────────────────────────
        self.cardFrame = QFrame()
        self.cardFrame.setObjectName("cardFrame")
        self.cardFrame.setFrameShape(QFrame.Shape.StyledPanel)
        self.cardFrame.setSizePolicy(QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Expanding)
        self.cardFrame.setStyleSheet(
            "QFrame#cardFrame { background-color: #1e293b; border: 3px solid #6b7280; border-radius: 14px; }"
            "QLabel { color: #ffffff; }"
            "QWidget { background-color: transparent; }"
        )

        card = QVBoxLayout(self.cardFrame)
        card.setContentsMargins(14, 12, 14, 12)
        card.setSpacing(0)

        # ── Section 1 · Stage + HP header ────────────────────────────────────
        hdr = QHBoxLayout()
        self.labelStage = QLabel("Basic")
        self.labelStage.setStyleSheet("font-size: 11px; font-weight: 600; color: #cbd5e1;")
        self.labelHP = QLabel("HP 55")
        self.labelHP.setAlignment(Qt.AlignmentFlag.AlignRight | Qt.AlignmentFlag.AlignVCenter)
        self.labelHP.setStyleSheet("font-size: 14px; font-weight: 700; color: #f87171;")
        hdr.addWidget(self.labelStage)
        hdr.addStretch()
        hdr.addWidget(self.labelHP)
        card.addLayout(hdr)

        # Pokemon name
        self.labelName = QLabel("-")
        self.labelName.setObjectName("labelName")
        self.labelName.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.labelName.setStyleSheet(
            "font-size: 26px;"
            "font-weight: 800;"
            "color: #ffffff;"
            "letter-spacing: 1px;"
            "margin: 4px 0;"
        )
        card.addWidget(self.labelName)

        # Type badge
        self.labelType = QLabel("-")
        self.labelType.setObjectName("labelType")
        self.labelType.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.labelType.setStyleSheet("font-size: 12px; font-weight: 600; color: #94a3b8; margin-bottom: 4px;")
        card.addWidget(self.labelType)

        # ── Section 2 · Artwork ───────────────────────────────────────────────
        self.labelArtwork = QLabel("No Artwork")
        self.labelArtwork.setObjectName("labelArtwork")
        self.labelArtwork.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.labelArtwork.setMinimumHeight(180)
        self.labelArtwork.setStyleSheet(
            "background-color: #0f172a; border-radius: 8px;"
            "font-size: 14px; font-weight: 600; color: #94a3b8;"
        )
        card.addWidget(self.labelArtwork)

        card.addWidget(self._sep())

        # ── Section 3 · Ability ───────────────────────────────────────────────
        ab_w = QWidget()
        ab_l = QVBoxLayout(ab_w)
        ab_l.setContentsMargins(4, 6, 4, 4)
        ab_l.setSpacing(2)
        self.labelAbilityName = QLabel("Ability")
        self.labelAbilityName.setStyleSheet("font-size: 12px; font-weight: 700; color: #c084fc;")
        self.labelAbilityDesc = QLabel("-")
        self.labelAbilityDesc.setObjectName("labelAbilityDesc")
        self.labelAbilityDesc.setWordWrap(True)
        self.labelAbilityDesc.setStyleSheet("font-size: 11px; color: #e2e8f0;")
        ab_l.addWidget(self.labelAbilityName)
        ab_l.addWidget(self.labelAbilityDesc)
        card.addWidget(ab_w)

        card.addWidget(self._sep())

        # ── Section 4 · Attack ────────────────────────────────────────────────
        atk_w = QWidget()
        atk_l = QVBoxLayout(atk_w)
        atk_l.setContentsMargins(4, 6, 4, 4)
        atk_l.setSpacing(2)
        atk_hdr = QHBoxLayout()
        self.labelMoveName = QLabel("-")
        self.labelMoveName.setStyleSheet("font-size: 12px; font-weight: 700; color: #ffffff;")
        self.labelMoveDamage = QLabel("0")
        self.labelMoveDamage.setAlignment(Qt.AlignmentFlag.AlignRight | Qt.AlignmentFlag.AlignVCenter)
        self.labelMoveDamage.setStyleSheet("font-size: 14px; font-weight: 700; color: #f87171;")
        atk_hdr.addWidget(self.labelMoveName)
        atk_hdr.addStretch()
        atk_hdr.addWidget(self.labelMoveDamage)
        self.labelMoveDesc = QLabel("-")
        self.labelMoveDesc.setObjectName("labelMoveDesc")
        self.labelMoveDesc.setWordWrap(True)
        self.labelMoveDesc.setStyleSheet("font-size: 11px; color: #e2e8f0;")
        atk_l.addLayout(atk_hdr)
        atk_l.addWidget(self.labelMoveDesc)
        card.addWidget(atk_w)

        card.addWidget(self._sep())

        # ── Section 5 · Weakness / Resistance / Retreat ───────────────────────
        wrr_w = QWidget()
        wrr_l = QVBoxLayout(wrr_w)
        wrr_l.setContentsMargins(4, 6, 4, 4)
        wrr_l.setSpacing(4)
        wr_row = QHBoxLayout()
        self.labelWeakness = QLabel("Weakness: -")
        self.labelWeakness.setStyleSheet("font-size: 11px; color: #e2e8f0;")
        self.labelResistance = QLabel("Resistance: -")
        self.labelResistance.setStyleSheet("font-size: 11px; color: #e2e8f0;")
        wr_row.addWidget(self.labelWeakness)
        wr_row.addStretch()
        wr_row.addWidget(self.labelResistance)
        self.labelRetreat = QLabel("Retreat: -")
        self.labelRetreat.setStyleSheet("font-size: 11px; color: #e2e8f0;")
        wrr_l.addLayout(wr_row)
        wrr_l.addWidget(self.labelRetreat)
        card.addWidget(wrr_w)

        card.addWidget(self._sep())

        # ── Section 6 · Footer ────────────────────────────────────────────────
        self.labelFooter = QLabel("001/009  •  Common  •  Dimensional Series")
        self.labelFooter.setObjectName("labelFooter")
        self.labelFooter.setAlignment(Qt.AlignmentFlag.AlignCenter)
        self.labelFooter.setStyleSheet("font-size: 10px; color: #94a3b8; padding: 4px 0;")
        card.addWidget(self.labelFooter)

        self.root_layout.addWidget(self.labelTitle)
        self.root_layout.addLayout(self.selector_layout)
        self.root_layout.addWidget(self.cardFrame, stretch=1)

        main_window.setCentralWidget(self.central_widget)

    @staticmethod
    def _sep() -> QFrame:
        line = QFrame()
        line.setFrameShape(QFrame.Shape.HLine)
        line.setFrameShadow(QFrame.Shadow.Sunken)
        line.setStyleSheet("color: #d1d5db; margin: 2px 0;")
        return line


