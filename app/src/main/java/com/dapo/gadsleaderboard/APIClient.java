package com.dapo.gadsleaderboard;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class APIClient {

    private static final String TAG = "APIClient";

    private static Retrofit mRetrofit;
    private static APIClientInterface mAPIClientInterface;
    public static final String LEADERBOARD_BASE_URL = "https://gadsapi.herokuapp.com/";
    public static final String SUBMISSION_BASE_URL = "https://docs.google.com/forms/d/e/";

    private DataManager mDataManager;

    public APIClient(DataManager dm) {
        this.mDataManager = dm;
    }

    private Retrofit getClient(int type) {
        if (mRetrofit == null) {
            if(type == 0) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(LEADERBOARD_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } else if(type == 1) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(SUBMISSION_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

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

        mAPIClientInterface = getClient(0).create(APIClientInterface.class);

        Call<List<LeaderModel>> call = mAPIClientInterface.getLearningHoursLeaderBoard();

        Log.d(TAG, "Response = about to enter enqueue");
        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {
                Log.d(TAG, "Response: here now");
                Log.d(TAG, "Response: " + response.body());
                recyclerAdapter.setLeaderModelData(response.body(), 0);
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {
                Log.d(TAG, "Failed");

            }
        });
    }

    public void setupSkillIQLeaderBoard(LearningLeaderRecyclerAdapter recyclerAdapter) {

        Log.d(TAG, "initializeLeaderBoard");

        mAPIClientInterface = getClient(0).create(APIClientInterface.class);

        Call<List<LeaderModel>> call = mAPIClientInterface.getSkillIQLeaderBoard();

        Log.d(TAG, "Response = about to enter enqueue");
        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {
                Log.d(TAG, "Response of skills: here now");
                Log.d(TAG, "Response: of skills " + response.body());
                recyclerAdapter.setLeaderModelData(response.body(), 1);
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {
                Log.d(TAG, "Failed");

            }
        });
    }

    public void submitDetails(String emailAddress, String firstName,
                              String lastName, String linkToProject, Activity activity) {

        Log.d("Test", "was here submission");

        mAPIClientInterface = getClient(1).create(APIClientInterface.class);

        Call<Void> call = mAPIClientInterface.submitDetails(emailAddress, firstName, lastName, linkToProject);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    Log.d("Test", "was here success");
                    hideWidgets(activity);
                    FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                    SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.SUCCESS);
                    dialogFragment.show(fragmentManager, "");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("Test", "was here failed");
                hideWidgets(activity);
                FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.FAILURE);
                dialogFragment.show(fragmentManager, "");

            }
        });

    }

    public  void hideWidgets(Activity activity) {

        Log.d("Test", "was here views");
        TextView projectSubmission = activity.findViewById(R.id.project_submission);
        EditText firstName = activity.findViewById(R.id.first_name);
        EditText lastName = activity.findViewById(R.id.last_name);
        EditText emailAddress = activity.findViewById(R.id.email_address);
        EditText projectLink = activity.findViewById(R.id.link_to_project);
        Button submitButton = activity.findViewById(R.id.submit_button);

        projectSubmission.setVisibility(View.VISIBLE);
        firstName.setVisibility(View.VISIBLE);
        lastName.setVisibility(View.VISIBLE);
        emailAddress.setVisibility(View.VISIBLE);
        projectLink.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.VISIBLE);

    }
}
