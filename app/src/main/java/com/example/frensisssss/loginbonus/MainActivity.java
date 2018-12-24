package com.example.frensisssss.loginbonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA="com.example.frensisssss.loginbonus.User";
    UserFactory uf = UserFactory.getInstance();
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()) {
                    User utente = uf.getUtente(username.getText().toString(), password.getText().toString());

                    Intent showLog = new Intent(MainActivity.this,
                            ShowLog.class);

                    if(utente == null){
                        showLog.putExtra("esito", 0);
                    } else {
                        showLog.putExtra(EXTRA, utente);
                        showLog.putExtra("esito", 1);
                    }

                    startActivity(showLog);
                }
            }
        });
    }

    public boolean check(){
         if((username.getText() == null || username.getText().length() == 0) &&
        (password.getText() == null || password.getText().length() == 0)){
             username.setError("ERRORE! Inserire lo username.");
             password.setError("ERRORE! Inserire la password.");
        } else if(username.getText() == null || username.getText().length() == 0) {
            username.setError("ERRORE! Inserire lo username.");
        } else if(password.getText() == null || password.getText().length() == 0){
            password.setError("ERRORE! Inserire la password.");
        } else return true;

        return false;
    }
}
