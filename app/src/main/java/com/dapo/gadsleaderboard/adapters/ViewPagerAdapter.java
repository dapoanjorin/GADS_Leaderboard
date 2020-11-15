package com.dapo.gadsleaderboard.adapters;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.dapo.gadsleaderboard.R;
import com.dapo.gadsleaderboard.ui.fragments.LearningLeadersFragment;
import com.dapo.gadsleaderboard.ui.fragments.SkillIQLeadersFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
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
            title =  mContext.getString(R.string.learning_leaders);
        } else if(position == 1) {
            title = mContext.getString(R.string.skill_iq_leaders);
        }
        return title;
    }
}
