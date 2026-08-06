public class OperacaoMedia {
    
    public static int calcularMedia(int[] numeros) {
        if (numeros.length == 0) return 0;

        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma / numeros.length;
    }

    public static void main(String[] args){
        int[] numeros = {10, 25, 5, 40, 15};
        int resultado = calcularMedia(numeros);
        System.out.println("Média: " + resultado);
    }
}
