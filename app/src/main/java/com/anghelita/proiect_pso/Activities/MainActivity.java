package com.anghelita.proiect_pso.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.anghelita.proiect_pso.Activities.List_Activity.ListActivity;
import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int x = 0;

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, x);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

    }

    public void Login(View view) throws ExecutionException, InterruptedException {


        BackgroundTask backgroundTask = new BackgroundTask(this);

        EditText EMAIL = findViewById(R.id.editText_username);
        EditText PASS = findViewById(R.id.editText_password);


        User user = new User();
        user.removeUser();

        user.setEmail(EMAIL.getText().toString());
        user.setPassword(PASS.getText().toString());

        MyLambda login = () -> URL_Stuff.login(this);
        backgroundTask.execute(login);

        String s = backgroundTask.get();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        if (s == "User Logged") {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }
    }

    public void Register(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

}
