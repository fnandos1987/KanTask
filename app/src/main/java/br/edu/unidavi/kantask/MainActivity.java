package br.edu.unidavi.kantask;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.unidavi.kantask.adapter.TabsAdapter;
import br.edu.unidavi.kantask.fragment.DoFragment;
import br.edu.unidavi.kantask.fragment.DoingFragment;
import br.edu.unidavi.kantask.fragment.DoneFragment;
import br.edu.unidavi.kantask.model.Status;
import br.edu.unidavi.kantask.model.Tarefa;
import br.edu.unidavi.kantask.utils.Session;
import br.edu.unidavi.kantask.utils.WaitDialog;

public class MainActivity extends AppCompatActivity {

    private TabsAdapter tabsAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTabs();

        Session s = new Session(this);

        TextView userName = findViewById(R.id.txt_user);
        userName.setText(s.getUserNameInSession());

        FloatingActionButton cardFab = findViewById(R.id.fab_new_task);
        cardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WaitDialog.showDialog(v.getContext());
                Intent intent = new Intent(v.getContext(), TaskActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton btnClose = findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session s = new Session(v.getContext());
                s.clearSession();

                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tabsAdapter.notifyDataSetChanged();
    }

    private void setupTabs(){
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        tabsAdapter.addTab(new DoFragment() , getResources().getString(R.string.fazer));
        tabsAdapter.addTab(new DoingFragment(), getResources().getString(R.string.fazendo));
        tabsAdapter.addTab(new DoneFragment(), getResources().getString(R.string.feito));

        viewPager = findViewById(R.id.tabs_view_pager);
        viewPager.setAdapter(tabsAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void moveTaskDialog(Tarefa tarefa) {
        final Tarefa newTask = tarefa;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View dialogMoveBoardView = inflater.inflate(R.layout.dialog_card_move, null);

        TextView desc = dialogMoveBoardView.findViewById(R.id.label_descricao);
        desc.setText(newTask.getDescricao());

        TextView prazo = dialogMoveBoardView.findViewById(R.id.label_prazo);
        prazo.setText(newTask.getPrazo());

        builder.setTitle(getResources().getString(R.string.choose_category_dialog))
                .setView(dialogMoveBoardView)
                .setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveCardToBoard(newTask);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cancel dialog
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void moveCardToBoard(Tarefa tarefa){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

        if(tarefa.getStatus() == Status.FAZER.getId()){
            tarefa.setStatus(Status.FAZENDO.getId());
            tarefa.setDataInicio(format.format(new Date()));
        } else if(tarefa.getStatus() == Status.FAZENDO.getId()) {
            tarefa.setStatus(Status.FEITO.getId());
            tarefa.setDataConlusao(format.format(new Date()));
        }

        KanTask.getInstance().updateTarefa(tarefa);
        setupTabs();
    }
}
