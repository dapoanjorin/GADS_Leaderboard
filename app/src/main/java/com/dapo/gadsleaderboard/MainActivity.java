package com.dapo.gadsleaderboard;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    public static Context mContext;
    private DataManager mDm;
    private APIClient mApiClient;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // transparent status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        button = findViewById(R.id.submit_button);

        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmissionActivity.class);
                startActivity(intent);
            }
        });

    }
}
