package br.edu.unidavi.kantask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private KanTaskApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabsAdapter adapter = new AbasAdapter(getSupportFragmentManager());
        adapter.adicionar( new PrimeiroFragment() , "Primeira Aba");
        adapter.adicionar( new SegundoFragment(), "Segunda Aba");

        ViewPager viewPager = (ViewPager) findViewById(R.id.abas_view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.abas);
        tabLayout.setupWithViewPager(viewPager);
    }
}
