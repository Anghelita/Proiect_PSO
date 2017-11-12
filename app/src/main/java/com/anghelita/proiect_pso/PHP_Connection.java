package com.anghelita.proiect_pso;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Traian on 12-Nov-17.
 */

public class PHP_Connection {

    private static String url ="http://188.27.106.116:8080/api.php";
    private static Context context;

    private RequestQueue queue;
    private Custom_Listener Resp = new Custom_Listener();
    private Response.ErrorListener Error;


    PHP_Connection(Context con){

        context = con;
        queue = Volley.newRequestQueue(context);

        Error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //what to do if something went wrong

            }
        };
    }

    private String get_URL_response(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, Resp, Error);

        queue.add(stringRequest); //execution of the request

        return Resp.get_RESP();

    }

    public void Log_in(String name, String password , TextView mText){

       mText.setText(get_URL_response(url+"/documents"));

    }


}
