class Astro():
    def __init__ (self, nome, diametro, massa):
        self.nome = nome
        self.diametro = diametro
        self.massa = massa

    def mostrar_nome(self):
        print(self.nome)