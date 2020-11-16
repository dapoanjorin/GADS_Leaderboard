package com.dapo.gadsleaderboard.ui.activities;

import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dapo.gadsleaderboard.adapters.ViewPagerAdapter;
import com.dapo.gadsleaderboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter mViewPagerAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        binding.viewPager.setAdapter(mViewPagerAdapter);

        binding.tabLayout.setupWithViewPager(binding.viewPager);

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmissionActivity.class);
                startActivity(intent);
            }
        });

    }

}
