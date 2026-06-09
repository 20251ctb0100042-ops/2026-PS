import java.util.Random;
import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random gerador = new Random();

        // Variáveis para acumular o pedido
        String resumoPedido = "";
        double totalGeral = 0;
        int continuar = 1; // Controla se o usuário quer continuar comprando

        do {
            System.out.println("===========================");
            System.out.println("      FAST FOOD IFPR       ");
            System.out.println("===========================");
            System.out.println("1 - sybau ........ R$ 18,00");
            System.out.println("2 - ganley ............ R$ 35,00");
            System.out.println("3 - orelha ..... R$ 15,00");
            System.out.println("4 - sopa de morcego ..... R$  8,00");
            System.out.println("5 - inbugui .......... R$  6,00");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("===========================");

            System.out.print("Escolha: ");
            int opcao = entrada.nextInt();

            // Se o usuário escolher a opção 6 direto no menu principal
            if (opcao == 6) {
                if (totalGeral == 0) {
                    System.out.println("Nenhum item foi adicionado ao pedido. Programa encerrado.");
                    entrada.close();
                    return;
                }
                break; // Sai do laço e vai direto para o pagamento
            }

            String produto = "";
            double preco = 0;

            // Atribuição de produto e preço com base nas novas opções
            if (opcao == 1) {
                produto = "sybau";
                preco = 50.00;
            } else if (opcao == 2) {
                produto = "ganley";
                preco = 12.00;
            } else if (opcao == 3) {
                produto = "orelha";
                preco = 42.00;
            } else if (opcao == 4) {
                produto = "sopa de morcego";
                preco = 20.00;
            } else if (opcao == 5) {
                produto = "inbugui";
                preco = 20.00;
            } else {
                System.out.println("Opção inválida! Tente novamente.\n");
                continue; // Volta para o início do menu
            }

            System.out.print("\nQuantidade: ");
            int quantidade = entrada.nextInt();

            // Calcula o valor deste item
            double subtotal = preco * quantidade;
            
            // Acumula o valor no total geral
            totalGeral += subtotal;

            // Alinha o texto do resumo (String.format ajuda a colocar os pontinhos "...")
            resumoPedido += String.format("%dx %-20s R$ %.2f%n", quantidade, produto + " ", subtotal).replace(' ', '.');

            System.out.println("\nItem adicionado ao pedido!");

            // Pergunta se deseja continuar comprando
            System.out.println("\nDeseja continuar comprando?");
            System.out.println("1 - Sim");
            System.out.println("2 - Finalizar");
            System.out.print("\nEscolha: ");
            continuar = entrada.nextInt();
            System.out.println("===========================\n");

        } while (continuar == 1);

        // ===========================
        //       RESUMO DO PEDIDO
        // ===========================
        System.out.println("===========================");
        System.out.println("     RESUMO DO PEDIDO      ");
        System.out.println("===========================");
        
        // Exibe todos os itens acumulados (ajustando os pontinhos que o replace alterou por engano nas quebras de linha)
        System.out.print(resumoPedido.replace(".\n", "\n"));
        
        System.out.printf("%nTOTAL: R$ %.2f%n", totalGeral);
        System.out.println("===========================");

        // ===========================
        //    FORMA DE PAGAMENTO
        // ===========================
        System.out.println("\nForma de pagamento:\n");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - PIX");
        System.out.println("4 - Escambo");
        System.out.print("\nEscolha: ");
        int formaPagamento = entrada.nextInt();

        System.out.println("\nPagamento realizado com sucesso!");

        // Gera um número de pedido aleatório (ex: entre 100 e 999)
        int numeroPedido = gerador.nextInt(900) + 100; 
        System.out.println("\nPedido Nº " + numeroPedido);
        System.out.println("\nAguarde a chamada do seu pedido.");

        entrada.close();
    }
}


