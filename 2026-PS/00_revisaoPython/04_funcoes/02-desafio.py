# Arquivo: 02-desafio.py
# IFPR - Programa de Situação de Alunos
# Autor: Luiz Henrique Schactae Brandão
# Data: 2026-03-05
# Descrição: Calcula média e situação de alunos, gera relatório, com funções modulares.

# --- FUNÇÕES ---

def calcular_media(nota1, nota2):
    """Recebe duas notas e mostra a média aritmética."""
    return (nota1 + nota2) / 2


def verificar_situacao(media):
    """mostra a situação do aluno pela a média."""
    if media >= 6.0:
        return "Aprovado"
    elif media >= 4.0:
        return "Recuperação"
    else:
        return "Reprovou"


def solicitar_notas(nome_aluno):
    """Solicita para validar duas notas entre 0 e 10."""
    while True:
        try:
            nota1 = float(input(f"Digite a primeira nota de {nome_aluno} (0-10): "))
            nota2 = float(input(f"Digite a segunda nota de {nome_aluno} (0-10): "))
            if 0 <= nota1 <= 10 and 0 <= nota2 <= 10:
                return nota1, nota2
            else:
                print("Notas inválidas! Digite valores entre 0 e 10.")
        except ValueError:
            print("Entrada inválida! Digite números válidos.")


def gerar_relatorio(nome, media, situacao):
    """Exibe relatório completo do aluno."""
    print("\n--- Resultado do Aluno ---")
    print(f"Nome: {nome}")
    print(f"Média: {media:.2f}")
    print(f"Situação: {situacao}")
    print("-" * 30)


# --- PROGRAMA PRINCIPAL ---

def main():
    """Processa lista de 3 alunos usando todas as funções."""
    alunos = []
    # Coletando nomes
    for i in range(3):
        nome = input(f"\nDigite o nome do aluno {i+1}: ")
        alunos.append(nome)

    # Processando cada aluno
    for nome in alunos:
        nota1, nota2 = solicitar_notas(nome)
        media = calcular_media(nota1, nota2)
        situacao = verificar_situacao(media)
        gerar_relatorio(nome, media, situacao)


# --- EXECUÇÃO ---
if __name__ == "__main__":
    print("=" * 40)
    print("   SISTEMA SITUAÇÃO DE ALUNOS - IFPR")
    print("=" * 40)
    main()
    print("\nPrograma encerrado.")