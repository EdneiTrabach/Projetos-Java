import java.util.ArrayList;
import java.util.Scanner;

public class AgendadorCompromissos {

    public static void main(String[] args) {
        agendadorCompromissos();
    }

    public static void agendadorCompromissos() {
        ArrayList<String> calendario = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Agendador de Compromissos =====");
            System.out.println("1. Adicionar Compromisso");
            System.out.println("2. Exibir Compromissos");
            System.out.println("3. Remover Compromisso");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção (1-4): ");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do teclado

            switch (escolha) {
                case 1:
                    System.out.print("Digite o compromisso a ser adicionado: ");
                    String compromisso = scanner.nextLine();
                    calendario.add(compromisso);
                    System.out.println("Compromisso adicionado com sucesso!");
                    break;
                case 2:
                    if (calendario.isEmpty()) {
                        System.out.println("O calendário está vazio. Nenhum compromisso agendado.");
                    } else {
                        System.out.println("===== Compromissos Agendados =====");
                        for (int i = 0; i < calendario.size(); i++) {
                            System.out.println((i + 1) + ". " + calendario.get(i));
                        }
                    }
                    break;
                case 3:
                    if (calendario.isEmpty()) {
                        System.out.println("O calendário está vazio. Nenhum compromisso para remover.");
                    } else {
                        System.out.print("Digite o número do compromisso a ser removido: ");
                        int indiceRemover = scanner.nextInt();

                        if (indiceRemover >= 1 && indiceRemover <= calendario.size()) {
                            calendario.remove(indiceRemover - 1);
                            System.out.println("Compromisso removido com sucesso!");
                        } else {
                            System.out.println("Índice inválido. Compromisso não encontrado.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo do agendador de compromissos. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
