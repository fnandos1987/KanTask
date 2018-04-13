package br.edu.unidavi.kantask;

import android.app.Application;

import java.util.ArrayList;

import br.edu.unidavi.kantask.model.Tarefa;

public class KanTaskApplication extends Application {

    public ArrayList<Tarefa> fazer = new ArrayList<>();
    public ArrayList<Tarefa> fazendo = new ArrayList<>();
    public ArrayList<Tarefa> feito = new ArrayList<>();
}
