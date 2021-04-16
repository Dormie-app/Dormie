package com.example.dormieapp;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("UserAttributes")
public class UserAttributes extends ParseObject {
public static final String KEY_UNI = "univ";
public static final String KEY_HOUSING = "housingPref";
    public static final String KEY_PIC = "profilePic";
    public static final String KEY_NAME = "fullName";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_MAJOR = "major";
    public String getKeyUni() {
        return getString(KEY_UNI);
    }

    public String getKeyHousing() {
        return getString(KEY_HOUSING);
    }

    public ParseFile getKeyPic() {
        return getParseFile(KEY_PIC);
    }

    public String getKeyName() {
        return getString(KEY_NAME);
    }

    public String getKeyDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public String getKeyMajor() {
        return getString(KEY_MAJOR);
    }


}
