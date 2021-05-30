package com.example.schedule.EditSchedule;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.schedule.R;

public class WeeksAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public WeeksAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WeekOneFragment();
        } else {
            return new WeekTwoFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.text_first_week);
        } else {
            return mContext.getString(R.string.text_second_week);
        }
    }
}
