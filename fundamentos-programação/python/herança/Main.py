from Astro import Astro
from Planeta import Planeta
from Estrela import Estrela
print("Init")

terra = Astro("Terra", 12000, 500)
terra.mostrar_nome()

marte = Planeta("Marte", 4000, 300, "Rochoso")
marte.mostrar_nome()

print(marte.tipo)

sol = Estrela("Sol", 1000000, 100000, 400)

print(sol.brilho)