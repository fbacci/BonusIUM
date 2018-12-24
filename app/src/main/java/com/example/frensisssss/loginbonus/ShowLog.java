package com.example.frensisssss.loginbonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ShowLog extends AppCompatActivity {
    User user;
    TextView username, welcomeOrNot, profile;
    ImageView img;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_log);

        Intent i = getIntent();
        int e = i.getExtras().getInt("esito");

        welcomeOrNot = findViewById(R.id.welcomeOrNot);
        username = findViewById(R.id.username);
        profile = findViewById(R.id.profile);
        img = findViewById(R.id.img);
        goBack = findViewById(R.id.back);

        profile.setVisibility(View.GONE);
        img.setVisibility(View.GONE);

        if(e == 1){
            Serializable u = i.getSerializableExtra(MainActivity.EXTRA);

            if (u instanceof User) user = (User) u;
            else user = new User();

            welcomeOrNot.setText("Benvenuto,");
            username.setText(user.getUsername());

            profile.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);

            goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else welcomeOrNot.setText("Accesso Negato!");


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMain = new Intent(ShowLog.this,
                        MainActivity.class);
                startActivity(goMain);
            }
        });
    }
}
