package com.dapo.gadsleaderboard;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        if(position == 0) {
           fragment = new LearningLeadersFragment();
        } else if(position == 1) {
           fragment = new SkillIQLeadersFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if(position == 0) {
            title = "Learning Leaders";
        } else if(position == 1) {
            title = "Skill IQ Leaders";
        }
        return title;
    }
}
