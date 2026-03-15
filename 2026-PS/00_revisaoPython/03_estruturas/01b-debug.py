# Disciplina : Programação de Sistemas (PS)
# Aula : 05 - Revisao: Estrutura de Dados
# Autor : Luiz Henrique Schactae Brandão
# Arquivo: 01b-debug.py
# ATENÇÃO: 4 erros propositais. Encontre e corrija todos!
# Descrição: Codigo com os 4 erros corrigidos

# ==========================================
# SISTEMA DE BIBLIOTECA
# ==========================================

catalogo = [
    {"titulo": "Codigo Limpo", "autor": "Robert C. Martin", "disponivel": True},
    {"titulo": "Entendendo Algoritmos", "autor": "Aditya Bhargava", "disponivel": False},
    {"titulo": "Pithon Fluente", "autor": "Luciano Ramalho", "disponivel": True},
]

# Primeiro livro
print("Primeiro livro:", catalogo[0]["titulo"])

# Listar apenas livros disponíveis
print("\nLivros disponíveis:")
for livro in catalogo:
    if livro["disponivel"]:  # forma simplificada
        print(f"✓ {livro['titulo']}")

# Total de livros
total = len(catalogo)
print(f"\nTotal livros: {total}")

# Mostrar informações completas do primeiro livro
print("\nDetalhes do primeiro livro:")
for chave, valor in catalogo[0].items():
    print(f"{chave}: {valor}")

# Mostrar autor do primeiro livro
primeiro_autor = catalogo[0]["autor"]
print("\nAutor do primeiro livro:", primeiro_autor)