package com.runshaw.tutorial.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sharath on 2020/07/16
 **/
public class SharedPref {

    private final SharedPreferences pref;

    private final SharedPreferences.Editor editor;

    private static final String PREF_NAME = "LoginDetails";

    private static final String USER_NAME = "userName";
    private static final String USER_ID = "userID";
    private static final String USER_PASSWORD = "userPassword";


    public SharedPref(Context context){
        int PRIVATE_MODE = 0;

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUserName(String userName){
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    public String getUserName(){
        return pref.getString(USER_NAME, "No user Present");
    }

    public void setUserId(String userId){
        editor.putString(USER_ID, userId);
        editor.commit();
    }

    public String getUserId(){
        return pref.getString(USER_ID, "No user ID");
    }

    public void setUserPassword(String password){
        editor.putString(USER_PASSWORD, password);
        editor.commit();
    }

    public String getUserPassword(){
        return pref.getString(USER_PASSWORD, "");
    }

}
