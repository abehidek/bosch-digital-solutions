from PyQt5 import uic, QtWidgets
import sys

app = QtWidgets.QApplication([])
screen = uic.loadUi("fundamentos-programação/python/pyqt/view/screen.ui")

screen.show()
app.exec()