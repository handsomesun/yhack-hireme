package com.example.junyang.yhack_hireme;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by Junyang on 11/1/14.
 */
@ParseClassName("JobSeekerInfo")
public class JobSeekerInfo extends ParseObject {
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

    public String getIndustry() {
        return getString("industry");
    }

    public void setIndustry(String value) {
        put("industry", value);
    }

    public int getExperience() {
        return getInt("experience");
    }

    public void setExperience(int value) {
        put("experience", value);
    }

    public void setLinkInLink(String value) {
        put("linkin_url", value);
    }

    public String getLinkInLink() {
        return getString("linkin_url");
    }


    public static ParseQuery<JobSeekerInfo> getQuery() {
        return ParseQuery.getQuery(JobSeekerInfo.class);
    }
}