package com.anghelita.proiect_pso.Repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.anghelita.proiect_pso.Entity.User;

/**
 * Created by Traian on 12-Nov-17.
 */

public class BackgroundTask extends AsyncTask<MyLambda,Void,Void> {

    @SuppressLint("StaticFieldLeak")
    private Context ctx;
    @SuppressLint("StaticFieldLeak")
    private TextView log;

    public BackgroundTask(Context ctx, TextView log){
        this.ctx = ctx;
        this.log = log;
    }

    @Override
    protected Void doInBackground(MyLambda... myLambdas) {
        myLambdas[0].execute();
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(Void aVoid) {
        log.setText("User Logged: "+User.getFirstName()+" "+User.getLastName()+User.getEmail()+"\n");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
