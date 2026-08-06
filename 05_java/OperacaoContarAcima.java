public class OperacaoContarAcima {

    public static int contarAcima(int[] numeros, int limite) {
        int contador = 0;
        for (int num : numeros) {
            if (num > limite) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 25, 5, 40, 15};
        int limite = 15;
        int resultado = contarAcima(numeros, limite);
        System.out.println("Quantidade acima de " + limite + ": " + resultado);
    }
}