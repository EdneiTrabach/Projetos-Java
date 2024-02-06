import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {

    public static void main(String[] args) {
        gerenciadorTarefas();
    }

    public static void gerenciadorTarefas() {
        ArrayList<String> listaTarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Gerenciador de Tarefas =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Exibir Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção (1-5): ");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do teclado

            switch (escolha) {
                case 1:
                    System.out.print("Digite a nova tarefa: ");
                    String novaTarefa = scanner.nextLine();
                    listaTarefas.add(novaTarefa);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                case 2:
                    if (listaTarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia.");
                    } else {
                        System.out.println("===== Lista de Tarefas =====");
                        for (int i = 0; i < listaTarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + listaTarefas.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa que deseja atualizar: ");
                    int indiceAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer do teclado

                    if (indiceAtualizar >= 1 && indiceAtualizar <= listaTarefas.size()) {
                        System.out.print("Digite a nova descrição da tarefa: ");
                        String novaDescricao = scanner.nextLine();
                        listaTarefas.set(indiceAtualizar - 1, novaDescricao);
                        System.out.println("Tarefa atualizada com sucesso!");
                    } else {
                        System.out.println("Índice inválido. Tarefa não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da tarefa que deseja remover: ");
                    int indiceRemover = scanner.nextInt();

                    if (indiceRemover >= 1 && indiceRemover <= listaTarefas.size()) {
                        listaTarefas.remove(indiceRemover - 1);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Índice inválido. Tarefa não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do gerenciador de tarefas. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
