package com.anghelita.proiect_pso.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Traian on 12-Nov-17.
 */

public class BackgroundTask extends AsyncTask<MyLambda,Void,Void> {

    private Context ctx;
    private String response;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected Void doInBackground(MyLambda... myLambdas) {
        response = myLambdas[0].execute();
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(ctx, response, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
