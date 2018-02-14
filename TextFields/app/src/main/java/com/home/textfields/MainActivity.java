package com.home.textfields;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editTextEmail;
    private AppCompatEditText editTextPassword;

    private TextInputLayout textLayoutEmail;
    private TextInputLayout textLayoutPassword;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.et_email);
        editTextPassword = findViewById(R.id.et_password);

        textLayoutEmail = findViewById(R.id.layout_et_email);

        textLayoutPassword = findViewById(R.id.layout_et_password);

        btnLogin = findViewById(R.id.btnLogin);


    }


    public void logar(View view){

        validar();

    }


    private void validar(){

        if(editTextEmail.getText().toString().isEmpty()){

            textLayoutEmail.setErrorEnabled(true);

            textLayoutEmail.setError("Erro de Email");
        }else{
            textLayoutEmail.setErrorEnabled(false);
        }

        if(editTextPassword.getText().toString().isEmpty()){

            textLayoutPassword.setErrorEnabled(true);

            textLayoutPassword.setError("Erro de senha");
        }else{
            textLayoutPassword.setErrorEnabled(false);
        }
    }
}
