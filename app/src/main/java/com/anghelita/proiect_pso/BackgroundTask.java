package com.anghelita.proiect_pso;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Traian on 12-Nov-17.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    TextView log;

    BackgroundTask(Context ctx, TextView log){
        this.ctx = ctx;
        this.log = log;
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];

        if(method.equals("RegisterStudent")) {
            return URL_Stuff.register(ctx,params);
        }

        if(method.equals("Login")) {
            return URL_Stuff.login(ctx,params);
        }

        if(method.equals(("getStudents")))
        {
            return URL_Stuff.Table(ctx,params);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        if(result != null) {
            log.setText(result);
        }
        else
            Toast.makeText(ctx,"Something went wrong!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
