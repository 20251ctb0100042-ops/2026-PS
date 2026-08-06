public class OperacaoMenorValor {

    public static int menorValor(int[] numeros) {
        int menor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[1];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 25, 5, 40, 15};
        int resultado = menorValor(numeros);
        System.out.println("Menor valor: " + resultado);
    }
}
