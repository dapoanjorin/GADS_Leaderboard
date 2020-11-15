package com.dapo.gadsleaderboard.other;

import com.dapo.gadsleaderboard.other.LeaderModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TypeConverter {

    static Gson gson = new Gson();

    @androidx.room.TypeConverter
    public static List<LeaderModel> stringToList(String data) {


        if(data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<LeaderModel>>() {}.getType();

        return gson.fromJson(data, listType);

    }

    @androidx.room.TypeConverter
    public static String listToString(List<LeaderModel> list) {

        return gson.toJson(list);
    }
}
