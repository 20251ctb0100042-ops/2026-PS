import java.util.Random;
import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random gerador = new Random();

        String resumoPedido = "";
        double totalGeral = 0;

        while (true) {

            System.out.println("===========================");
            System.out.println("      FAST FOOD IFPR       ");
            System.out.println("===========================");
            System.out.println("1 - sybau ........ R$ 50,00");
            System.out.println("2 - ganley ....... R$ 12,00");
            System.out.println("3 - orelha ....... R$ 42,00");
            System.out.println("4 - sopa de morcego R$ 20,00");
            System.out.println("5 - inbugui ...... R$ 20,00");
            System.out.println("6 - Finalizar Pedido");
            System.out.println("===========================");

            System.out.print("Escolha: ");
            int opcao = entrada.nextInt();

            if (opcao == 6) {

                if (totalGeral == 0) {
                    System.out.println("Nenhum item foi adicionado.");
                    continue;
                }

                while (true) {

                    System.out.println("\n===========================");
                    System.out.println("     RESUMO DO PEDIDO");
                    System.out.println("===========================");
                    System.out.print(resumoPedido);
                    System.out.printf("\nTOTAL: R$ %.2f\n", totalGeral);

                    System.out.println("\n1 - Pagamento");
                    System.out.println("2 - Adicionar mais itens");
                    System.out.println("3 - Cancelar pedido");
                    System.out.print("Escolha: ");

                    int escolha = entrada.nextInt();

                    if (escolha == 2) {
                        break;
                    }

                    if (escolha == 3) {
                        System.out.println("Pedido cancelado.");
                        entrada.close();
                        return;
                    }

                    if (escolha == 1) {

                        while (true) {

                            System.out.println("\nForma de pagamento");
                            System.out.println("1 - Dinheiro");
                            System.out.println("2 - Cartão");
                            System.out.println("3 - PIX");
                            System.out.println("4 - Escambo");
                            System.out.println("5 - Voltar ao cardápio");
                            System.out.print("Escolha: ");

                            int pagamento = entrada.nextInt();

                            if (pagamento == 5) {
                                break;
                            }

                            if (pagamento >= 1 && pagamento <= 4) {

                                System.out.println("\nPagamento realizado com sucesso!");

                                int numeroPedido = gerador.nextInt(900) + 100;

                                System.out.println("Pedido Nº " + numeroPedido);
                                System.out.println("Aguarde a chamada do seu pedido.");

                                entrada.close();
                                return;
                            }

                            System.out.println("Opção inválida!");
                        }

                        break;
                    }

                    System.out.println("Opção inválida!");
                }

                continue;
            }

            String produto = "";
            double preco = 0;

            if (opcao == 1) {
                produto = "sybau";
                preco = 50;
            } else if (opcao == 2) {
                produto = "ganley";
                preco = 12;
            } else if (opcao == 3) {
                produto = "orelha";
                preco = 42;
            } else if (opcao == 4) {
                produto = "sopa de morcego";
                preco = 20;
            } else if (opcao == 5) {
                produto = "inbugui";
                preco = 20;
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = entrada.nextInt();

            double subtotal = preco * quantidade;

            totalGeral = totalGeral + subtotal;

            resumoPedido = resumoPedido
                    + quantidade + "x "
                    + produto
                    + " = R$ "
                    + String.format("%.2f", subtotal)
                    + "\n";

            System.out.println("Item adicionado ao pedido!\n");
        }
    }
}

