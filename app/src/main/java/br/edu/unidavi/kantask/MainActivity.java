package br.edu.unidavi.kantask;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.edu.unidavi.kantask.adapter.TabsAdapter;
import br.edu.unidavi.kantask.fragment.DoFragment;
import br.edu.unidavi.kantask.fragment.DoingFragment;
import br.edu.unidavi.kantask.fragment.DoneFragment;
import br.edu.unidavi.kantask.utils.WaitDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTabs();

        FloatingActionButton cardFab = (FloatingActionButton) findViewById(R.id.fab_new_task);
        cardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WaitDialog.showDialog(v.getContext());
                newTask();
            }
        });
    }

    private void newTask(){
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupTabs(){
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addTab(new DoFragment() , "A Fazer");
        adapter.addTab(new DoingFragment(), "Fazendo");
        adapter.addTab(new DoneFragment(), "Feito");

        ViewPager viewPager = (ViewPager) findViewById(R.id.tabs_view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
