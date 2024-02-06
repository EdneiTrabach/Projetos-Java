import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JogoBlackjack {

    public static void main(String[] args) {
        jogoBlackjack();
    }

    public static void jogoBlackjack() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Blackjack!");

        // Baralho
        ArrayList<String> baralho = new ArrayList<>();
        String[] naipes = {"Espadas", "Copas", "Ouros", "Paus"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "Ás"};

        for (String naipe : naipes) {
            for (String valor : valores) {
                baralho.add(valor + " de " + naipe);
            }
        }

        // Embaralhar o baralho
        Collections.shuffle(baralho);

        // Distribuir cartas iniciais
        ArrayList<String> maoUsuario = new ArrayList<>();
        ArrayList<String> maoComputador = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            maoUsuario.add(baralho.remove(0));
            maoComputador.add(baralho.remove(0));
        }

        // Exibir cartas iniciais
        System.out.println("Sua mão: " + maoUsuario);
        System.out.println("Computador: " + maoComputador.get(0) + " e uma carta oculta.");

        // Jogada do usuário
        while (pontuacao(maoUsuario) < 21) {
            System.out.print("Deseja comprar mais uma carta? (S/N): ");
            char escolha = scanner.next().charAt(0);

            if (escolha == 'S' || escolha == 's') {
                maoUsuario.add(baralho.remove(0));
                System.out.println("Sua mão: " + maoUsuario);
            } else {
                break;
            }
        }

        // Jogada do computador
        while (pontuacao(maoComputador) < 17) {
            maoComputador.add(baralho.remove(0));
        }

        // Exibir mãos finais
        System.out.println("\nMãos finais:");
        System.out.println("Sua mão: " + maoUsuario + " (Pontuação: " + pontuacao(maoUsuario) + ")");
        System.out.println("Computador: " + maoComputador + " (Pontuação: " + pontuacao(maoComputador) + ")");

        // Determinar vencedor
        determinarVencedor(maoUsuario, maoComputador);
    }

    public static int pontuacao(ArrayList<String> mao) {
        int pontuacao = 0;
        int ases = 0;

        for (String carta : mao) {
            String valor = carta.split(" ")[0];

            if (valor.equals("Ás")) {
                ases++;
                pontuacao += 11;
            } else if (valor.equals("Valete") || valor.equals("Dama") || valor.equals("Rei")) {
                pontuacao += 10;
            } else {
                pontuacao += Integer.parseInt(valor);
            }
        }

        // Tratar ases como 1 se necessário
        while (pontuacao > 21 && ases > 0) {
            pontuacao -= 10;
            ases--;
        }

        return pontuacao;
    }

    public static void determinarVencedor(ArrayList<String> maoUsuario, ArrayList<String> maoComputador) {
        int pontuacaoUsuario = pontuacao(maoUsuario);
        int pontuacaoComputador = pontuacao(maoComputador);

        System.out.println("\nResultado:");

        if (pontuacaoUsuario > 21) {
            System.out.println("Você estourou! Computador vence.");
        } else if (pontuacaoComputador > 21) {
            System.out.println("Computador estourou! Você vence.");
        } else if (pontuacaoUsuario > pontuacaoComputador) {
            System.out.println("Você vence!");
        } else if (pontuacaoUsuario < pontuacaoComputador) {
            System.out.println("Computador vence.");
        } else {
            System.out.println("Empate!");
        }
    }
}
