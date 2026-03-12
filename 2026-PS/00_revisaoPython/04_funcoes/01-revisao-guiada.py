# ============================================
# SISTEMA DE CALCULO DE IMC
# Aula
# Autor: Luiz Henrique Schactae Brandão
# Data: 05/03/2026
#
# Disciplina : Programação de Sistemas (PS)
# 06 - Revisao: Funcoes
#
# Repositório:Repositório:https://github.com/20251ctb0100042-ops/2026-PS
# ============================================

# DESCRIÇÃO:
# Calcula e classifica o IMC de uma pessoa.
# Demonstra definição de funções, parametros,
# retorno, escopo e recursao.

# --------------------------------------------
# FUNÇÃO SEM PARAMETROS E SEM RETORNO
# --------------------------------------------

def exibir_cabecalho():
    """
    Exibe o cabeçalho do sistema no terminal.
    """
    print("=" * 40)
    print(" SISTEMA DE CALCULO DE IMC")
    print("=" * 40)


def exibir_rodape():
    """
    Exibe o rodapé do sistema.
    """
    print("=" * 40)
    print("Sistema encerrado.")


# Chamando as funções para testar
exibir_cabecalho()
exibir_rodape()

#---- FUNÇÃO COM PARÂMETROS E RETORNO ----

def calcular_imc(peso, altura):
    """Calcula e retorna o IMC, Fórmula: peso / altura²"""
    imc = peso / (altura ** 2)   # ** é o operador de potência
    return imc                   # devolve o resultado para quem chamou


# Coletando dados do usuário 
peso   = float(input("Peso (kg): "))
altura = float(input("Altura (m): "))

# Chamando a função e armazenando o retorno
resultado = calcular_imc(peso, altura)
print(f"Seu IMC é: {resultado:.2f}")

# ESCOPO LOCAL vs GLOBAL

versao = "1.0"   # variável GLOBAL - existe fora de qualquer função

def demonstrar_escopo():
    mensagem = "Olá do interior da função"  # variável LOCAL

    print("Dentro da função:")
    print(f"mensagem = {mensagem}")   # OK: local existe aqui
    print(f"versao = {versao}")       # OK: global é visível dentro da função

demonstrar_escopo()

print("\nFora da função:")
print(f"versao = {versao}")   # OK: global existe aqui

# print(mensagem)  # ERRO: variável local não existe fora da função

def mostrar_versao():
    """Mostra a versão do sistema usando a variável global"""
    print(f"Sistema IMC — versão {versao}")

mostrar_versao()

# ---- VALOR PADRÃO E MÚLTIPLOS RETORNOS ----

def classificar_imc(imc, unidade="kg/m2"):
    """
    Classifica o IMC e retorna classificação e emoji de status.
    Parâmetro 'unidade' tem valor padrão - não é obrigatório informar.
    """

    if imc < 18.5:
        classificacao = "Abaixo do peso"
        emoji = "⚠️"

    elif imc < 25.0:
        classificacao = "Peso normal"
        emoji = "✅"

    elif imc < 30.0:
        classificacao = "Sobrepeso"
        emoji = "⚠️"

    else:
        classificacao = "Obesidade"
        emoji = "❗"

    return classificacao, emoji   # retorna dois valores (tupla)


# Chamada sem o parâmetro opcional (usa o padrão "kg/m2")
imc_teste = 22.5

classificacao, emoji = classificar_imc(imc_teste)
print(f"IMC {imc_teste} ({classificacao}) {emoji}")

# Chamada informando o parâmetro opcional
classificacao, emoji = classificar_imc(imc_teste, unidade="lb/in2")
print(f"Mesma chamada com unidade customizada: {classificacao} {emoji}")

# --- RECURSÃO BÁSICA ---

def contagem_regressiva(n):
    """Exibe contagem regressiva de n até 0 usando recursão."""

    if n < 0:   # CASO BASE: para a recursão
        return

    print(n)
    contagem_regressiva(n - 1)   # CHAMADA RECURSIVA: resolve problema menor


print("\n--- Contagem regressiva ---")
contagem_regressiva(5)


# Fatorial: exemplo clássico de recursão com retorno

def fatorial(n):
    """Calcula n! recursivamente. Ex: 5! = 5 x 4 x 3 x 2 x 1 = 120"""

    # caso base
    if n == 0 or n == 1:
        return 1

    # caso recursivo
    return n * fatorial(n - 1)


print("\n--- Fatorial ---")

for i in range(1, 7):
    print(f"{i}! = {fatorial(i)}")

def soma_regressiva(n):
    # caso base
    if n == 1:
        return 1
    
    # caso recursivo
    return n + soma_regressiva(n - 1)


# Teste
print(soma_regressiva(4))  # 10

# --- FUNÇÃO PRINCIPAL ---

def processar_pessoa():
    """Coleta dados, calcula IMC e exibe resultado completo."""

    nome = input("\nNome: ")
    peso = float(input("Peso (kg): "))
    altura = float(input("Altura (m): "))

    # calcula o IMC usando função já criada
    imc = calcular_imc(peso, altura)

    # obtém classificação e emoji
    classificacao, emoji = classificar_imc(imc)

    print("\n--- Resultado ---")
    print(f"Nome: {nome}")
    print(f"IMC: {imc:.2f} kg/m2")
    print(f"Classificação: {classificacao} {emoji}")


# --- EXECUÇÃO PRINCIPAL ---

exibir_cabecalho()

continuar = "s"

while continuar == "s":
    processar_pessoa()
    continuar = input("\nProcessar outra pessoa? (s/n): ").lower()

exibir_rodape()