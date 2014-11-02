package com.example.junyang.yhack_hireme;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by Junyang on 11/1/14.
 */
@ParseClassName("RecruiterInfo")
public class RecruiterInfo extends ParseObject {
    public String getName() {
        return getString("name");
    }

    public void setName(String value) {
        put("name", value);
    }

    public String getUsername() {
        return getString("username");
    }

    public void setUsername(String value) {
        put("username", value);
    }

    public String getCompany() {
        return getString("company");
    }

    public void setCompany(String value) {
        put("company", value);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String value) {
        put("description", value);
    }

    public static ParseQuery<RecruiterInfo> getQuery() {
        return ParseQuery.getQuery(RecruiterInfo.class);
    }
}
