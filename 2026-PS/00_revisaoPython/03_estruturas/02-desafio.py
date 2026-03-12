#==========================================
# SISTEMA DE BIBLIOTECA 
#==========================================
# Disciplina : Programação de Sistemas (PS)
# Aula : 05 - Revisao: Estrutura de Dados
# Autor : Luiz Henrique Schactae Brandão
# Data: 24/02/2026
# Descrição: Catalogo simples para registrar livros
# ===============================
# Catálogo inicial de livros
# ===============================

catalogo = [
    {"titulo": "Dom Casmurro", "autor": "Machado de Assis", "ano": 1899, "disponivel": True},
    {"titulo": "1984", "autor": "George Orwell", "ano": 1949, "disponivel": False},
    {"titulo": "O Pequeno Príncipe", "autor": "Antoine de Saint-Exupéry", "ano": 1943, "disponivel": True}
]

# ===============================
# Exibir catálogo de livros
# ===============================

print("📚 CATÁLOGO DA BIBLIOTECA\n")

for livro in catalogo:
    status = "Disponível" if livro["disponivel"] else "Emprestado"
    print(f'Título: {livro["titulo"]}')
    print(f'Autor: {livro["autor"]}')
    print(f'Status: {status}')
    print("-" * 30)


# ===============================
# Cadastro de novo livro
# ===============================

print("\n Cadastro de novo livro")

titulo = input("Digite o título do livro: ")
autor = input("Digite o autor do livro: ")
ano = int(input("Digite o ano de publicação: "))

novo_livro = {
    "titulo": titulo,
    "autor": autor,
    "ano": ano,
    "disponivel": True
}

catalogo.append(novo_livro)

print("\n✅ Livro cadastrado com sucesso!\n")

# ===============================
# Exibir catálogo atualizado
# ===============================

print("📚 CATÁLOGO ATUALIZADO\n")

for livro in catalogo:
    status = "Disponível" if livro["disponivel"] else "Emprestado"
    print(f'{livro["titulo"]} - {livro["autor"]} ({status})')


# ===============================
# Busca por autor
# ===============================

print("\n🔎 Buscar livros por autor")

busca = input("Digite o nome do autor: ").lower()

encontrados = []

for livro in catalogo:
    if busca in livro["autor"].lower():
        encontrados.append(livro)

if len(encontrados) == 0:
    print("Nenhum livro encontrado para esse autor.")
else:
    print("\nLivros encontrados:")
    for livro in encontrados:
        status = "Disponível" if livro["disponivel"] else "Emprestado"
        print(f'{livro["titulo"]} ({status})')


# ===============================
# Contagem de livros
# ===============================

disponiveis = 0
emprestados = 0

for livro in catalogo:
    if livro["disponivel"]:
        disponiveis += 1
    else:
        emprestados += 1

print("\n📊 Relatório da biblioteca")
print(f"Livros disponíveis: {disponiveis}")
print(f"Livros emprestados: {emprestados}")