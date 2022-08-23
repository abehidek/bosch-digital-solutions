class Avaliacao():
    def inicializar(self, nome):
        self.nomeUser = nome
        self.__todas_avaliacoes = []
        self.__avaliacoes = []

    def cadastrar_valiacao(self, msg, nome):
        arquivo = open('dados/Avaliacoes.txt', 'r', encoding="UTF-8")
        file = arquivo.readlines()
        file.append("\n"+nome + ":" + msg)

        arquivo = open('dados/Avaliacoes.txt', 'w', encoding="UTF-8")
        arquivo.writelines(file)
        arquivo.close()
        print("\nAvaliação cadastrada com sucesso")

    def buscar_todas(self, permissao):
        if permissao == "ADM":
            arquivo = open('dados/Avaliacoes.txt', 'r', encoding="UTF-8")
            file = arquivo.readlines()

            for i in file:
                print(i)
    def buscar_especificas(self, permissao, nome):
        if permissao == "ADM":
            arquivo = open('dados/Avaliacoes.txt', 'r', encoding="UTF-8")
            file = arquivo.readlines()

            for i in file:
                linha = i.split(":")
                if linha[0] == nome:
                    print("\n"+linha[1])