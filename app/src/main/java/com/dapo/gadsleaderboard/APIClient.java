package com.dapo.gadsleaderboard;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class APIClient {

    private static final String TAG = "APIClient";

    private static Retrofit mRetrofit;
    private static RequestInterface mRequestInterface;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    private DataManager mDataManager;

    public APIClient(DataManager dm) {
        this.mDataManager = dm;
    }

    private Retrofit getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    //    private OkHttpClient getHttpClient() {
//
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//
//        //TODO : remove logging interceptors as it is to be used for development purpose
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(300, TimeUnit.SECONDS)
//                .readTimeout(300,TimeUnit.SECONDS).
//                        addInterceptor(logging).
//                        build();
//
//        return client;
//    }

    public void setupLearningHoursLeaderBoard(LearningLeaderRecyclerAdapter recyclerAdapter) {

        Log.d(TAG, "initializeLeaderBoard");

        mRequestInterface = getClient().create(RequestInterface.class);

        Call<List<LeaderModel>> call = mRequestInterface.getLearningHoursLeaderBoard();

        Log.d(TAG, "Response = about to enter enqueue");
        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {
                Log.d(TAG, "Response: here now");
                Log.d(TAG, "Response: " + response.body());
                recyclerAdapter.setLeaderModelData(response.body());
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {
                Log.d(TAG, "Failed");

            }
        });
    }

    public void setupSkillIQLeaderBoard(LearningLeaderRecyclerAdapter recyclerAdapter) {

        Log.d(TAG, "initializeLeaderBoard");

        mRequestInterface = getClient().create(RequestInterface.class);

        Call<List<LeaderModel>> call = mRequestInterface.getSkillIQLeaderBoard();

        Log.d(TAG, "Response = about to enter enqueue");
        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {
                Log.d(TAG, "Response of skills: here now");
                Log.d(TAG, "Response: of skills " + response.body());
                recyclerAdapter.setLeaderModelData(response.body());
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {
                Log.d(TAG, "Failed");

            }
        });

    }
}
