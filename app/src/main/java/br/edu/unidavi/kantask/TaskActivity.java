package br.edu.unidavi.kantask;

import android.content.Intent;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import br.edu.unidavi.kantask.model.Tarefa;

public class TaskActivity extends AppCompatActivity {

    EditText descricao, prazo;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        descricao = (EditText) findViewById(R.id.input_descricao);
        prazo = (EditText) findViewById(R.id.input_prazo);

        salvar = (Button) findViewById(R.id.button_save);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Tarefa());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(Tarefa task){
//        hideDialog();
//
//        Session session = new Session(this);
//        session.setUserNameInSession(user.getName());
//        session.setTokenInSession(user.getToken());

        goHome();
    }

    private void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
