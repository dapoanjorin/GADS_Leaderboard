package com.dapo.gadsleaderboard;

import android.os.Build;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        // transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        TextView projectSubmission = findViewById(R.id.project_submission);
        EditText firstName = findViewById(R.id.first_name);
        EditText lastName = findViewById(R.id.last_name);
        EditText emailAddress = findViewById(R.id.email_address);
        EditText projectLink = findViewById(R.id.link_to_project);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectSubmission.setVisibility(View.GONE);
                firstName.setVisibility(View.GONE);
                lastName.setVisibility(View.GONE);
                emailAddress.setVisibility(View.GONE);
                projectLink.setVisibility(View.GONE);
                submitButton.setVisibility(View.GONE);
                showConfirmationDialog();
            }
        });

    }

    private void showConfirmationDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SubmissionDialogFragment dialogFragment = SubmissionDialogFragment.newInstance(SubmissionDialogFragment.CONFIRMATION);
        dialogFragment.show(fragmentManager, "");
    }
}
