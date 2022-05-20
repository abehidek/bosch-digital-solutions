from PyQt5 import uic, QtWidgets
import sys

class Ui(QtWidgets.QMainWindow):
    def __init__(self):
        super(Ui, self).__init__()
        uic.loadUi("fundamentos-programação/python/pyqt/view/screen.ui", self)

        self.button = self.findChild(QtWidgets.QPushButton, 'pushButton')
        self.button.clicked.connect(self.func)
        self.show()

    def func(self):
        print("Nao")

app = QtWidgets.QApplication([])
# screen = uic.loadUi()

# screen.show()
window = Ui()
app.exec_()