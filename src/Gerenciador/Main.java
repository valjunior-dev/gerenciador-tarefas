package Gerenciador;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = GerenciadorTarefas.getInstancia();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Começa com o filtro padrão (todas as tarefas)
        FiltroStrategy filtro = new FiltroTodas();

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Escolher filtro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    break;
                case 2:
                    System.out.println("\n--- TAREFAS ---");
                    List<Tarefa> tarefasFiltradas = filtro.filtrar(gerenciador.listarTarefas());
                    int i = 0;
                    for (Tarefa tarefa : tarefasFiltradas) {
                        System.out.println(i + " - " + tarefa);
                        i++;
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa a concluir: ");
                    int indice = scanner.nextInt();
                    gerenciador.concluirTarefa(indice);
                    break;
                case 4:
                    System.out.println("\nEscolha o filtro:");
                    System.out.println("1. Todas");
                    System.out.println("2. Pendentes");
                    System.out.println("3. Concluídas");
                    int filtroEscolhido = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    switch (filtroEscolhido) {
                        case 1:
                            filtro = new FiltroTodas();
                            break;
                        case 2:
                            filtro = new FiltroPendentes();
                            break;
                        case 3:
                            filtro = new FiltroConcluidas();
                            break;
                        default:
                            System.out.println("Filtro inválido. Mantendo o atual.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
