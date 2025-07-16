package Gerenciador;

import java.util.ArrayList;
import java.util.List;

public class FiltroConcluidas implements FiltroStrategy {
    @Override
    public List<Tarefa> filtrar(List<Tarefa> tarefas) {
        List<Tarefa> resultado = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.isConcluida()) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}
