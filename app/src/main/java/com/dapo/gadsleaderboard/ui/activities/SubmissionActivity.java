package com.dapo.gadsleaderboard.ui.activities;

import android.os.Build;
import android.view.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.dapo.gadsleaderboard.ui.fragments.SubmissionDialogFragment;
import com.dapo.gadsleaderboard.databinding.ActivitySubmissionBinding;

public class SubmissionActivity extends AppCompatActivity {

    private ActivitySubmissionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubmissionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        binding.backArrowButton.setOnClickListener(view12 -> finish());
        binding.submitButton.setOnClickListener(view1 -> {
            binding.projectSubmission.setVisibility(View.GONE);
            binding.firstName.setVisibility(View.GONE);
            binding.lastName.setVisibility(View.GONE);
            binding.emailAddress.setVisibility(View.GONE);
            binding.linkToProject.setVisibility(View.GONE);
            binding.submitButton.setVisibility(View.GONE);
            showConfirmationDialog();
        });

    }

    private void showConfirmationDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.CONFIRMATION);
        dialogFragment.show(fragmentManager, "");
    }
}
