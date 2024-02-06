import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

    public static void main(String[] args) {
        jogoAdivinhacao();
    }

    public static void jogoAdivinhacao() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativas = 0;
        int limiteTentativas = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo da Adivinhação!");
        System.out.println("Tente adivinhar o número entre 1 e 100.");

        while (tentativas < limiteTentativas) {
            System.out.print("Digite sua tentativa: ");
            int tentativa = scanner.nextInt();

            if (tentativa == numeroAleatorio) {
                System.out.println("Parabéns! Você acertou o número " + numeroAleatorio + " em " + (tentativas + 1) + " tentativas.");
                break;
            } else if (tentativa < numeroAleatorio) {
                System.out.println("Tente um número maior.");
            } else {
                System.out.println("Tente um número menor.");
            }

            tentativas++;
        }

        if (tentativas == limiteTentativas) {
            System.out.println("Você atingiu o limite de tentativas. O número correto era " + numeroAleatorio + ".");
        }
    }
}
