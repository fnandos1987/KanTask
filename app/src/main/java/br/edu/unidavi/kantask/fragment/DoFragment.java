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
import java.util.Collections;

import br.edu.unidavi.kantask.R;
import br.edu.unidavi.kantask.adapter.TaskAdapter;
import br.edu.unidavi.kantask.model.Prioridade;
import br.edu.unidavi.kantask.model.Tarefa;


public class DoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_do, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        ArrayList<Tarefa> arrayList = new ArrayList<>();

        Tarefa tarefa0 = new Tarefa();
        tarefa0.setDescricao("do");
        tarefa0.setPrazo("12/09/2018");
        tarefa0.setPrioridade(Prioridade.MEDIA.getId());
        tarefa0.setStatus(Integer.parseInt("1"));

        Tarefa tarefa1 = new Tarefa();
        tarefa1.setDescricao("do");
        tarefa1.setPrazo("12/09/2018");
        tarefa1.setPrioridade(Prioridade.NORMAL.getId());
        tarefa1.setStatus(Integer.parseInt("1"));

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setDescricao("do2");
        tarefa2.setPrazo("16/09/2018");
        tarefa2.setPrioridade(Prioridade.ALTA.getId());
        tarefa2.setStatus(Integer.parseInt("1"));

        arrayList.add(tarefa0);
        arrayList.add(tarefa1);
        arrayList.add(tarefa2);
        Collections.sort(arrayList);

        TaskAdapter taskAdapter = new TaskAdapter(arrayList, getActivity());
        recyclerView.setAdapter(taskAdapter);
    }
}
