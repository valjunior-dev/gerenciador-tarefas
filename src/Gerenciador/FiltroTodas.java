package Gerenciador;

import java.util.List;

public class FiltroTodas implements FiltroStrategy {
    @Override
    public List<Tarefa> filtrar(List<Tarefa> tarefas) {
        return tarefas;
    }
}
