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
                    cadastrar(alunos, scanner);
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
                    remover(alunos, scanner);
                    break;

                case 6:
                    gerarRelatorio();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida! Vale 0, 1, 2, 3, 4, 5 ou 6.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // =========================
    // MENU
    // =========================

    public static void mostrarMenu() {

        System.out.println("\n=================================");
        System.out.println("       SECRETARIA DO CAMPUS - por Luiz Henrique      ");
        System.out.println("=================================");
        System.out.println("[1] Cadastrar aluno");
        System.out.println("[2] Listar alunos");
        System.out.println("[3] Buscar por matrícula");
        System.out.println("[4] Atualizar curso");
        System.out.println("[5] Remover aluno");
        System.out.println("[6] Relatório");
        System.out.println("[0] Sair");
        System.out.println("=================================");
    }

    // =========================
    // CADASTRAR (Fase 2 + Validação de Campos Vazio)
    // =========================

    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Erro: O campo Nome é obrigatório e não pode ficar vazio!");
            return; // sai do método e volta ao menu
        }

        System.out.print("Matricula: ");
        String matricula = teclado.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("Erro: O campo Matrícula é obrigatório e não pode ficar vazio!");
            return; // sai do método e volta ao menu
        }

        // MATRICULA UNICA: busca ANTES de inserir. Se ja existe, desiste.
        Aluno existente = buscarPorMatricula(lista, matricula);
        if (existente != null) {
            System.out.println("Ja existe ficha com a matricula " + matricula + "!");
            return;   // sai do metodo agora; nao cadastra
        }

        System.out.print("Curso: ");
        String curso = teclado.nextLine().trim();
        if (curso.isEmpty()) {
            System.out.println("Erro: O campo Curso é obrigatório e não pode ficar vazio!");
            return; // sai do método e volta ao menu
        }

        System.out.print("Cidade: ");
        String cidade = teclado.nextLine().trim();
        if (cidade.isEmpty()) {
            System.out.println("Erro: O campo Cidade é obrigatório e não pode ficar vazio!");
            return; // sai do método e volta ao menu
        }

        Aluno novo = new Aluno(nome, matricula, curso, cidade);
        lista.add(novo);
        System.out.println("Ficha de " + novo.getNome() + " arquivada!");
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

        for (Aluno a : alunos) {
            System.out.println(a);   // A impressao utiliza o toString automaticamente
        }
    }

    // =========================
    // BUSCAR
    // =========================

    public static void buscarAluno() {

        System.out.println("\n BUSCAR ALUNO ");

        String matricula = lerTexto("Digite a matrícula: ");

        Aluno aluno = buscarPorMatricula(alunos, matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("\nAluno encontrado:");
            System.out.println(aluno);
        }
    }

    // Método reutilizado pelo sistema
    public static Aluno buscarPorMatricula(ArrayList<Aluno> lista, String matricula) {
        for (int i = 0; i < lista.size(); i++) {
            Aluno a = lista.get(i);
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    // =========================
    // ATUALIZAR
    // =========================

    public static void atualizarAluno() {
        atualizar(alunos, scanner);
    }

    public static void atualizar(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a atualizar: ");
        String matricula = teclado.nextLine().trim();
        Aluno a = buscarPorMatricula(lista, matricula);
        if (a == null) {
            System.out.println("Nenhuma ficha com a matricula " + matricula + ".");
            return;
        }
        System.out.print("Novo curso de " + a.getNome() + ": ");
        String novoCurso = teclado.nextLine().trim();

        a.setCurso(novoCurso);
        System.out.println("Ficha atualizada: " + a);
    }

    // =========================
    // REMOVER (Fase 1)
    // =========================

    static void remover(ArrayList<Aluno> lista, Scanner teclado) {
        System.out.print("Matricula da ficha a remover: ");
        String matricula = teclado.nextLine().trim();
        Aluno a = buscarPorMatricula(lista, matricula);
        if (a == null) {
            System.out.println("Nenhuma ficha com a matricula " + matricula + ".");
            return;
        }
        System.out.print("Tem certeza que remove " + a.getNome() + "? (s/n): ");
        String resposta = teclado.nextLine().trim();
        if (resposta.equals("s")) {
            lista.remove(a);     // remove ESTA ficha (a mesma referencia achada)
            System.out.println("Ficha removida.");
        } else {
            System.out.println("Remocao cancelada.");
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