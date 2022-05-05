class Macaco:
    sexolist = ["M", "F"]

    def __init__(self, name="", raca="", sexo="", temperamento=""):
        self.__name = name
        self.raca = raca
        self.sexo = sexo
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


if __name__ == "__main__":

    macaco1 = Macaco("Abe", "chimp", Macaco.sexolist[0], "docil")
    macaco2 = Macaco("Agiota", "simio", Macaco.sexolist[1], "bravo")

    print(macaco2.name, end=" ")
    print(macaco2.raca, end=" ")
    print(macaco2.sexo, end=" ")
    print(macaco2.temperamento)

    print("-" * 25)

    print("|", end=" ")
    print(macaco1.name, end=" ")
    print(macaco1.raca, end=" ")
    print(macaco1.sexo, end=" ")
    print(macaco1.temperamento)

    macaco1.name = "Cezar"
    macaco1.temperamento = "Maduro"

    print("-" * 25)

    print("|", end=" ")
    print(macaco1.name, end=" ")
    print(macaco1.raca, end=" ")
    print(macaco1.sexo, end=" ")
    print(macaco1.temperamento)

    print("-" * 25)
