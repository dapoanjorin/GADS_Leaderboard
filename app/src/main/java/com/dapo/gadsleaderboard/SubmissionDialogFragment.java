package com.dapo.gadsleaderboard;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class SubmissionDialogFragment extends androidx.fragment.app.DialogFragment {

    public static final String TYPE = "Type";
    public static final String CONFIRMATION = "Confirmation";
    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failed";
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mProjectLink;
    private TextView mProjectSubmission;
    private Button mSubmitButton;


    public SubmissionDialogFragment() {
    }

    public static SubmissionDialogFragment newInstance(String type) {
        SubmissionDialogFragment dialogFragment = new SubmissionDialogFragment();
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProjectSubmission = getActivity().findViewById(R.id.project_submission);
        mFirstName = getActivity().findViewById(R.id.first_name);
        mLastName = getActivity().findViewById(R.id.last_name);
        mEmailAddress = getActivity().findViewById(R.id.email_address);
        mProjectLink = getActivity().findViewById(R.id.link_to_project);
        mSubmitButton = getActivity().findViewById(R.id.submit_button);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogAlert);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String type = getArguments().getString(TYPE);
        if (type == CONFIRMATION) {
            return inflater.inflate(R.layout.fragment_confirmation_dialog, container);
        } else if (type == SUCCESS) {
            return inflater.inflate(R.layout.fragment_success_dialog, container);
        }
        if (type == FAILURE) {
            return inflater.inflate(R.layout.fragment_failure_dialog, container);
        }
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String type = getArguments().getString(TYPE);
        if (type == CONFIRMATION) {
            Button yesButton = view.findViewById(R.id.yes_button);
            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getDialog().dismiss();

                    String firstName = mFirstName.getText().toString();
                    String lastName = mLastName.getText().toString();
                    String emailAddress = mEmailAddress.getText().toString();
                    String projectLink = mProjectLink.getText().toString();
                    Activity activity = getActivity();


                    DataManager dm = new DataManager();
                    APIClient apiClient = new APIClient(dm);
                    apiClient.submitDetails(firstName, lastName, emailAddress, projectLink, activity);
                }
            });
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!(getDialog().isShowing())) {
            mProjectSubmission.setVisibility(View.VISIBLE);
            mFirstName.setVisibility(View.VISIBLE);
            mLastName.setVisibility(View.VISIBLE);
            mEmailAddress.setVisibility(View.VISIBLE);
            mProjectLink.setVisibility(View.VISIBLE);
            mSubmitButton.setVisibility(View.VISIBLE);
        }
    }
}
