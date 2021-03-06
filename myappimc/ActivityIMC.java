package com.suazona.teste.myappimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityIMC extends AppCompatActivity {

    private TextView recebeResultadoIMC;
    private Button buttonNovoIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        recebeResultadoIMC = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();

        String resultado = intent.getStringExtra("Calcula");

        recebeResultadoIMC.setText("Seu IMC: " + resultado);

        buttonNovoIMC = findViewById(R.id.buttonNovoIMC);
        buttonNovoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}