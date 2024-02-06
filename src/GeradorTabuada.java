import java.util.Scanner;

public class GeradorTabuada {

    public static void main(String[] args) {
        geradorTabuada();
    }

    public static void geradorTabuada() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para gerar a tabuada: ");
        int numero = scanner.nextInt();

        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
}
