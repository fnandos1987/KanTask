package br.edu.unidavi.kantask.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.edu.unidavi.kantask.R;
import br.edu.unidavi.kantask.adapter.TaskAdapter;
import br.edu.unidavi.kantask.model.Prioridade;
import br.edu.unidavi.kantask.model.Tarefa;
import br.edu.unidavi.kantask.utils.DividerItemDecoration;

public class DoneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_done, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setupRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("done");
        tarefa.setPrazo("14/09/2018");
        tarefa.setDataConlusao("15/09/2018");
        tarefa.setPrioridade(Prioridade.ALTA.getId());
        tarefa.setStatus(Integer.parseInt("3"));

        ArrayList<Tarefa> arrayList = new ArrayList<>();
        arrayList.add(tarefa);

        TaskAdapter taskAdapter = new TaskAdapter(arrayList, getActivity());
        recyclerView.setAdapter(taskAdapter);
    }
}
