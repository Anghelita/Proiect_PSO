package com.anghelita.proiect_pso;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Traian on 12-Nov-17.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    URL_Stuff url;

    BackgroundTask(Context ctx){
        this.ctx = ctx;
        url = new URL_Stuff();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];

        if(method.equals("RegisterStudent")) {
            return url.register(ctx,params);
        }

        if(method.equals(("getStudents")))
        {
            return url.Table(ctx,params);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String renault) {
        if(renault != null) {
            Toast.makeText(ctx, renault, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(ctx,"Something went wrong!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
