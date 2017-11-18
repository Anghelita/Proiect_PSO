package com.anghelita.proiect_pso.Repository;

import com.anghelita.proiect_pso.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by c1baN on 11/15/2017.
 */

public class JsonParser {

    static User user = new User();

    public void setUser(String string) throws JSONException {

        JSONObject jsonObject = new JSONObject(string);

        JSONArray jsonArray = jsonObject.getJSONArray("Server_response");
        int count =0;
        while(count < jsonArray.length()) {
            JSONObject JO = jsonArray.getJSONObject(count);
            user.setFirstName(JO.getString("first_name"));
            user.setLastName(JO.getString("last_name"));
            user.setPassword(JO.getString("password"));
            user.setEmail(JO.getString("email"));
            user.setPhone(JO.getString("phone"));
            user.setCode(Integer.parseInt(JO.getString("code")));
            count ++;
        }

    }

}
