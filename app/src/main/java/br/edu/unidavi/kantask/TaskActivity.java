package br.edu.unidavi.kantask;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.greenrobot.eventbus.EventBus;

import br.edu.unidavi.kantask.model.Prioridade;
import br.edu.unidavi.kantask.model.Status;
import br.edu.unidavi.kantask.model.Tarefa;
import br.edu.unidavi.kantask.utils.DateInputMask;

public class TaskActivity extends AppCompatActivity {

    private EditText descricao, prazo;
    private TextInputLayout descInputLayout, prazoInputLayout;
    private Button salvar, cancelar;
    private RadioGroup radioPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        descricao = findViewById(R.id.input_descricao);
        prazo = findViewById(R.id.input_prazo);
        radioPrioridade = findViewById(R.id.radioGroup);

        new DateInputMask(prazo);

        salvar = findViewById(R.id.button_save);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validateDesc = validateDescricao();
                boolean validatePrazo = validateData();
                if(validateDesc && validatePrazo) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setDescricao(descricao.getText().toString());
                    tarefa.setPrazo(prazo.getText().toString());
                    tarefa.setStatus(Status.FAZER.getId());

                    int selectedId = radioPrioridade.getCheckedRadioButtonId();
                    RadioButton radioPrioridade = findViewById(selectedId);

                    if (radioPrioridade.getText().toString() == v.getResources().getString(R.string.text_normal)) {
                        tarefa.setPrioridade(Prioridade.NORMAL.getId());
                    } else if (radioPrioridade.getText().toString() == v.getResources().getString(R.string.text_media)) {
                        tarefa.setPrioridade(Prioridade.MEDIA.getId());
                    } else if (radioPrioridade.getText().toString() == v.getResources().getString(R.string.text_alta)) {
                        tarefa.setPrioridade(Prioridade.ALTA.getId());
                    }

                    KanTask.getInstance().addTarefa(tarefa);
                    goHome();
                }
            }
        });

        cancelar = findViewById(R.id.button_cancel);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });


    }

    private void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }

    private boolean validateDescricao() {
        if(descricao.getText().toString().trim().isEmpty()) {
            descricao.setError(getResources().getString(R.string.descricao_error));
            return false;
        } else {
            return true;
        }
    }

    private boolean validateData() {
        if(prazo.getText().toString().trim().isEmpty()) {
            prazo.setError(getResources().getString(R.string.data_error));
            return false;
        } else {
            String s = prazo.getText().toString().replaceAll("[^\\d.]|\\.", "");
            if(s.length() < 8){
                prazo.setError(getResources().getString(R.string.data_error));
                return false;
            }
            return true;
        }
    }
}
