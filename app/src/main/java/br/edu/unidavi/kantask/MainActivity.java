package br.edu.unidavi.kantask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private KanTaskApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application = (KanTaskApplication) getApplication();
        application.fazer.clear();
        application.fazendo.clear();
        application.feito.clear();
    }
}
