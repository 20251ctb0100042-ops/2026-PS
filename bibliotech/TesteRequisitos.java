
public class TesteRequisitos {

    private static int passaram = 0;
    private static int falharam = 0;

    private static void verificar(String nome, boolean resultado) {
        if (resultado) {
            System.out.println("OK      " + nome);
            passaram++;
        } else {
            System.out.println("FALHOU  " + nome);
            falharam++;
        }
    }

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Livro dom = new Livro(
            "Dom Casmurro", "Machado de Assis", 1899
        );

        Livro capitaes = new Livro(
            "Capitaes da Areia", "Jorge Amado", 1937
        );

        Leitor pedro = new Leitor("Pedro Alves", "2026010", 1);
        Leitor ana = new Leitor("Ana Lima", "2026011", 2);

        biblioteca.cadastrarLivro(dom);
        biblioteca.cadastrarLivro(capitaes);
        biblioteca.cadastrarLeitor(pedro);
        biblioteca.cadastrarLeitor(ana);

        // RF01: livro cadastrado aparece na busca.
        verificar("RF01 livro cadastrado aparece na busca",
            biblioteca.buscarLivro("Dom Casmurro") == dom);

        // RF02: leitor cadastrado aparece na busca.
        verificar("RF02 leitor cadastrado aparece na busca",
            biblioteca.buscarLeitor("2026010") == pedro);

        // RF03: disponibilidade e busca.
        verificar("RF03 livro novo esta disponivel",
            dom.estaDisponivel());

        verificar("RF03 titulo fora do acervo nao e encontrado",
            biblioteca.buscarLivro("O Cortico") == null);

        // RF05: realizar emprestimos.
        verificar("RF05 emprestimo de livro disponivel e aceito",
            biblioteca.emprestar("Dom Casmurro", "2026010"));

        verificar("RF05 livro emprestado fica indisponivel",
            !dom.estaDisponivel());

        verificar("RF05 leitor passa a ter 1 livro em maos",
            pedro.getLivrosEmMaos() == 1);

        verificar("RF05 livro emprestado e recusado para outro leitor",
            !biblioteca.emprestar("Dom Casmurro", "2026011"));

        verificar("RF05 leitor no limite e recusado",
            !biblioteca.emprestar("Capitaes da Areia", "2026010"));

        // RF04: registrar a devolucao.
        verificar("RF04 devolucao de emprestimo ativo e aceita",
            biblioteca.devolver("Dom Casmurro"));

        verificar("RF04 livro devolvido volta a ficar disponivel",
            dom.estaDisponivel());

        verificar("RF04 segunda devolucao e recusada",
            !biblioteca.devolver("Dom Casmurro"));

        System.out.println();
        System.out.println(passaram + " passaram, "
            + falharam + " falharam.");
    }
}
