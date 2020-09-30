package com.suazona.teste.myappimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private Button buttonCalcularIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalcularIMC = findViewById(R.id.buttonCalcular);
        peso = findViewById(R.id.editTextPeso);
        altura = findViewById(R.id.editTextAltura);



        buttonCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (altura.getText().toString().isEmpty()) {
                    altura.setError("Informe a altura!");
                    return;
                }
                if(peso.getText().toString().isEmpty()){
                    peso.setError("Informe o peso!");
                    return;
                }

                final double pesoVar = Double.parseDouble(peso.getText().toString());
                final double alturaVar = Double.parseDouble(altura.getText().toString());

                if(alturaVar == 0 ){
                    altura.setError("Altura não pode ser 0!");
                    return;
                }

                double calculoIMC = pesoVar/(alturaVar * alturaVar);
                
                if(calculoIMC < 18.5){
                    Toast.makeText(getApplicationContext(),"Magreza",Toast.LENGTH_LONG).show();
                }

                else if(calculoIMC >= 18.5 && calculoIMC < 24.9){
                    Toast.makeText(getApplicationContext(),"Normal",Toast.LENGTH_LONG).show();
                }
                else if(calculoIMC >= 24.5 && calculoIMC < 29.9){
                    Toast.makeText(getApplicationContext(),"Sobrepeso Grau I",Toast.LENGTH_LONG).show();
                }
                else if(calculoIMC >= 30.0 && calculoIMC < 39.9){
                    Toast.makeText(getApplicationContext(),"Obesidade Grau II",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Obesidade Grau III\nMórbida",Toast.LENGTH_LONG).show();
                }

//                String resultado = Double.toString(calculoIMC);
                String resultado = new DecimalFormat("#,##0.00").format(calculoIMC);
                Intent intent = new Intent(getApplicationContext(),ActivityIMC.class);
                intent.putExtra("Calcula",resultado);
                startActivity(intent);

            }
        });

    }
}
