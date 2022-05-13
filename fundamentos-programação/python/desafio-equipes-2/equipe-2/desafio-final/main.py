from Avaliacao import Avaliacao
from Usuario import Usuario

if __name__ == '__main__':
    user = Usuario()
    user.inicializar("", "")
    loping = True
    contador = 0
    while True:
        print("\nMENU")
        if user.get_logado() == False:
            print("1 - logar")
        print("2 - cadastrar")
        if user.get_permissao() == "ADM" and user.get_logado():
            print("3 - Alterar permissoes")
        if user.get_permissao() == "ADM" and user.get_logado():
            print("4 - Trazer mensagens do usuario")
        if user.get_permissao() == "ADM" and user.get_logado():
            print("5 - Trazer mensagens de todos os usuarios")
        if user.get_logado():
            print("6 - Inserir avaliação")
        if user.get_logado():
            print("7 - Deslogar")
        print("8 - Sair do programa")
        opcao = int(input("Escolha a opção: "))

        if opcao == 1:
            while True:
                nome = input("Digite o nome do usuario: ")
                senha = input("Digite a senha do usuario: ")

                userLogin = Usuario()
                user = userLogin.validar_login(nome, senha)


                if contador == 2:
                    print("\nLimite de tentativas atingido")
                    exit()
                if user == False:
                    contador += 1
                    print("\nLogin inválido, tente novamente")
                if user == None:
                    contador += 1
                    print("\nLogin inválido, tente novamente")


                else:
                    print("Logado!!")
                    print("\nBem vindo " + user.nome)
                    break

        if opcao == 2:
            novo_user = Usuario()
            while novo_user.cadastrar_user() == False:
                novo_user.cadastrar_user()
        if opcao == 3 and user.get_logado():
            nome = input("Digite o nome do usuario que deseja: ")
            permissao = input("Digite a nova permissao: ")
            user.set_permissao(nome, permissao)
        if opcao == 4 and user.get_logado():
            lista_avaliacao = Avaliacao()
            nome = input("Digite o nome do usuario que deseja ver as avaliações: ")
            lista_avaliacao.buscar_especificas(user.get_permissao(), nome)
        if opcao == 5 and user.get_logado():
            lista_avaliacao = Avaliacao()
            lista_avaliacao.buscar_todas(user.get_permissao())
        if opcao == 6:

            def pessimo(palavras):
                print("Nos conte porque achou péssimo:")
                print("1 - Falta de higienização\n2 - Mal atendimento\n3 - Comida gelada\n4 - Comida estragada\n5 - Insira sua opinião: ")
                opc = 5
                while opc != 999:
                    opc = int(input("Escolha as opções. Se tiver terminado de escolher digite 999\n"))
                    if opc == 1:
                        print('Adicionado')
                        palavra = 'Falta de higienização'
                        palavras.append(palavra)
                    elif opc == 2:
                        print('Adicionado')
                        palavra = 'Mal atendimento'
                        palavras.append(palavra)
                    elif opc == 3:
                        print('Adicionado')
                        palavra = 'Comida gelada'
                        palavras.append(palavra)
                    elif opc == 4:
                        print('Adicionado')
                        palavra = 'Comida gelada'
                        palavras.append(palavra)
                print("Voce chegou ao fim da sua avaliacao")
                return palavras

            def ruim(palavras):
                print("Nos conte porque achou ruim:")
                print("1 - Comida sem tempero\n2 - Falta de opções no cardápio\n3 - Mal organização no restaurante\n4 - Comida salgada\n")
                opc = 5
                while opc != 999:
                    opc = int(input("Escolha as opções. Se tiver terminado de escolher digite 999\n"))
                    if opc == 1:
                        print('Adicionado')
                        palavra = 'Comida sem tempero'
                        palavras.append(palavra)
                    elif opc == 2:
                        print('Adicionado')
                        palavra = 'Falta de opções no cardápio'
                        palavras.append(palavra)
                    elif opc == 3:
                        print('Adicionado')
                        palavra = 'Mal organização no restaurante'
                        palavras.append(palavra)
                    elif opc == 4:
                        print('Adicionado')
                        palavra = 'Comida salgada'
                        palavras.append(palavra)
                print("Voce chegou ao fim da sua avaliacao")
                return palavras

            def regular(palavras):
                print("Nos conte porque achou regular:")
                print(
                    "1 - Restaurante muito caro\n2 - Comida com textura estranha\n3 - Ambiente apertado\n4 - Cardápio desconexo\n")
                opc = 5
                while opc != 999:
                    opc = int(input("Escolha as opções. Se tiver terminado de escolher digite 999\n"))
                    if opc == 1:
                        print('Adicionado')
                        palavra = 'Restaurante muito caro'
                        palavras.append(palavra)
                    elif opc == 2:
                        print('Adicionado')
                        palavra = 'Comida com textura estranha'
                        palavras.append(palavra)
                    elif opc == 3:
                        print('Adicionado')
                        palavra = 'Ambiente apertado'
                        palavras.append(palavra)
                    elif opc == 4:
                        print('Adicionado')
                        palavra = 'Cardápio desconexo'
                        palavras.append(palavra)
                print("Voce chegou ao fim da sua avaliacao")
                return palavras

            def bom(palavras):
                print("Nos conte porque achou bom:")
                print("1 - Comida boa\n2 - Ambiente agradável\n3 - Ambiente higienizado corretamente\n4 - Ótimo atendimento\n")
                opc = 5
                while opc != 999:
                    opc = int(input("Escolha as opções. Se tiver terminado de escolher digite 999\n"))
                    if opc == 1:
                        print('Adicionado')
                        palavra = 'Comida boa'
                        palavras.append(palavra)

                    elif opc == 2:
                        print('Adicionado')
                        palavra = 'Ambiente agradável'
                        palavras.append(palavra)

                    elif opc == 3:
                        print('Adicionado')
                        palavra = 'Ambiente higienizado corretamente'
                        palavras.append(palavra)

                    elif opc == 4:
                        print('Adicionado')
                        palavra = 'Ótimo atendimento'
                        palavras.append(palavra)

                print("Voce chegou ao fim da sua avaliacao")
                return palavras

            def muito_bom(palavras):
                print("Nos conte porque achou muito bom:")
                print("1 - Adorei o cardápio\n2 - Ótima organização\n3 - Comida saborosa\n4 - Atendimento excelente\n")
                opc = 5
                while opc != 999:
                    opc = int(input("Escolha as opções. Se tiver terminado de escolher digite 999\n"))
                    if opc == 1:
                        print('Adicionado')
                        palavra = 'Adorei o cardápio'
                        palavras.append(palavra)

                    elif opc == 2:
                        print('Adicionado')
                        palavra = 'Ótima organização'
                        palavras.append(palavra)

                    elif opc == 3:
                        print('Adicionado')
                        palavra = 'Comida saborosa'
                        palavras.append(palavra)

                    elif opc == 4:
                        print('Adicionado')
                        palavra = 'Atendimento excelente'
                        palavras.append(palavra)

                print("Voce chegou ao fim da sua avaliacao")
                return palavras

            avaliacao = Avaliacao()
            arr = list()
            print("Bem Vindo(a) ao Restaurante!")
            print('Avalie o Pedido:\n (1) - Péssimo\n (2) - Ruim\n (3) - Regular\n (4) - Muito Bom\n (5) - Excelente')
            op = input("Insira sua avaliação: ")
            if op == '1':
                print('\n Você avaliou como Péssimo!\n')
                arr = pessimo(arr)
                arr.append("Péssimo")

            if op == '2':
                print('\n Você avaliou como Ruim!\n')
                arr = ruim(arr)
                arr.append("Ruim")

            if op == '3':
                print('\n Você avaliou como Regular!\n')
                arr = regular(arr)
                arr.append("Regular")
            
            if op == '4':
                print('\n Você avaliou como Muito Bom!\n')
                arr = bom(arr)
                arr.append("Muito Bom")
            
            if op == '5':
                print('\n Você avaliou como Excelente!\n')
                arr = muito_bom(arr)
                arr.append("Excelente")

            novaAvalicao = ""
            for v in arr:
               novaAvalicao += ", " + v
            avaliacao.cadastrar_valiacao(novaAvalicao, user.nome)
        if opcao == 7:
            print("Deslogado")
            user.nome = ""
            user.set_logado(False)
            user.set_senha("")
        if opcao == 8:
            exit()