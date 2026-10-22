
public class TesteLivroDAO {

    public static void main(String[] args) {

        LivroDAO dao = new LivroDAO();

        boolean resultado = dao.excluirLivro(2);

        if (resultado) {
            System.out.println("Livro excluído com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o livro.");
        }
    }
}


