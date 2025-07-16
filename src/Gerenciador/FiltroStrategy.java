package Gerenciador;

import java.util.List;

public interface FiltroStrategy {
    List<Tarefa> filtrar(List<Tarefa> tarefas);
}
