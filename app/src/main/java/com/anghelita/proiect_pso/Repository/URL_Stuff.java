package com.anghelita.proiect_pso.Repository;

import android.app.Activity;
import android.content.Context;

import com.anghelita.proiect_pso.Entity.Item;
import com.anghelita.proiect_pso.Entity.User;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Traian on 13-Nov-17.
 */

public class URL_Stuff {

    public static List<Item> list;
    public static String download;
    private static String rer_url = "http://188.25.128.117:8080";
    private static JsonParser jsonParser = new JsonParser();

    public static String register(Context ctx) {

        String string = "";

        try {
            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url + "/RegisterStudent.php");
            String data = URLEncoder.encode("firstName", "UTF-8") + "=" + URLEncoder.encode(User.getFirstName(), "UTF-8") + "&" +
                    URLEncoder.encode("lastName", "UTF-8") + "=" + URLEncoder.encode(User.getLastName(), "UTF-8") + "&" +
                    URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(User.getPassword(), "UTF-8") + "&" +
                    URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(User.getEmail(), "UTF-8") + "&" +
                    URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(User.getPhone(), "UTF-8") + "&" +
                    URLEncoder.encode("group", "UTF-8") + "=" + URLEncoder.encode(User.getGroup(), "UTF-8") + "&" +
                    URLEncoder.encode("type", "UTF-8") + "=" + "student";

            Packet.Send(httpURLConnection, data);
            string = Packet.Receive(httpURLConnection);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        try {
            return jsonParser.getError(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonParser.setUser(string);
        } catch (JSONException e) {
            return "The server does w3erd stuff!";
        }

        ((Activity) ctx).finish();
        return "User Registered";
    }

    public static String getGroups(Context ctx) {

        try {

            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url + "/Groups.php");
            String data = "";

            Packet.Send(httpURLConnection, data);
            String string = Packet.Receive(httpURLConnection);

            return string;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String login(Context ctx) {

        String string;
        try {
            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url + "/Login.php");
            String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(User.getEmail(), "UTF-8") + "&" +
                    URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(User.getPassword(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            string = Packet.Receive(httpURLConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        try {
            return jsonParser.getError(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonParser.setUser(string);
        } catch (JSONException e) {
            e.printStackTrace();
            return "The server does w3erd stuff!";
        }
        return "User Logged";
    }

    public static String getList(Context ctx) {
        list = new ArrayList<>();
        String string;
        try {
            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url + "/DocList.php");
            String data = URLEncoder.encode("group", "UTF-8") + "=" + URLEncoder.encode(User.getGroup(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            string = Packet.Receive(httpURLConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        try {
            return jsonParser.getError(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            list = jsonParser.getList(string);
        } catch (JSONException e) {
            e.printStackTrace();
            return "The server does w3erd stuff!";
        }
        return "List Downloaded";
    }

    public static String download(Context ctx) {
        String string;
        try {
            HttpURLConnection httpURLConnection = URLParameters.makeURLPostConnection(rer_url + "/Download.php");
            String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(User.getIDDownload(), "UTF-8");

            Packet.Send(httpURLConnection, data);
            string = Packet.Receive(httpURLConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        try {
            return jsonParser.getError(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            download = jsonParser.getDownload(string);
        } catch (JSONException e) {
            e.printStackTrace();
            return "The server does w3erd stuff!";
        }
        return "Download complete";
    }

}
