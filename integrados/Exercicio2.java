public class Exercicio2 {

    public static int contarAprovados(double[] notas) {
        int aprovados = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 6.0) {
                aprovados++;
            }
        }

        return aprovados;
    }

    public static void main(String[] args) {
        double[] notas = {7.0, 4.0, 9.0, 6.0};

        System.out.println("Aprovados: " + contarAprovados(notas));
    }
}