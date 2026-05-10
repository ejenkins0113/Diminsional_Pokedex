import sys

from PySide6.QtWidgets import QApplication

from controller import PokedexController


def main() -> int:
    app = QApplication(sys.argv)
    controller = PokedexController()
    controller.show()
    return app.exec()


if __name__ == "__main__":
    raise SystemExit(main())
