import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            mostrarMenu();

            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    listarAlunos();
                    break;

                case 3:
                    buscarAluno();
                    break;

                case 4:
                    atualizarAluno();
                    break;

                case 5:
                    removerAluno();
                    break;

                case 6:
                    gerarRelatorio();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // =========================
    // MENU
    // =========================

    public static void mostrarMenu() {

        System.out.println("\n=================================");
        System.out.println("       SISTEMA DE SECRETARIA");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Buscar por matrícula");
        System.out.println("4 - Atualizar aluno");
        System.out.println("5 - Remover aluno");
        System.out.println("6 - Relatório");
        System.out.println("0 - Sair");
        System.out.println("=================================");
    }

    // =========================
    // CADASTRAR
    // =========================

    public static void cadastrarAluno() {

        System.out.println("\n===== CADASTRO DE ALUNO =====");

        String matricula = lerTexto("Digite a matrícula: ");

        // Verifica se a matrícula já existe
        if (buscarPorMatricula(matricula) != null) {
            System.out.println("Erro: essa matrícula já está cadastrada.");
            return;
        }

        String nome = lerTexto("Digite o nome: ");
        String curso = lerTexto("Digite o curso: ");

        int idade = lerInteiro("Digite a idade: ");

        while (idade <= 0) {
            System.out.println("A idade deve ser maior que zero.");
            idade = lerInteiro("Digite a idade novamente: ");
        }

        String atributoExtra = lerTexto("Digite o atributo extra: ");

        Aluno aluno = new Aluno(
                matricula,
                nome,
                curso,
                idade,
                atributoExtra
        );

        alunos.add(aluno);

        System.out.println("\nAluno cadastrado com sucesso!");
    }

    // =========================
    // LISTAR
    // =========================

    public static void listarAlunos() {

        System.out.println("\n===== LISTA DE ALUNOS =====");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }


    public static void buscarAluno() {

        System.out.println("\n BUSCAR ALUNO ");

        String matricula = lerTexto("Digite a matrícula: ");

        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("\nAluno encontrado:");
            System.out.println(aluno);
        }
    }

    // Método reutilizado pelo sistema
    public static Aluno buscarPorMatricula(String matricula) {

        for (Aluno aluno : alunos) {

            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return aluno;
            }
        }

        return null;
    }

    // =========================
    // ATUALIZAR
    // =========================

    public static void atualizarAluno() {

        System.out.println("\n===== ATUALIZAR ALUNO =====");

        String matricula = lerTexto("Digite a matrícula do aluno: ");

        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("\nAluno atual:");
        System.out.println(aluno);

        System.out.println("\nDigite os novos dados:");

        String novoNome = lerTexto("Novo nome: ");
        String novoCurso = lerTexto("Novo curso: ");
        int novaIdade = lerInteiro("Nova idade: ");

        while (novaIdade <= 0) {
            System.out.println("A idade deve ser maior que zero.");
            novaIdade = lerInteiro("Digite a idade novamente: ");
        }

        String novoAtributoExtra = lerTexto("Novo atributo extra: ");

        aluno.setNome(novoNome);
        aluno.setCurso(novoCurso);
        aluno.setIdade(novaIdade);
        aluno.setAtributoExtra(novoAtributoExtra);

        System.out.println("\nAluno atualizado com sucesso!");
    }

    // =========================
    // REMOVER
    // =========================

    public static void removerAluno() {

        System.out.println("\n===== REMOVER ALUNO =====");

        String matricula = lerTexto("Digite a matrícula do aluno: ");

        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("\nAluno encontrado:");
        System.out.println(aluno);

        String confirmacao = lerTexto(
                "\nDeseja realmente remover este aluno? (S/N): "
        );

        if (confirmacao.equalsIgnoreCase("S")) {

            alunos.remove(aluno);

            System.out.println("Aluno removido com sucesso!");

        } else {

            System.out.println("Remoção cancelada.");
        }
    }

    // =========================
    // RELATÓRIO
    // =========================

    public static void gerarRelatorio() {

        System.out.println("\n===== RELATÓRIO =====");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("Total de alunos: " + alunos.size());

        ArrayList<String> cursos = new ArrayList<>();

        for (Aluno aluno : alunos) {

            String curso = aluno.getCurso();

            if (!cursos.contains(curso)) {
                cursos.add(curso);
            }
        }

        System.out.println("\nAlunos por curso:");

        for (String curso : cursos) {

            int quantidade = 0;

            for (Aluno aluno : alunos) {

                if (aluno.getCurso().equalsIgnoreCase(curso)) {
                    quantidade++;
                }
            }

            System.out.println("- " + curso + ": " + quantidade);
        }
    }

    // =========================
    // LER TEXTO
    // =========================

    public static String lerTexto(String mensagem) {

        String texto;

        do {

            System.out.print(mensagem);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Esse campo não pode ficar vazio.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    // =========================
    // LER INTEIRO
    // =========================

    public static int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                int valor = Integer.parseInt(scanner.nextLine());

                return valor;

            } catch (NumberFormatException e) {

                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}  