# Função principal que lê os valores e escolhe a operação
def Leia():
    # Pede o primeiro valor ao usuário
    v1 = int(input('Fale o valor 1: '))
    
    # Pede o segundo valor ao usuário
    v2 = int(input('Fale o valor 2: '))
    
    # Pede qual operação matemática será feita
    op = input('Fale a operação [+, -, *, /]: ')
    
    # Monta a mensagem com a operação digitada
    msg = f'{v1} {op} {v2}'
    
    # Verifica qual operação foi escolida
    if op == '+':
        # Se for soma, chama a função soma
        res = soma(v1, v2)
        
    elif op == '-':
        # Se for subtração, chama a função subtracao
        res = subtracao(v1, v2)
        
    elif op == '*':
        # Se for multiplicação, chama a função multiplicacao
        res = multiplicacao(v1, v2)
        
    elif op == '/':
        # Antes de dividir, verifica se o segundo número é zero
        if v2 == 0:
            print('Erro: divisão por zero não é permitida!')
            return  # Encerra a função se for divisão por zero
        
        # Se não for zero, chama a função divisao
        res = divisao(v1, v2)
        
    else:
        # Caso o usuário digite uma operação inválida
        print('Operação inválida!')
        return  # Encerra a função
        
    # Mostra o resultado final
    saida(msg, res)


# Função que faz a soma
def soma(var1, var2):
    return (var1 + var2)


# Função que faz a subtração
def subtracao(var1, var2):
    return (var1 - var2)


# Função que faz a multiplicação
def multiplicacao(var1, var2):
    return (var1 * var2)
    

# Função que faz a divisão
def divisao(var1, var2):
    return (var1 / var2)


# Função que mostra o resultado na tela
def saida(msg, resultado):
    print(f'{msg} = {resultado}')


# Chama a função principal para executar o programa
Leia()