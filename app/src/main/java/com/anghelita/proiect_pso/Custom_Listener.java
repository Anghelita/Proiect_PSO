package com.anghelita.proiect_pso;

import com.android.volley.Response;

/**
 * Created by Traian on 12-Nov-17.
 */

public class Custom_Listener implements Response.Listener<String> {
    private String RESP;

    @Override
    public void onResponse(String response) {
        RESP = response;
    }

    public String get_RESP() {
        return RESP;
    }

}
