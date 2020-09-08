package com.dapo.gadsleaderboard;

import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataManager {

    private static final String TAG = "Data Manager";

    private static DataManager dataManagerInstance = null;

    private  List<LeaderModel> mLearningHoursLeaderBoard = new ArrayList<>();
    private  List<LeaderModel> mSkillsIQLeaderBoard = new ArrayList<>();

    public static DataManager getInstance() {
        if (dataManagerInstance == null) {
            dataManagerInstance = new DataManager();
        }
        return dataManagerInstance;
    }


    public void setLearningHoursLeaderBoard(List<LeaderModel> learningHoursLeaderBoard) {
        Log.d(TAG, "onResponse: setting learning hours");
        mLearningHoursLeaderBoard = learningHoursLeaderBoard;
    }

    public void setSkillsIQLeaderBoard(List<LeaderModel> skillsIQLeaderBoard) {
        mSkillsIQLeaderBoard = skillsIQLeaderBoard;
    }

    public List<LeaderModel> getLearningHoursLeaderBoard() {
        return mLearningHoursLeaderBoard;
    }

    public List<LeaderModel> getSkillsIQLeaderBoard() {
        return mSkillsIQLeaderBoard;
    }
}
