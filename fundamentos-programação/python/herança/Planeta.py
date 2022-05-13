from Astro import Astro

class Planeta(Astro):
    def __init__(self, nome, diametro, massa, tipo):
        super().__init__(nome, diametro, massa)
        self.tipo = tipo
        