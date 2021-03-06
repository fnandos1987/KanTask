package br.edu.unidavi.kantask.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import br.edu.unidavi.kantask.KanTask;
import br.edu.unidavi.kantask.MainActivity;
import br.edu.unidavi.kantask.R;
import br.edu.unidavi.kantask.adapter.TaskAdapter;
import br.edu.unidavi.kantask.model.Prioridade;
import br.edu.unidavi.kantask.model.Status;
import br.edu.unidavi.kantask.model.Tarefa;


public class DoFragment extends Fragment {

    TaskAdapter taskAdapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        ArrayList<Tarefa> arrayList = new ArrayList<>();
        for(Tarefa task: KanTask.getInstance().getTarefas()){
            if(task.getStatus() == Status.FAZER.getId()){
                arrayList.add(task);
            }
        }

        Collections.sort(arrayList);

        taskAdapter = new TaskAdapter(arrayList, getActivity());
        recyclerView.setAdapter(taskAdapter);
    }
}
