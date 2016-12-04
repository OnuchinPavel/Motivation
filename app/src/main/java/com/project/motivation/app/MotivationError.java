package com.project.motivation.app;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by onuchin on 03.12.2016.
 */

public class MotivationError extends Throwable {

    public  MotivationError(ResponseBody responseBody){
        super(getMessage(responseBody));
    }

    public  static String getMessage(ResponseBody responseBody){
        try {
            return new JSONObject(responseBody.string()).optString("message");
        }
        catch (JSONException| IOException e){
            e.printStackTrace();
        }
        return "Uknown exception";
    }
}
