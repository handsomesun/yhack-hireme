package com.example.junyang.yhack_hireme;
import android.app.Application;
import com.parse.Parse;

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "A3EYRpl1cwSdMy5u5vUX196KW28QibBASJSJWBWD", "MDccMwvIxHjcdcpBx76JC5v74iSQRDmZPudf2Moy");
    }
}
