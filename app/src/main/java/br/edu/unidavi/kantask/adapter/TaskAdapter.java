package br.edu.unidavi.kantask.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import br.edu.unidavi.kantask.model.Tarefa;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    List<Tarefa> taskList;
    Context context;

    public TaskAdapter(List<Tarefa> taskList, Context context){
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
