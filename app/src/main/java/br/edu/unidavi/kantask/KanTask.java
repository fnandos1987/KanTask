package br.edu.unidavi.kantask;

import java.util.ArrayList;

import br.edu.unidavi.kantask.model.Tarefa;

public class KanTask {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static final KanTask INSTANCE = new KanTask();

    private KanTask() {}

    public static KanTask getInstance() {
        return INSTANCE;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void addTarefa(Tarefa tarefa){
        tarefa.setId(tarefas.size());
        tarefas.add(tarefa);
    }

    public void updateTarefa(Tarefa tarefa){
        tarefas.set(tarefa.getId(), tarefa);
    }
}
