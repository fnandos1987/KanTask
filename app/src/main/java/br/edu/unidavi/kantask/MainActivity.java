package br.edu.unidavi.kantask;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.unidavi.kantask.adapter.TabsAdapter;
import br.edu.unidavi.kantask.fragment.DoFragment;
import br.edu.unidavi.kantask.fragment.DoingFragment;
import br.edu.unidavi.kantask.fragment.DoneFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
