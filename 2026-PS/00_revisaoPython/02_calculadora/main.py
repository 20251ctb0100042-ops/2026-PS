def calculadora():
    print("=== CALCULADORA ===")
    print("Selecione operação:")
    print("1 = Adição (+)")
    print("2 = Subtração (-)")
    print("3 = Multiplicação (*)")
    print("4 = Divisão (/)")
    print("0 = Sair")
    
    operacao = input("\nDigite o número operação (0/1/2/3/4): ")
    
    if operacao == "0":
        print("Tchau!")
        return False
    
    try:
        numero1 = float(input("Digite primeiro número: "))
        numero2 = float(input("Digite segundo número: "))
        
        if operacao == "1":
            resultado = numero1 + numero2
            print(f"\n{numero1} + {numero2} = {resultado}")
        elif operacao == "2":
            resultado = numero1 - numero2
            print(f"\n{numero1} - {numero2} = {resultado}")
        elif operacao == "3":
            resultado = numero1 * numero2
            print(f"\n{numero1} * {numero2} = {resultado}")
        elif operacao == "4":
            if numero2 != 0:
                resultado = numero1 / numero2
                print(f"\n{numero1} / {numero2} = {resultado}")
            else:
                print("\nErro: Não é possível dividir por zero!")
        else:
            print("\nOperação inválida!")
    except ValueError:
        print("\nErro: Digite números válidos ")
    
    return True

if __name__ == "__main__":
    while calculadora():
        pass
