import Item.Item

class Arma(Item.Item):
    def __init__(self, nome, ataque):
        super().__init__(nome, 'Arma')
        self.__ataque = ataque
    
    def get_ataque(self):
        return self.__ataque

# ArmaObj = Arma('Espada das Trevas', 50)
# print(ArmaObj.get_nome())
# print(ArmaObj.get_tipo())
# print(ArmaObj.get_ataque())