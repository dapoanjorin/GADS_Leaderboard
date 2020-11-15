package com.dapo.gadsleaderboard.ui.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.dapo.gadsleaderboard.R;
import com.dapo.gadsleaderboard.databinding.ActivitySubmissionBinding;
import com.dapo.gadsleaderboard.databinding.FragmentConfirmationDialogBinding;
import com.dapo.gadsleaderboard.databinding.FragmentFailureDialogBinding;
import com.dapo.gadsleaderboard.databinding.FragmentSuccessDialogBinding;
import com.dapo.gadsleaderboard.network.APIClient;

public class SubmissionDialogFragment extends androidx.fragment.app.DialogFragment {

    public static final String TYPE = "Type";
    public static final String CONFIRMATION = "Confirmation";
    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failed";


    private FragmentConfirmationDialogBinding confirmationBinding;
    private FragmentSuccessDialogBinding successBinding;
    private FragmentFailureDialogBinding failureBinding;
    private ActivitySubmissionBinding submissionBinding;

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
        submissionBinding = ActivitySubmissionBinding.inflate(getActivity().getLayoutInflater());
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogAlert);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String type = getArguments().getString(TYPE);
        if (type == CONFIRMATION) {
            confirmationBinding = FragmentConfirmationDialogBinding.inflate(inflater, container, false);
            View view = confirmationBinding.getRoot();
            confirmationBinding.cancelButton.setOnClickListener(view1 -> getDialog().dismiss());
            return view;
        } else if (type == SUCCESS) {
            successBinding = FragmentSuccessDialogBinding.inflate(inflater, container, false);
            return successBinding.getRoot();
        }
        if (type == FAILURE) {
            failureBinding = FragmentFailureDialogBinding.inflate(inflater, container, false);
            return failureBinding.getRoot();
        }
        return null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String type = getArguments().getString(TYPE);
        if (type == CONFIRMATION) {
            confirmationBinding.yesButton.setOnClickListener(view1 -> {
                getDialog().dismiss();

                String firstName = submissionBinding.firstName.getText().toString();
                String lastName = submissionBinding.lastName.getText().toString();
                String emailAddress = submissionBinding.emailAddress.getText().toString();
                String projectLink = submissionBinding.projectSubmission.getText().toString();
                Activity activity = getActivity();

                APIClient apiClient = new APIClient();
                apiClient.submitDetails(firstName, lastName, emailAddress, projectLink, activity);
            });
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!(getDialog().isShowing())) {
            submissionBinding.projectSubmission.setVisibility(View.VISIBLE);
            submissionBinding.firstName.setVisibility(View.VISIBLE);
            submissionBinding.lastName.setVisibility(View.VISIBLE);
            submissionBinding.emailAddress.setVisibility(View.VISIBLE);
            submissionBinding.linkToProject.setVisibility(View.VISIBLE);
            submissionBinding.submitButton.setVisibility(View.VISIBLE);
        }
    }
}
