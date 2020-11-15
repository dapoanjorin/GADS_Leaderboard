package com.dapo.gadsleaderboard.network;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.dapo.gadsleaderboard.R;
import com.dapo.gadsleaderboard.ui.fragments.SubmissionDialogFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String TAG = "APIClient";

    private static Retrofit mRetrofit;
    private static APIClientInterface mAPIClientInterface;
    public static final String LEADERBOARD_BASE_URL = "https://gadsapi.herokuapp.com/";
    public static final String SUBMISSION_BASE_URL = "https://docs.google.com/forms/d/e/";


    public APIClient() {
    }

    public static Retrofit getClient(int type) {
            if (type == 0) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(LEADERBOARD_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } else if (type == 1) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(SUBMISSION_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        return mRetrofit;
    }

    public void submitDetails(String emailAddress, String firstName,
                              String lastName, String linkToProject, Activity activity) {

        mAPIClientInterface = getClient(1).create(APIClientInterface.class);
        Call<Void> call = mAPIClientInterface.submitDetails(emailAddress, firstName, lastName, linkToProject);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                hideWidgets(activity);
                FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.SUCCESS);
                dialogFragment.show(fragmentManager, "");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                hideWidgets(activity);
                FragmentManager fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.FAILURE);
                dialogFragment.show(fragmentManager, "");
            }
        });

    }

    public void hideWidgets(Activity activity) {

        TextView projectSubmission = activity.findViewById(R.id.project_submission);
        EditText firstName = activity.findViewById(R.id.first_name);
        EditText lastName = activity.findViewById(R.id.last_name);
        EditText emailAddress = activity.findViewById(R.id.email_address);
        EditText projectLink = activity.findViewById(R.id.link_to_project);
        Button submitButton = activity.findViewById(R.id.submit_button);

        projectSubmission.setVisibility(View.GONE);
        firstName.setVisibility(View.GONE);
        lastName.setVisibility(View.GONE);
        emailAddress.setVisibility(View.GONE);
        projectLink.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);

    }
}
