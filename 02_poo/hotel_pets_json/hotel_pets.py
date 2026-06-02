import json
import os

ARQUIVO_JSON = "pets.json"

class Pet:
    def __init__(self, nome, especie, idade, peso, nome_dono, vacinado, hospedado=False):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.peso = peso
        self.nome_dono = nome_dono
        self.vacinado = vacinado
        self.hospedado = hospedado

    def exibir_dados(self):
        print(f"\nNome: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Idade: {self.idade} anos")
        print(f"Peso: {self.peso} kg")
        print(f"Dono: {self.nome_dono}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")

    def para_dicionario(self):
        return {
            "nome": self.nome,
            "especie": self.especie,
            "idade": self.idade,
            "peso": self.peso,
            "nome_dono": self.nome_dono,
            "vacinado": self.vacinado,
            "hospedado": self.hospedado
        }
    
    @staticmethod
    def criar_de_dicionario(dados):
        return Pet(
            dados["nome"],
            dados["especie"],
            dados["idade"],
            dados["peso"],
            dados["nome_dono"],
            dados["vacinado"],
            dados["hospedado"]
        )
    
def salvar_pets(lista_pets):
    dados = [pet.para_dicionario() for pet in lista_pets]

    with open(ARQUIVO_JSON, "w", encoding="utf-8") as arquivo:
        json.dump(dados, arquivo, ensure_ascii=False, indent=4)

def carregar_pets():
    if not os.path.exists(ARQUIVO_JSON):
        return []

    with open(ARQUIVO_JSON, "r", encoding="utf-8") as arquivo:
        dados = json.load(arquivo)

    return [Pet.criar_de_dicionario(item) for item in dados]

def cadastrar_pet(lista_pets):
    print("\n=== CADASTRO DE PET ===")

    nome = input("Nome do pet: ")
    especie = input("Espécie: ")
    idade = int(input("Idade: "))
    peso = float(input("Peso: "))
    nome_dono = input("Nome do dono: ")

    vacinado = input("Vacinado? (s/n): ").lower() == "s"

    pet = Pet(nome, especie, idade, peso, nome_dono, vacinado)
    lista_pets.append(pet)

    salvar_pets(lista_pets)

    print("\nPet cadastrado com sucesso!")

def listar_pets(lista_pets):
    print("\n=== LISTA DE PETS ===")

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return

    for i, pet in enumerate(lista_pets, start=1):
        print(f"\n--- PET {i} ---")
        pet.exibir_dados()

def hospedar_pet(lista_pets):
    print("\n=== HOSPEDAR PET ===")

    nome = input("Digite o nome do pet: ")

    for pet in lista_pets:
        if pet.nome.lower() == nome.lower():
            pet.hospedado = True
            salvar_pets(lista_pets)
            print("\nPet hospedado com sucesso!")
            return

    print("\nPet não encontrado.")

def remover_pet(lista_pets):
    print("\n=== REMOVER PET ===")

    nome = input("Digite o nome do pet: ")

    for pet in lista_pets:
        if pet.nome.lower() == nome.lower():
            lista_pets.remove(pet)
            salvar_pets(lista_pets)
            print("\nPet removido com sucesso!")
            return

    print("\nPet não encontrado.")

def menu():
    pets = carregar_pets()

    while True:
        print("\n====== HOTEL PARA PETS ======")
        print("1 - Cadastrar pet")
        print("2 - Listar pets")
        print("3 - Hospedar pet")
        print("4 - Remover pet")
        print("0 - Sair")

        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_pet(pets)

        elif opcao == "2":
            listar_pets(pets)

        elif opcao == "3":
            hospedar_pet(pets)

        elif opcao == "4":
            remover_pet(pets)

        elif opcao == "0":
            print("\nEncerrando sistema...")
            break

        else:
            print("\nOpção inválida.")


menu()