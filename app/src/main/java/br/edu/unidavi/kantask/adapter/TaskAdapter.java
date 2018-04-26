package br.edu.unidavi.kantask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.edu.unidavi.kantask.MainActivity;
import br.edu.unidavi.kantask.R;
import br.edu.unidavi.kantask.model.Status;
import br.edu.unidavi.kantask.model.Tarefa;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    List<Tarefa> taskList;
    Context context;

    public TaskAdapter(List<Tarefa> taskList, Context context){
        this.taskList = taskList;
        this.context = context;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_task,
                        parent,
                        false);

        TaskViewHolder myViewHolder = new TaskViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        final Tarefa task = taskList.get(position);

        holder.labelDescricao.setText(task.getDescricao());
        holder.labelPrazo.setText(task.getPrazo());
        holder.labelPrioridade.setText(task.getDescricaoPrioridade());
        holder.labelInicio.setText(task.getDataInicio());
        holder.labelFinal.setText(task.getDataConlusao());

        if(task.getStatus() == Status.FAZER.getId()){
            holder.labelInicio.setVisibility(View.GONE);
            holder.labelFinal.setVisibility(View.GONE);
        } else if(task.getStatus() == Status.FAZENDO.getId()) {
            holder.labelFinal.setVisibility(View.GONE);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(task.getStatus() != Status.FEITO.getId()){
                    ((MainActivity) view.getContext()).moveTaskDialog(task);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
