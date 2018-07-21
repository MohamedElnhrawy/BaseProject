package com.example.mohamedelnhrawy.baseproject.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import static android.content.Context.MODE_PRIVATE;


public class SharedPref {

    private static Context context;

    public SharedPref(Context context){
        this.context = context;
    }

    //////////////////////// language /////////////////////
    public static void setLanguage( String lang) {
        SharedPreferences sharedPref = context.getSharedPreferences("Language", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("Language_Key", lang);
        editor.apply();
    }

    public  static String getLanguage()
    {
        SharedPreferences sharedPref = context.getSharedPreferences("Language", MODE_PRIVATE);
        return sharedPref.getString("Language_Key",null);
    }


    ///////////////////////////// user_id ////////////////////////
    public static void SetToken( String user_token) {
        SharedPreferences sharedPref = context.getSharedPreferences("User_Token", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("User_Token_Key", "bearer "+user_token);
        editor.apply();
    }

    public  static String getToken()
    {
        SharedPreferences sharedPref = context.getSharedPreferences("User_Token", MODE_PRIVATE);
        return sharedPref.getString("User_Token_Key",null);
    }



//    public static void setTokenValidation( Boolean isValidToken) {
//        SharedPreferences.Editor editor =context.getSharedPreferences(Constant.MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
//        editor.putBoolean("isValidToken",isValidToken);
//        editor.commit();
//    }
//
//    public  static Boolean getTokenValidation()
//    {
//        SharedPreferences prefs = context.getSharedPreferences(Constant.MY_PREFS_NAME, Context.MODE_PRIVATE);
//        Boolean isValidToken = prefs.getBoolean("isValidToken",false);
//        return  isValidToken;
//
//    }

    ///////////////////////////// user_Phone Number ////////////////////////
    public static void setUserPhoneNumber( String userPhoneNumber) {
        SharedPreferences sharedPref = context.getSharedPreferences("User_PhoneNumber", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("userPhoneNumber", userPhoneNumber);
        editor.apply();
    }

    public  static String getUserPhoneNumber()
    {
        SharedPreferences sharedPref = context.getSharedPreferences("User_PhoneNumber", MODE_PRIVATE);
        return sharedPref.getString("userPhoneNumber","");
    }

    /////////////////////////user is login//////////////////
    public static void setUserLogin(Boolean islogin) {
        SharedPreferences sharedPref = context.getSharedPreferences("userLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putBoolean("userLogin", islogin);
        editor.apply();
    }

    public  static Boolean getUserLogin()
    {
        SharedPreferences sharedPref = context.getSharedPreferences("userLogin", MODE_PRIVATE);
        return sharedPref.getBoolean("userLogin",false);
    }
    public static void setPhotoURI(String photoURI) {
        SharedPreferences sharedPref = context.getSharedPreferences("photoURI", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("photoURI", photoURI);
        editor.apply();
    }

    public  static String getPhotoURI()
    {
        SharedPreferences sharedPref = context.getSharedPreferences("photoURI", MODE_PRIVATE);
        return sharedPref.getString("photoURI","");
    }
    ////////////////////////////////// orderby //////////////////
    public static void SetOrderBy( String orderby) {
        SharedPreferences sharedPref = context.getSharedPreferences("OrderBy", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("OrderBy_Key", orderby);
        editor.apply();
    }

    public  static String getOrderBy()
    {

        SharedPreferences sharedPref = context.getSharedPreferences("OrderBy", MODE_PRIVATE);
        return sharedPref.getString("OrderBy_Key",null);
    }

    /// one signal player id

    public static void SavePLayerId(Context context, String playerid) {
        SharedPreferences sharedPref = context.getSharedPreferences("SAVE_PLAYERID", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("PLAYERID_KEY", playerid);
        editor.commit();
    }


    public  static String getPlayerId(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences("SAVE_PLAYERID", MODE_PRIVATE);
        return sharedPref.getString("PLAYERID_KEY",null);
    }

    //----------------------case User Data-------------------------
//    public static void saveUser( User user) {
//        SharedPreferences sharedPref = context.getSharedPreferences("saveUser", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.clear();
//        Gson gson = new Gson();
//        String json = gson.toJson(user);
//        editor.putString("saveUser_KEY", json);
//        editor.commit();
//    }
//
//    public static User getUser()
//    {
//        User address_object;
//        SharedPreferences sharedPref = context.getSharedPreferences("saveUser", MODE_PRIVATE);
//        Gson gsonn=new Gson();
//        String jsonm= sharedPref.getString("saveUser_KEY", null);
//        java.lang.reflect.Type type=new TypeToken<User>(){}.getType();
//        address_object=gsonn.fromJson(jsonm, (java.lang.reflect.Type) type);
//        return address_object;
//
//    }

}
