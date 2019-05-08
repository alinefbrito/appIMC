package com.example.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView resultado = findViewById(R.id.txtResposta);
        if (extras != null) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            String valor = extras.getString(MainActivity.EXTRA_MESSAGE_VALOR);

            String txt = String.format("Seu IMC é %s esse valor indica %s ",valor,msg);
            resultado.setText(txt );
        }



    }
}
