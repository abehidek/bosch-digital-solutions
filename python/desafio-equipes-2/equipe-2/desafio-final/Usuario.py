class Usuario:

    def inicializar(self, nome, senha):
        self.nome = nome
        self.__senha = senha
        self.__permissao = ""
        self.__logado = False

    def validar_login(self, nome, senha):
        arquivo = open('dados/Usuarios.txt', 'r')
        lista = arquivo.readlines()
        for i in lista:
            linha_atual = i.split(":")
            if linha_atual[0] == nome:
                if linha_atual[1] == senha:
                    user = Usuario()
                    user.nome = linha_atual[0]
                    user.__senha = linha_atual[1]
                    user.__permissao = linha_atual[2]
                    user.__permissao = user.__permissao[:-1]
                    user.__logado = True
                    return user


    def get_senha(self):
        return self.__senha

    def set_senha(self, senha):
        self.__senha = senha

    # def get_avaliacoes(self):
    #     mensagem = ""
    #     for i in self.__avaliacoes:
    #         mensagem += self.__avaliacoes.index(i)
    #     return mensagem
    def set_permissao(self, usuarioModificar, permissaoNova):
        if self.__permissao.upper() == "ADM":
            senha = ""
            aux = 0

            arquivo = open('dados/Usuarios.txt', 'r')
            file = arquivo.readlines()
            for i in file:

                nome = i.split(":")
                if nome[0] == usuarioModificar:
                    senha = nome[1]
                    file.pop(aux)

                aux += 1
            file.append(usuarioModificar + ":" + senha + ":" + permissaoNova.upper()+"\n")
            print("Permissão alterada")

            arquivo = open('dados/Usuarios.txt', 'w')
            arquivo.writelines(file)
            arquivo.close()

    def get_permissao(self):
        return self.__permissao

    def get_logado(self):
        return self.__logado

    def set_logado(self, logado):
        self.__logado = logado

    def cadastrar_user(self):
        nome = input("Digite o nome do usuario: ")
        senha = input("Digite a senha: ")
        senhaConfirma = input("Digite a senha novamente: ")
        if senha == senhaConfirma:
            arquivo = open('dados/Usuarios.txt', 'r')
            file = arquivo.readlines()
            for i in file:
                nomeVerifica = i.split(":")
                if nomeVerifica[0] == nome:
                    print("\nUsuario já cadastrado")
                    return False
            file.append("\n"+nome+":"+senha+":USUARIO\n")

            arquivo = open('dados/Usuarios.txt', 'w')
            arquivo.writelines(file)
            arquivo.close()
            print("\nCadastrado com sucesso")
            return True
    def get_user(self, nome):
        arquivo = open('dados/Usuarios.txt', 'r')
        lista = arquivo.readlines()
        for i in lista:
            linha_atual = i.split(":")
            if linha_atual[0] == nome:
                novaPermissao = input("ADM ou USUARIO?")
                lista.append(linha_atual[0]+":"+linha_atual[1]+":"+novaPermissao)
