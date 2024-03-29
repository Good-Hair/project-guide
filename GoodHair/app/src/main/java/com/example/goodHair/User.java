package com.example.goodHair;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseObject{

    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    //public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PHONENUM = "phoneNum";
    //public static final String KEY_LOCATION = "location";
    public static final String KEY_ISSTYLIST = "isStylist";
    public static final String KEY_IMAGE ="image";

    public User() {super();}

    public String getName(){ return getString(KEY_NAME); }
    public void setName(String name){ put(KEY_NAME, name); }

    public String getEmail(){ return getString(KEY_EMAIL); }
    public void setEmail(String email){ put(KEY_EMAIL, email); }

    public ParseUser getUser(){ return getParseUser(KEY_USERNAME); }
    public void setUser(ParseUser user){ put(KEY_USERNAME, user); }

    public String getPhonenum(){ return getString(KEY_PHONENUM); }
    public void setPhonenum(String phonenum){ put(KEY_PHONENUM, phonenum); }

    public boolean getIsStylist(){ return getBoolean(KEY_ISSTYLIST); }
    public void setIsStylist(boolean isStylist){ put(KEY_ISSTYLIST, isStylist); }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile image){
        put(KEY_IMAGE, image);
    }

    }