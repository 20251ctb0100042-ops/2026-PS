# SISTEMA DE APROVAÇÃO DE ALUNOS

# Disciplina : Programação de Sistemas (PS)
# Aula : 04 - Revisao: Variaveis, Tipos e Controle de Fluxo
# Autor : Luiz Henrique Schactae Brandão
# Data: 24/02/2026
# Repositorio: Repositório:https://github.com/20251ctb0100042-ops/2026-PS

# ---- DADOS DA TURMA ----

turma = [
    {"nome": "Ana", "nota1": 8.0, "nota2": 7.5},
    {"nome": "Bruno", "nota1": 4.5, "nota2": 5.0},
    {"nome": "Carla", "nota1": 2.0, "nota2": 3.5},
]

print("--- Resultado da Turma ---\n")

for aluno in turma:
    nome = aluno["nome"]
    nota1 = aluno["nota1"]
    nota2 = aluno["nota2"]

    media = (nota1 + nota2) / 2

    if media >= 6.0:
        situacao = "✅ Aprovado"
    elif media >= 4.0:
        situacao = "⚠️ Recuperação"
    else:
        situacao = "❌ Reprovado"

    print(f"Aluno   : {nome}")
    print(f"Média   : {media:.2f}")
    print(f"Situação: {situacao}")
    print("-" * 30)



continuar = "s"

while continuar == "s":

    continuar = input("\nDeseja processar outro aluno? (s/n): ").lower()

    if continuar == "s":

        nome = input("Digite o nome do aluno: ")
        nota1 = float(input("Digite a nota 1 (0 a 10): "))
        nota2 = float(input("Digite a nota 2 (0 a 10): "))

        media = (nota1 + nota2) / 2

        if media >= 6.0:
            situacao = "✅ Aprovado"
        elif media >= 4.0:
            situacao = "⚠️ Recuperação"
        else:
            situacao = "❌ Reprovado"

        print("\n--- Resultado ---")
        print(f"Aluno   : {nome}")
        print(f"Média   : {media:.2f}")
        print(f"Situação: {situacao}")
        print("-" * 30)

print("\nEncerrando o programa...")
print("-" * 40)