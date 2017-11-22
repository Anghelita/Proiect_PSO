package com.anghelita.proiect_pso.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Login(View view) {


        BackgroundTask backgroundTask = new BackgroundTask(this);

        EditText EMAIL = findViewById(R.id.editText_username);
        EditText PASS = findViewById(R.id.editText_password);


        User user = new User();
        user.removeUser();

        user.setEmail(EMAIL.getText().toString());
        user.setPassword(PASS.getText().toString());
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        MyLambda login = () -> URL_Stuff.login(this);
        backgroundTask.execute(login);

    }

    public void Register(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }



}
