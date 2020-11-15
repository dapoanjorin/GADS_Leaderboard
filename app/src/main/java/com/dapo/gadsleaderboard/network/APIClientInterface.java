package com.dapo.gadsleaderboard.network;

import com.dapo.gadsleaderboard.other.LeaderModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface APIClientInterface {

    @GET("/api/hours")
    Call<List<LeaderModel>> getLearningHoursLeaderBoard();

    @GET("/api/skilliq")
    Call<List<LeaderModel>> getSkillIQLeaderBoard();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Void> submitDetails(
           @Field("entry.1824927963") String emailAddress,
           @Field("entry.1877115667") String firstName,
           @Field("entry.2006916086") String lastName,
           @Field("entry.284483984") String linkToProject
    );
}
