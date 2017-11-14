package com.anghelita.proiect_pso;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    String rer_url="http://188.27.106.116:8080";


    public String register(Context ctx, String ... params){

        try {
        URL url = new URL(rer_url+"/init.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

        String data =URLEncoder.encode("method", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8") + "&" +
                URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
                URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
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
        ((Activity) ctx).finish();
        return "Registration success!";



        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }

    }

    public String login(Context ctx,String...params){
        try {
            URL url = new URL(rer_url+"/init.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            InputStream inputStream = httpURLConnection.getInputStream();

            StringBuilder stringBuilder = new StringBuilder();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data =URLEncoder.encode("userType", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&"+
                    URLEncoder.encode("method", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");


            bufferedWriter.write(data);
            bufferedWriter.flush();

            String json_string;
            while ((json_string=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(json_string+"\n");
            }

            bufferedWriter.close();
            outputStream.close();
            inputStream.close();
            return stringBuilder.toString().trim();



        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }

    }

    public String Table(Context ctx,String...params) {
        try {
            URL url = new URL("http://188.27.106.116:8080/getJson.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String json_string;
            while ((json_string=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(json_string+"\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            return stringBuilder.toString().trim();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }
    }

}
