package Gerenciador;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private static GerenciadorTarefas instancia;
    private List<Tarefa> tarefas;

    private GerenciadorTarefas() {
        tarefas = new ArrayList<>();
    }

    public static GerenciadorTarefas getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorTarefas();
        }
        return instancia;
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public void concluirTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarComoConcluida();
        }
    }
}
