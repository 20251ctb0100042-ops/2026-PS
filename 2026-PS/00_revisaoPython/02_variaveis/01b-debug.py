# SISTEMA DE APROVAÇÃO DE ALUNOS

# Disciplina : Programação de Sistemas (PS)
# Aula : 04 - Revisao: Variaveis, Tipos e Controle de Fluxo
# Autor : Luiz Henrique Schactae Brandão
# Data: 24/02/2026
# Arquivo: 01b-debug.py
# ATENÇÃO: Este código contém 4 erros propositais. Encontre e corrija todos!

nome = input("Digite nome do aluno: ")
nota1 = float(input("Digite nota 1: "))
nota2 = float(input("Digite nota 2: "))

media = (nota1 + nota2) / 2

if media >= 6.0:
    situacao = "Aprovado"
elif media >= 4.0:
    situacao = "Recuperacão"
else:
    situacao = "Reprovado"

print(f"Aluno: {nome} | Média: {media:.2f} | Situação: {situacao}")