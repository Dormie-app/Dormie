package com.example.dormieapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Register parse model(s)
       // ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("eq4oDUNXgYo2rYWjcUD3LPTNzc3WZUEupspDbLrT")
                .clientKey("1HZZZ4kTDOolgUH9VAhLpuojKtg5MLeMuhEGFejD")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
