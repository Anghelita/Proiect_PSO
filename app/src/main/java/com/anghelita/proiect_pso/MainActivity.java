package com.anghelita.proiect_pso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Login(View view) {

        TextView log = findViewById(R.id.Log);

        BackgroundTask backgroundTask = new BackgroundTask(this, log);
        backgroundTask.execute("Login");
    }

    public void Register(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }



}
