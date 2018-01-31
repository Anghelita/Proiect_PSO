package com.anghelita.proiect_pso.Repository;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Traian on 12-Nov-17.
 */

public class BackgroundTask extends AsyncTask<MyLambda, Void, String> {

    public String response;
    private Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(MyLambda... myLambdas) {
        response = myLambdas[0].execute();
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
