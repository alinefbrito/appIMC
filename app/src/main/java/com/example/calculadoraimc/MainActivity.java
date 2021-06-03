package com.example.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.calculadoraimc.MESSAGE";
    public final static String EXTRA_MESSAGE_VALOR = "com.example.calculadoraimc.VALUE";
    double peso, alt, imc;
    ToggleButton swSexo;
    EditText txtPeso, txtAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swSexo = findViewById(R.id.swtSexo);
        txtPeso = findViewById((R.id.txtPeso));
        txtAlt = findViewById(R.id.txtAltura);
    }


    public void Calcular(View v) {
        String msgIMC;
        String p = txtPeso.getText().toString();
        String a = txtAlt.getText().toString();
        if (strInvalida(p) || strInvalida(a)) {
            //se os valores digitados não forem válidos mostra uma Toast Notification com o erro
            //o metodo getString recupera e devolve um texto definido no arquivo de strings atraves da propriedade Name

            Toast toast = Toast.makeText(this, getString(R.string.msgVazio), Toast.LENGTH_LONG);
            toast.show();
        } else {
            try {
                peso = Double.parseDouble(p);
                alt = Double.parseDouble(a);
                imc = peso / pow(alt, 2);
                if (swSexo.isChecked()) {
                    if (imc < 19) {
                        msgIMC = getString(R.string.ab_normal);
                    } else if (imc < 24) {
                        msgIMC = getString(R.string.normal);
                    } else if (imc < 29) {
                        msgIMC = getString(R.string.o_leve);
                    } else if (imc < 39) {
                        msgIMC = getString(R.string.o_moder);
                    } else {
                        msgIMC = getString(R.string.o_morb);
                    }

                } else {
                    if (imc < 20) {
                        msgIMC = getString(R.string.ab_normal);
                    } else if (imc < 25) {
                        msgIMC = getString(R.string.normal);
                    } else if (imc < 30) {
                        msgIMC = getString(R.string.o_leve);
                    } else if (imc < 40) {
                        msgIMC = getString(R.string.o_moder);
                    } else {
                        msgIMC = getString(R.string.o_morb);
                    }
                }

                Intent intent = new Intent(this, ResultadoActivity.class);
                //converte em String
                String valor = String.valueOf(imc);
                intent.putExtra(EXTRA_MESSAGE, msgIMC);
                intent.putExtra(EXTRA_MESSAGE_VALOR, valor);
                startActivity(intent);
            } catch (Exception ex) {
                Toast toast = Toast.makeText(this, getString(R.string.msgErro), Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public void limpar(View v) {
        txtAlt.setText("");
        txtPeso.setText("");
    }

    public boolean strInvalida(String s) {
        return s == null || s.isEmpty() || s.trim().isEmpty();

    }
}
