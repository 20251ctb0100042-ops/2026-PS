public class Exercicio1 {

  public static double calcularMedia(double[] notas) {
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        return soma / notas.length;
    }

    public static void main(String[] args) {
        double[] notas = {7.0, 8.0, 9.0};

        System.out.println("Média: " + calcularMedia(notas));
    }
}