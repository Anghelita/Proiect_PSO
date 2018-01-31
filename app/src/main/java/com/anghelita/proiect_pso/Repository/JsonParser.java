package com.anghelita.proiect_pso.Repository;

import com.anghelita.proiect_pso.Entity.Item;
import com.anghelita.proiect_pso.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1baN on 11/15/2017.
 */

public class JsonParser {

    static User user = new User();

    public void setUser(String string) throws JSONException {

        JSONObject jsonObject = new JSONObject(string);

        JSONArray jsonArray = jsonObject.getJSONArray("Server_response");
        int count = 0;
        while (count < jsonArray.length()) {
            JSONObject JO = jsonArray.getJSONObject(count);
            user.setFirstName(JO.getString("first_name"));
            user.setLastName(JO.getString("last_name"));
            user.setPassword(JO.getString("password"));
            user.setEmail(JO.getString("email"));
            user.setPhone(JO.getString("phone"));
            user.setGroup(JO.getString("group"));
            count++;
        }
    }

    public String getError(String string) throws JSONException {
        JSONObject jsonObject = new JSONObject(string);

        JSONArray jsonArray = jsonObject.getJSONArray("Server_Error");
        int count = 0;
        String msg = "";
        while (count < jsonArray.length()) {
            JSONObject JO = jsonArray.getJSONObject(count);
            msg = JO.getString("errorNumber") + " " + JO.getString("errorMessage");
            count++;
        }
        return msg;
    }

    public List<String> getGroups(String string) throws JSONException {

        List<String> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(string);

        JSONArray jsonArray = jsonObject.getJSONArray("Server_response");
        int count = 0;
        while (count < jsonArray.length()) {
            JSONObject JO = jsonArray.getJSONObject(count);
            list.add(JO.getString("group"));
            count++;
        }
        return list;
    }

    public List<Item> getList(String string) throws JSONException {
        JSONObject jsonObject = new JSONObject(string);
        JSONArray jsonArray = jsonObject.getJSONArray("Server_response");
        List<Item> list = new ArrayList<>();
        int count = 0;
        while (count < jsonArray.length()) {
            Item item = new Item();
            JSONObject JO = jsonArray.getJSONObject(count);
            item.setID(JO.getString("ID"));
            item.setName(JO.getString("name"));
            item.setDate(JO.getString("upload_date"));
            item.setProfessorFirstName(JO.getString("professor_first_name"));
            item.setProfessorLastName(JO.getString("professor_last_name"));
            item.setCourse(JO.getString("course"));
            list.add(item);
            count++;
        }
        return list;
    }
}
