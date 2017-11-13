package com.anghelita.proiect_pso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText FirstName;
    EditText LastName;
    EditText Password;
    EditText RePassword;
    EditText Mail;
    EditText Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirstName = findViewById(R.id.editText_First_Name);
        LastName = findViewById(R.id.editText_Last_Name);
        Password = findViewById(R.id.editText_Password);
        RePassword = findViewById(R.id.editText_re_Password);
        Mail = findViewById(R.id.editText_Mail);
        Phone = findViewById(R.id.editText_Phone);
    }

    public void Register(View view) {
        String method = "register";
        String firstname=FirstName.getText().toString();
        String lasttname=LastName.getText().toString();
        String password=Password.getText().toString();
        String repassword=RePassword.getText().toString();
        String mail=Mail.getText().toString();
        String phone=Phone.getText().toString();

        if(password.equals(repassword)) {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, firstname, lasttname, password, mail, phone);
        }
        else
        {
            Toast.makeText(this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
        }
    }
}
