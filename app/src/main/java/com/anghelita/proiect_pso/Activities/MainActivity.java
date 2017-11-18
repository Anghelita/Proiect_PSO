package com.anghelita.proiect_pso.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.URLParameters;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Login(View view) {

        TextView log = findViewById(R.id.Log);

        BackgroundTask backgroundTask = new BackgroundTask(this, log);

        EditText EMAIL = findViewById(R.id.editText_username);

        User user = new User();

        user.setEmail(EMAIL.getText().toString());


        backgroundTask.execute();
    }

    public void Register(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }



}
