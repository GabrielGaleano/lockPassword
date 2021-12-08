package com.example.lock_password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnGerarSenha;
    private CheckBox chkNumeros;
    private CheckBox chkLetras;
    private CheckBox chkSimbolos;
    private TextView txtSenha;
    private Spinner spnLimiteCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSenha = (TextView) findViewById(R.id.senha);
        chkLetras = findViewById(R.id.letras);
        chkNumeros = findViewById(R.id.numeros);
        chkSimbolos = findViewById(R.id.simbolos);

        spnLimiteCar = (Spinner) findViewById(R.id.limitesCaracter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.limites_caracter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLimiteCar.setAdapter(adapter);

    }

    public void GerarSenha(View view) {
        String letras = "";
        String numeros = "";
        String simbolos = "";
        String all = "";
        String senha = "";
        int limit = 0;

        if(chkLetras.isChecked()){
            letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            limit += 52;
        }

        if(chkNumeros.isChecked()){
            numeros = "1234567890";
            limit += 10;
        }

        if (chkSimbolos.isChecked()){
            simbolos = "/*-+._!@#$%()";
            limit += 13;
        }

        all = numeros + letras + simbolos;

        if(all == ""){
            senha = "Por favor, selecione pelo menos uma opção a cima.";
        }else{
            //int limitCar = (int) spnLimiteCar.setAdapter();
            for(int i = 0; i < 25; i++) {
                int x = (int) (Math.random() * limit);
                char result = all.charAt(x);
                String carac = Character.toString(result);
                senha += carac;
            }
        }
        txtSenha.setText(senha);
    }
}