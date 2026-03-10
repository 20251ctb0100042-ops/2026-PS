# Controle de estoque:

# Disciplina : Programação de Sistemas (PS)
# Aula : 04 - Revisao: Variaveis, Tipos e Controle de Fluxo
# Autor : Luiz Henrique Schactae Brandão
# Data: 24/02/2026
# Descrição: Programa simples para controle de estoque de uma loja de informática.
# Classifica produtos como Crítico, Adequado ou Excesso e permite consulta individual

# Lista de produtos (nome + quantidade)
produtos = [
    {"nome": "Mouse", "quantidade": 3},
    {"nome": "Teclado", "quantidade": 12},
    {"nome": "Monitor", "quantidade": 25}
]

# Contadores para o resumo
contador_critico = 0
contador_adequado = 0
contador_excesso = 0

print("=== ESTOQUE ===\n")

# Percorre todos os produtos usando for
for produto in produtos:
    nome = produto["nome"]
    quantidade = produto["quantidade"]

    # Classificação do estoque
    if quantidade < 5:
        situacao = "Crítico"
        contador_critico += 1
    elif 5 <= quantidade <= 20:
        situacao = "Adequado"
        contador_adequado += 1
    else:
        situacao = "Excesso"
        contador_excesso += 1

    # Exibição do produto
    print(f"Produto: {nome}")
    print(f"Quantidade: {quantidade}")
    print(f"Situação: {situacao}\n")

# Exibe resumo geral
print("=== RESUMO GERAL ===")
print(f"Produtos situação Crítica: {contador_critico}")
print(f"Produtos situação Adequada: {contador_adequado}")
print(f"Produtos situação de Excesso: {contador_excesso}")

# Consulta de produto específico
while True:
    consulta = input("\nDeseja consultar um produto específico? (s/n): ").lower()
    
    if consulta == "n":
        print("Programa encerrado.")
        break
    elif consulta == "s":
        nome_busca = input("Digite o produto: ")
        encontrado = False

        # Busca simples na lista
        for produto in produtos:
            if produto["nome"].lower() == nome_busca.lower():
                quantidade = produto["quantidade"]

                # Reclassifica para mostrar a situação
                if quantidade < 5:
                    situacao = "Crítico"
                elif 5 <= quantidade <= 20:
                    situacao = "Adequado"
                else:
                    situacao = "Excesso"

                print(f"\nProduto encontrado!")
                print(f"Quantidade: {quantidade}")
                print(f"Situação: {situacao}")
                encontrado = True
                break

        # Caso não encontre o produto
        if not encontrado:
            print("Produto não encontrado no estoque.")
    else:
        print("Opção inválida. Digite 's' ou 'n'.")