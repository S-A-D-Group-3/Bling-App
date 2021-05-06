package com.systemdict32.blingapp.Fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParserPlace {
    private HashMap<String, String> parseJsonObject(JSONObject object) {
        HashMap<String, String> datalist = new HashMap<>();

        try{
            String name = object.getString("name");
            String address = object.getString("vicinity");
            String phone_num = object.getString("formatted_phone_number");
            String cellphone_num = object.getString("international_phone_number");

            datalist.put("name", name);
            datalist.put("address", address);
            datalist.put("phone_num", phone_num);
            datalist.put("cellphone_num", cellphone_num);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return datalist;
    }

    public List<HashMap<String, String>> parseResult(JSONObject jsonObject) {
        HashMap<String, String> object = new HashMap<>();


        try {
            object = parseJsonObject(jsonObject.getJSONObject("result"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        List<HashMap<String, String>> listObject = new ArrayList<>();

        listObject.add(object);

        return listObject;
    }
}
