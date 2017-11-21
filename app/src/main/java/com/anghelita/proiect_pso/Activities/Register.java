package com.anghelita.proiect_pso.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

public class Register extends AppCompatActivity {

    EditText FirstName;
    EditText LastName;
    EditText Password;
    EditText RePassword;
    EditText Mail;
    EditText Phone;

    User user = new User();

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

    public void Register(View view) {//TODO Sa testezi toate kkturile ca sunt corecte

        user.setFirstName(FirstName.getText().toString());
        user.setLastName(LastName.getText().toString());
        user.setPassword(Password.getText().toString());
        user.setPassword(Mail.getText().toString());
        user.setPhone(Phone.getText().toString());


        BackgroundTask backgroundTask = new BackgroundTask(this, null);
        MyLambda login = () -> URL_Stuff.login(this);
        backgroundTask.execute(login);
    }
}
