class Macaco:
    sexolist = ["M", "F"]
    __zoologico = "Zoologico dos macacos"

    def __init__(self, name="", raca="", sexo="", temperamento=""):
        self.__name = name
        self.raca = raca
        self.sexo = sexo
        self.vida = 100
        self.__temperamento = temperamento

    # Getters

    @property
    def name(self):
        return self.__name.title()

    @property
    def temperamento(self):
        return self.__temperamento

    # Setters
    @temperamento.setter
    def temperamento(self, new):
        self.__temperamento = new

    @name.setter
    def name(self, new):
        self.__name = new

    # Unique methods

    def __gritar(self):
        print(self.name, "!!!")

    def __bater(self, alvo):
        alvo.vida -= 10

    def brigar(self, alvo):
        self.__gritar()
        self.__bater(alvo)

    def getMacaco(self):
        print("-" * 40)
        print("|", end=f" Macaco: {self.name}\n")
        print("|", end=" ")
        print(self.raca, end=" ")
        print(self.vida, end=" ")
        print(self.sexo, end=" ")
        print(self.temperamento)
        print("-" * 40)

    # Static methods
    @staticmethod
    def get_animal():
        print("Macaco")

    @classmethod
    def get_zoo(cls):
        print(cls.__zoologico)

    @classmethod
    def get_zoo2(self):
        print(self.__zoologico)


if __name__ == "__main__":

    macaco1 = Macaco("Zeke", "chimp", Macaco.sexolist[0], "docil")
    macaco2 = Macaco("Agiota", "simio", Macaco.sexolist[1], "bravo")

    macaco1.getMacaco()
    macaco2.getMacaco()
    macaco1.name = "Cezar"
    macaco1.temperamento = "Maduro"
    macaco1.getMacaco()
    macaco2.getMacaco()
    macaco1.brigar(macaco2)
    macaco1.getMacaco()
    macaco2.getMacaco()

    Macaco.get_animal()
    Macaco.get_zoo()
    Macaco.get_zoo2()
    # print(Macaco.zoologico) # <- Isso não funciona pois o campo __zoologico esta privado
