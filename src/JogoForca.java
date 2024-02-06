import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    public static void main(String[] args) {
        String palavraSecreta = escolherPalavra();
        char[] letrasReveladas = new char[palavraSecreta.length()];

        for (int i = 0; i < letrasReveladas.length; i++) {
            letrasReveladas[i] = '_';
        }

        int tentativasRestantes = 6;
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0) {
            System.out.println("\nPalavra: " + new String(letrasReveladas));
            System.out.println("Tentativas Restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);

            if (!adivinharLetra(letra, palavraSecreta, letrasReveladas)) {
                tentativasRestantes--;
            }

            if (palavraRevelada(letrasReveladas)) {
                System.out.println("\nParabéns! Você adivinhou a palavra: " + palavraSecreta);
                break;
            }
        }

        if (tentativasRestantes == 0) {
            System.out.println("\nVocê foi enforcado! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }

    private static String escolherPalavra() {
        String[] palavras = {"java", "programacao", "computador", "desenvolvimento", "algoritmo", "google", "chatGpt", "viagem", "moto", "gasolina", "tecnologia"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    private static boolean adivinharLetra(char letra, String palavraSecreta, char[] letrasReveladas) {
        boolean letraEncontrada = false;

        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                letrasReveladas[i] = letra;
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            System.out.println("Letra não encontrada na palavra.");
        }

        return letraEncontrada;
    }

    private static boolean palavraRevelada(char[] letrasReveladas) {
        for (char letra : letrasReveladas) {
            if (letra == '_') {
                return false;
            }
        }
        return true;
    }
}

