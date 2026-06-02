import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String produto = "";
        double preco = 0;

        System.out.println("=================================");
        System.out.println("     CARDÁPIO ELETRÔNICO");
        System.out.println("=================================");
        System.out.println("1 - X-Burguer .......... R$ 18,00");
        System.out.println("2 - Pizza .............. R$ 35,00");
        System.out.println("3 - Suco Natural ....... R$ 8,00");
        System.out.println("4 - Café ............... R$ 5,00");
        System.out.println("=================================");

        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            produto = "X-Burguer";
            preco = 18.00;
        } else if (opcao == 2) {
            produto = "Pizza";
            preco = 35.00;
        } else if (opcao == 3) {
            produto = "Suco Natural";
            preco = 8.00;
        } else if (opcao == 4) {
            produto = "Café";
            preco = 5.00;
        } else {
            System.out.println("Opção inválida.");
            entrada.close();
            return;
        }

        // Perguntar quantidade
        System.out.print("Digite a quantidade desejada: ");
        int quantidade = entrada.nextInt();

        // Calcular valor total
        double total = preco * quantidade;

        // Resumo final
        System.out.println("\n========== RESUMO DO PEDIDO ==========");
        System.out.println("Produto: " + produto);
        System.out.println("Preço unitário: R$ " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Valor total: R$ %.2f%n", total);
        System.out.println("======================================");

        entrada.close();
    }
}
