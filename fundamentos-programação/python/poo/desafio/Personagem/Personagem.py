class Personagem:
    def __init__(self, nome, classe, raca):
        print(f"Construindo em {self} ...")
        self.__nome = nome
        self.__classe = classe
        self.__raca = raca

    # Getters
    def get_nome(self):
        return self.__nome

    def get_classe(self):
        return self.__classe

    def get_raca(self):
        return self.__raca

    # Setters
    def set_nome(self, new):
        print("SETTER NOME")
        self.__nome = new

    def set_classe(self, new):
        print("SETTER CLASSE")
        self.__classe = new

    def set_raca(self, new):
        print("SETTER RAÇA")
        self.__raca = new
