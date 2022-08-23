class Item:
    def __init__(self, nome, tipo):
        self.__nome = nome
        self.__tipo = tipo
    
    # Getters
    def get_nome(self):
        return self.__nome
    def get_tipo(self):
        return self.__tipo

    # Setters
    def set_nome(self, new):
        print("SETTER NOME")
        self.__nome = new
    def set_tipo(self, new):
        print("SETTER TIPO")
        self.__tipo = new