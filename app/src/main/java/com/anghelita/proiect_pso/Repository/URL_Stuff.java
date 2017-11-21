package com.anghelita.proiect_pso.Repository;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.anghelita.proiect_pso.Entity.User;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;


/**
 * Created by Traian on 13-Nov-17.
 */

public class URL_Stuff {

    private static String rer_url="http://188.27.106.116:8080";

    private static JsonParser jsonParser = new JsonParser();


    public static String register(Context ctx){

        try {

            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url+"/RegisterStudent.php");
            String data =   URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(User.getFirstName(), "UTF-8") + "&" +
                            URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(User.getLastName(), "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(User.getPassword(), "UTF-8") + "&" +
                            URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(User.getEmail(), "UTF-8") + "&" +
                            URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(User.getPhone(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            String string = Packet.Receive(httpURLConnection);


// Asta e doar asa de concept trebuie dezvoltat
            if(!string.equals("Error")) {
                jsonParser.setUser(string);
                ((Activity) ctx).finish();
                Toast.makeText(ctx, "User registered successfully", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(ctx, "User not registered", Toast.LENGTH_SHORT).show();
            //TODO Poate faci si tuc kkt cu dala de se inroseste la ce nu e ok aka sa modifici si in php sa returneze un mesaj de error cu ceva kkt prin el

        return null;



        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String login(Context ctx) {
        try {

            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url+"/Login.php");
            String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(User.getEmail(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            String string = Packet.Receive(httpURLConnection);

            jsonParser.setUser(string);

            return "User Logged";

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

}
