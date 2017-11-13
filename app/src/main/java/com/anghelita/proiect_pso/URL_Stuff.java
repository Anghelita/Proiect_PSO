package com.anghelita.proiect_pso;

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
 * Created by Traian on 13-Nov-17.
 */

public class URL_Stuff {

    String rer_url="http://188.27.106.116:8080/register.php";


    public String register(String ... params){

        try {
        URL url = new URL(rer_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

        String data = URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
                URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8") + "&" +
                URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8") + "&" +
                URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(params[5] , "UTF-8") + "&" +
                URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode("0010", "UTF-8");
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();
        os.close();
        InputStream IS = httpURLConnection.getInputStream();
        IS.close();
        return "Registration success";

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }

    }

}
