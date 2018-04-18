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


public class DoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_do, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setupRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        ArrayList<Tarefa> arrayList = new ArrayList<>();

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("do");
        tarefa.setPrazo("12/09/2018");
        tarefa.setPrioridade(Prioridade.ALTA.getId());
        tarefa.setStatus(Integer.parseInt("1"));

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setDescricao("do2");
        tarefa2.setPrazo("16/09/2018");
        tarefa2.setPrioridade(Prioridade.ALTA.getId());
        tarefa2.setStatus(Integer.parseInt("1"));

        arrayList.add(tarefa);
        arrayList.add(tarefa2);

        TaskAdapter taskAdapter = new TaskAdapter(arrayList, getActivity());
        recyclerView.setAdapter(taskAdapter);
    }
}
