package com.anghelita.proiect_pso.Repository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Traian on 17-Nov-17.
 */

public class URLParameters {

    public static HttpURLConnection makeURLPostConnection(String Url) throws IOException {

        URL url = new URL(Url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        return httpURLConnection;

    }

}
