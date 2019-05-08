
package com.example.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.calculadoraimc.MESSAGE";
    public final static String EXTRA_MESSAGE_VALOR = "com.example.calculadoraimc.VALUE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



       public void Calcular(View v)
       {
           ToggleButton swSexo =  findViewById(R.id.swtSexo);
           EditText txtPeso = findViewById((R.id.txtPeso));
           EditText txtAlt  = findViewById(R.id.txtAltura);
           String msgIMC;
           double peso = Double.parseDouble(txtPeso.getText().toString());
           double alt = Double.parseDouble(txtAlt.getText().toString());
           double imc = peso / pow(alt,2);
           if(swSexo.isChecked())
           {
               if(imc<19)
               {
                   msgIMC = "Abaixo do Normal";
               }
               else if ( imc<24)
               {
                   msgIMC = "Normal";
               }
               else if ( imc<29)
               {
                   msgIMC = "Obesidade Leve";
               }
               else if ( imc<39)
               {
                   msgIMC = "Obesidade Moderada";
               }
               else
               {
                   msgIMC = "Obesidade Mórbida";
               }

           }
           else
           {
               if(imc<20)
               {
                   msgIMC = "Abaixo do Normal";
               }
               else if ( imc<25)
               {
                   msgIMC = "Normal";
               }
               else if (imc<30)
               {
                   msgIMC = "Obesidade Leve";
               }
               else if (imc<40)
               {
                   msgIMC = "Obesidade Moderada";
               }
               else
               {
                   msgIMC = "Obesidade Mórbida";
               }
           }

           Intent intent = new Intent(this, ResultadoActivity.class);
           String valor = String.valueOf(imc);
           intent.putExtra(EXTRA_MESSAGE, msgIMC);
           intent.putExtra(EXTRA_MESSAGE_VALOR, valor);
           startActivity(intent);
       }
    }
