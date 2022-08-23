class Conta:
    banco = "Abank"

    def get_banco():
        return __class__.banco

    def get_banco2(self):
        return self.banco

    def __init__(self, num, tit, sal, lim):
        print(f"Construindo em {self}")
        self.__numero = num
        self.__titular = tit
        self.__saldo = sal
        self.__limite = lim

    def __pode_sacar(self, valor):
        return valor <= self.__saldo + self.__limite

    def depositar(self, valor):
        self.__saldo += valor

    def sacar(self, valor):
        if not self.__pode_sacar(valor):
            print("Valor excede o saldo + limite")
            return
        self.__saldo -= valor

    def transferir(self, valor, destino):
        self.sacar(valor)
        destino.depositar(valor)

    def saldo_com_limite(self):
        return self.__saldo + self.__limite

    # ---

    def get_titular(self):
        return self.__titular

    def get_saldo(self):
        return self.__saldo

    def get_limite(self):
        return self.__limite

    def get_numero(self):
        return self.__numero


if __name__ == "__main__":
    conta_junin = Conta(23, "junin", 10000, 500)
    conta_ooo = Conta(24, "ooo", 20000, 1000)

    print("Saldo + Limite: ", conta_junin.saldo_com_limite())
    print("Saldo + Limite: ", conta_ooo.saldo_com_limite())
    conta_junin.sacar(10501)

    print("Saldo + Limite: ", conta_junin.saldo_com_limite())
    print("Saldo + Limite: ", conta_ooo.saldo_com_limite())

    # Acessando atributo estático

    print(conta_junin.banco)  # Pelo objecto
    # print(Conta.banco)  # Pela classe
    # print(Conta.get_banco())  # Pelo método usando __class__
    # print(conta_junin.get_banco2())
