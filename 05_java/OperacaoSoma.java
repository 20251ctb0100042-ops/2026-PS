public class OperacaoSoma {

    public static int calculaSoma(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 25, 5, 40, 15};
        int resultado = calculaSoma(numeros);
        System.out.println("Soma: " + resultado);
    }
}