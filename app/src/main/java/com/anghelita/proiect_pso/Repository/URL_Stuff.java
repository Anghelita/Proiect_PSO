package com.anghelita.proiect_pso.Repository;

import android.app.Activity;
import android.content.Context;

import com.anghelita.proiect_pso.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Traian on 13-Nov-17.
 */

public class URL_Stuff {

    private static String rer_url="http://188.27.106.116:8080";

    private static JsonParser jsonParser = new JsonParser();


    private static String encodeParameters(List<URLParameters>[] params){

        String data;

//        for (String param:params
//             ) {
//           // data += URLEncoder.encode(pa, "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8") + "&"
//
//        }


        return null;
    }



    public static String register(Context ctx, List<URLParameters>[] params){

        try {
        URL url = new URL(rer_url+"/init.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

//        String data =URLEncoder.encode("method", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8") + "&" +
//                URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8") + "&" +
//                URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8") + "&" +
//                URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8") + "&" +
//                URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8") + "&" +
//                URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(params[5] , "UTF-8") + "&" +
//                URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode("0010", "UTF-8");

//        Packet.Send(httpURLConnection, data);
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

    public static String login(Context ctx) {
        try {

            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url+"/Login.php");
            String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(User.getEmail(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            String string = Packet.Receive(httpURLConnection);

            jsonParser.setUser(string);

            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String Table(Context ctx) {
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
