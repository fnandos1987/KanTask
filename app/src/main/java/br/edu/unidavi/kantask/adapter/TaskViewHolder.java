package br.edu.unidavi.kantask.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.edu.unidavi.kantask.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    TextView labelDescricao;
    TextView labelPrazo;
    TextView labelPrioridade;
    TextView labelInicio;
    TextView labelFinal;

    public TaskViewHolder(View itemView) {
        super(itemView);
        labelDescricao = itemView.findViewById(R.id.label_descricao);
        labelPrazo = itemView.findViewById(R.id.label_prazo);
        labelPrioridade = itemView.findViewById(R.id.label_prioridade);
        labelInicio = itemView.findViewById(R.id.label_inicio);
        labelFinal = itemView.findViewById(R.id.label_final);
    }
}
