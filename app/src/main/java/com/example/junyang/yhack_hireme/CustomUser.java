package com.example.junyang.yhack_hireme;

import com.parse.ParseClassName;
import com.parse.ParseUser;

/**
 * Created by Junyang on 11/1/14.
 */
@ParseClassName("CustomUser")
public class CustomUser extends ParseUser {
    void setIsRecruiter(String value) {
        put("isRecruiter", value);
    }

    String getIsRecruiter(){
        return getString("isRecruiter");
    }
}
