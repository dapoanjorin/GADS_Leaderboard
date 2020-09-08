package com.dapo.gadsleaderboard;

import com.google.gson.annotations.SerializedName;

public class LeaderModel {

    public static final int LEARNING_TYPE = 0;
    public static final int SKILL_IQ_TYPE = 1;

    private int type;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "hours", alternate = "score")
    private int hours;

    @SerializedName(value ="country")
    private String country;

    public LeaderModel(int type, String name, int stats, String location) {
        this.type = type;
        this.name = name;
        this.hours = stats;
        this.country = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LeaderModel{" +
                "name='" + name + '\'' +
                ", stats='" + hours + '\'' +
                ", location='" + country + '\'' +
                ", type=" + type +
                '}';
    }
}
