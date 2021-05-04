package com.systemdict32.blingapp.Fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParserLGU {
    private HashMap<String, String> parseJsonObject(JSONObject object) {
        HashMap<String, String> datalist = new HashMap<>();

        try{
            String address = object.getString("formatted_address");

            datalist.put("address", address);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return datalist;
    }

    private List<HashMap<String, String>> parseJsonArray(JSONArray jsonArray) {
        List<HashMap<String, String>> datalist = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++){
            try {
                HashMap<String, String> data = parseJsonObject((JSONObject) jsonArray.get(i));

                datalist.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return datalist;
    }

    public List<HashMap<String, String>> parseResult(JSONObject jsonObject) {
        JSONArray jsonArray = null;

        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parseJsonArray(jsonArray);
    }
}
