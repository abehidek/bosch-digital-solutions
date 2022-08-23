from Astro import Astro

class Estrela(Astro):
    def __init__(self, nome, diametro, massa, brilho):
        super().__init__(nome, diametro, massa)
        self.brilho = brilho