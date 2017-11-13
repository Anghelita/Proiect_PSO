package com.anghelita.proiect_pso;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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
        String firstname=params[1];
        String lasttname=params[2];
        String password=params[3];
        String mail=params[4];
        String phone=params[5];


        if(method.equals("register")) {
            url.register(params);

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
            //((Activity) ctx).finish();
        }
        else
            Toast.makeText(ctx,"Something went wrong!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
