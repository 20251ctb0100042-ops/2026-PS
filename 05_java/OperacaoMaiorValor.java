public class OperacaoMaiorValor {

    public static int maiorValor(int[] numeros) {
        int maior = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];

            }
        }
        return maior;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 25, 5, 40, 15};
        int resultado = maiorValor(numeros);
        System.out.println("Maior valor: " + resultado);
    }
}
