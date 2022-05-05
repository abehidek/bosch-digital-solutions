from Personagem import Personagem
from Personagem import Classe
from Personagem import Raça

# from Item import Arma
# import Item.Item as Item
# import Item.Arma as Arma

Classe = Classe.Classe()  # ['Assassino', 'Arqueiro', 'Tanque']
Raça = Raça.Raça()  # ['Anão', 'Humano', 'Goblin']
Jubileu = Personagem.Personagem("Jubileu", Classe.get_classe()[0], Raça.get_raca()[0])
print(Jubileu.get_nome())
print(Jubileu.get_classe())
print(Jubileu.get_raca())

# ItemObj = Item.Item('Item Genérico', 'Poção')
# print(ItemObj.get_nome())
# print(ItemObj.get_tipo())

# ArmaObj = Arma.Arma('Espada das Trevas', 50)
# print(ArmaObj.get_nome())
# print(ArmaObj.get_tipo())
# print(ArmaObj.get_ataque())

# print(Jubileu.get_raca())
# Jubileu.set_raca('Humano')
# print(Jubileu.get_raca())
