package com.anghelita.proiect_pso.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

public class Register extends AppCompatActivity {

    EditText FirstName;
    EditText LastName;
    EditText Password;
    EditText RePassword;
    EditText Mail;
    EditText Phone;
    Spinner UserType;

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
        UserType = findViewById(R.id.spinner_User_Select);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.User_Select, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        UserType.setAdapter(adapter);
    }

    public void Register(View view) {//TODO Sa testezi toate kkturile ca sunt corecte

        user.setFirstName(FirstName.getText().toString());
        user.setLastName(LastName.getText().toString());
        user.setPassword(Password.getText().toString());
        user.setEmail(Mail.getText().toString());
        user.setPhone(Phone.getText().toString());
        User.setType(UserType.getSelectedItem().toString());

        BackgroundTask backgroundTask = new BackgroundTask(this);
        MyLambda login = () -> URL_Stuff.register(this);
        backgroundTask.execute(login);
    }
}
