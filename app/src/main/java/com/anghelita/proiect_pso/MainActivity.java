package com.anghelita.proiect_pso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Login(View view) {

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("Login");
    }

    public void Register(View view) {

        Intent intent = new Intent(this, Register.class);

        startActivity(intent);

    }



}
