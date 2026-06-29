import java.util.ArrayList;

public class Exercicio3 {

    public static void adicionarProduto(ArrayList<String> lista, String nome) {
        lista.add(nome);
    }

    public static void listarProdutos(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
    }

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();

        adicionarProduto(lista, "Pizza");
        adicionarProduto(lista, "Suco");

        listarProdutos(lista);
    }
}
