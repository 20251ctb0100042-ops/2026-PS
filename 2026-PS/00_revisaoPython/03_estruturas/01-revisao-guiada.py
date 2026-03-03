#==========================================
# SISTEMA DE BIBLIOTECA 
#==========================================
# Disciplina : Programação de Sistemas (PS)
# Aula : 05 - Revisao: Estrutura de Dados
# Autor : Luiz Henrique Schactae Brandão
# Data: 24/02/2026
# Repositório:
#==========================================
#Descrição:
#Catálogo de livros que demonstra o uso de linhas
# e dicionário para armazenar,consultar e 
# filtrar dados estruturados
#==========================================


#-----LISTAS: CONCEITO -----#

# Criando uma lista de títulos

titulos = [
    "O Programador Pragmatico",
    "Código Limpo",
    "Entendendo Algoritmos",

]

# Acesso por índice (começa em 0, não em 1!)

print ("Primeiro livro:", titulos [0] ) 
print ("Último livro :", titulos [-1] ) # índice -1 = último elemento
print ("Total de livros:", len (titulos) )


#--METODOS DE LISTA--

print("\n--- Operações na lista ---")

# Adicionar um item ao final
titulos.append("Python Fluente")
print("Após append:", titulos)

# Verificar se um item existe
busca = "Código Limpo"
if busca in titulos:
    print(f'"{busca}" está no catálogo.')
else:
    print(f'"{busca}" não encontrado.')

# Ordenar a lista
titulos.sort()
print("Lista ordenada:", titulos)

# Remover um item
titulos.remove("Entendendo Algoritmos")
print("Após remove:", titulos)

# --- MODIFICANDO E CONSULTANDO ---

# Exemplo de dicionário
livro = {
    "titulo": "Código Limpo",
    "autor": "Robert C. Martin",
    "disponivel": True
}

# Atualizando um valor existente (livro foi emprestado)
livro["disponivel"] = False
print("\nApós empréstimo:", livro["disponivel"])

# Adicionando uma nova chave
livro["paginas"] = 352
print("Páginas:", livro["paginas"])

# .get() - acesso seguro: retorna None (ou padrão) se a chave não existir
# não lança KeyError, retorna o padrão informado
editora = livro.get("editora", "Não informada")
print("Editora:", editora)

# --- CATÁLOGO: LISTA DE DICIONÁRIOS ---

catalogo = [
    {
        "titulo": "O Programador Pragmatico",
        "autor": "Andrew Hunt",
        "ano": 1999,
        "disponivel": True
    },
    {
        "titulo": "Codigo Limpo",
        "autor": "Robert C. Martin",
        "ano": 2008,
        "disponivel": False
    },
    {
        "titulo": "Entendendo Algoritmos",
        "autor": "Aditya Bhargava",
        "ano": 2016,
        "disponivel": True
    }
]

print("=== Catálogo da Biblioteca ===")
print()

# Percorrendo cada livro com for
for livro in catalogo:
    status = "Disponível" if livro["disponivel"] else "Emprestado"
    
    print(f"{livro['titulo']} ({livro['ano']})")
    print(f"Autor: {livro['autor']} | Status: {status}")
    print("-" * 40)

# --- CONSULTAS E FILTROS ---

print("\n=== Livros disponíveis ===")
for livro in catalogo:
    if livro["disponivel"]:
        print(f"- {livro['titulo']}")

# Filtra apenas os disponíveis (usando list comprehension)
disponiveis = [livro for livro in catalogo if livro["disponivel"]]

print("\nTotal de livros disponíveis:", len(disponiveis))

# .lower() ignora maiúsculas/minúsculas
print("\n=== Busca por título ===")

busca = input("Digite o título (ou parte): ").lower()

encontrado = False

for livro in catalogo:
    if busca in livro["titulo"].lower():
        print(f"Encontrado: {livro['titulo']} - {livro['autor']}")
        encontrado = True

if not encontrado:
    print("Nenhum livro encontrado com esse termo.")

print("\n=== Atributos do primeiro livro ===")
for chave, valor in catalogo[0].items():
    print(f"{chave}: {valor}")

# .items() retorna pares (chave, valor)

# --- CONTAGEM DE LIVROS ---

contador_disponiveis = 0
contador_emprestados = 0

for livro in catalogo:
    if livro["disponivel"]:
        contador_disponiveis += 1
    else:
        contador_emprestados += 1

print(f"\nDisponíveis: {contador_disponiveis} | Emprestados: {contador_emprestados}")

