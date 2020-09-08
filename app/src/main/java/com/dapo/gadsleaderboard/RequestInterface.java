package com.dapo.gadsleaderboard;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RequestInterface {

    @GET("/api/hours")
    Call<List<LeaderModel>> getLearningHoursLeaderBoard();

    @GET("/api/skilliq")
    Call<List<LeaderModel>> getSkillIQLeaderBoard();
}
