package com.anghelita.proiect_pso.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.JsonParser;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

import org.json.JSONException;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Register extends AppCompatActivity {

    JsonParser jsonParser;
    EditText FirstName;
    EditText LastName;
    EditText Password;
    EditText RePassword;
    EditText Mail;
    EditText Phone;
    Spinner Group;

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
        Group = findViewById(R.id.spinner_Group);
        jsonParser = new JsonParser();

        BackgroundTask backgroundTask = new BackgroundTask(this);
        MyLambda getG = () -> URL_Stuff.getGroups(this);
        backgroundTask.execute(getG);

        try {
            List<String> list = jsonParser.getGroups(backgroundTask.get());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
            Group.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void Register(View view) throws ExecutionException, InterruptedException {//TODO: Sa testezi toate kkturile ca sunt corecte

        user.setFirstName(FirstName.getText().toString());
        user.setLastName(LastName.getText().toString());
        user.setPassword(Password.getText().toString());
        user.setEmail(Mail.getText().toString());
        user.setPhone(Phone.getText().toString());
        if (Group.getCount() > 0)
            user.setGroup(Group.getSelectedItem().toString());
        else
            user.setGroup("");

        BackgroundTask backgroundTask = new BackgroundTask(this);
        MyLambda login = () -> URL_Stuff.register(this);
        backgroundTask.execute(login);

        String s = backgroundTask.get();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
