package br.edu.unidavi.kantask.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    private final String PREF_NAME = "session";
    private final String DEFAULT = "no data";
    private final String USERNAME = "username";
    private final String PHOTO_URL = "photoUrl";

    Context context;

    public Session(Context ctx){
        context = ctx;
    }

    private void setInfoStringInSession(String key, String value){
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private String getInfoStringInSession(String info){
        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPref.getString(info, DEFAULT);
    }

    public void setUserNameInSession(String user){
        setInfoStringInSession(USERNAME, user);
    }

    public String getUserNameInSession(){
        return getInfoStringInSession(USERNAME);
    }

    public void setPhotoUrlInSession(String photo){
        setInfoStringInSession(PHOTO_URL, photo);
    }

    public String getPhotoUrlInSession(){
        return getInfoStringInSession(PHOTO_URL);
    }
}