package com.example.lock_password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button btnGerarSenha;
    private CheckBox chkNumeros;
    private CheckBox chkLetras;
    private CheckBox chkSimbolos;
    private String txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void GerarSenha(View view) {
        if(chkNumeros.isChecked() || chkLetras.isChecked() || chkSimbolos.isChecked()){
            String numeros = "1234567890";
            String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            String simbolos = "/*-+._!@#$%*()";

            String senha = numeros + letras + simbolos;

            txtSenha = senha;
        }
    }
}