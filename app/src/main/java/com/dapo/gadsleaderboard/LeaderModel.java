package com.dapo.gadsleaderboard;

public class LeaderModel {

    public static final int LEARNING_TYPE = 0;
    public static final int SKILL_IQ_TYPE = 1;

    private int type;
    private String name;
    private String stats;
    private String location;

    public LeaderModel(int type, String name, String stats, String location) {
        this.type = type;
        this.name = name;
        this.stats = stats;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
                ", stats='" + stats + '\'' +
                ", location='" + location + '\'' +
                ", type=" + type +
                '}';
    }
}
