public class Main {

    public static void main(String[] args) {

        System.out.println("BiblioTech v0.2 - as classes existem");

        Livro l1 = new Livro(
            "Dom Casmurro",
            "Machado de Assis",
            1899
        );

        Livro l2 = new Livro(
            "Capitaes da Areia",
            "Jorge Amado",
            1937
        );

        System.out.println(l1);
        System.out.println(l2);

        Leitor leitor = new Leitor(
            "Pedro Alves",
            "2026010",
            3
        );

        System.out.println(leitor);

        Bibliotecario bibliotecario = new Bibliotecario(
            "Marli Souza",
            "1998002",
            "F-0421"
        );

        System.out.println(bibliotecario);

        System.out.println(
            "Nome do leitor, via heranca: " + leitor.getNome()
        );

        System.out.println(
            "Pedro pode pegar livro? " + leitor.podePegarEmprestado()
        );

        System.out.println(
            "Marli entrou? " + bibliotecario.entrar()
        );

        l1.emprestar();
        leitor.pegouLivro();

        System.out.println(
            "Depois do emprestimo: " + l1
        );

        System.out.println(
            "Depois do emprestimo: " + leitor
        );
    }
}