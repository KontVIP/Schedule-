package com.example.schedule.Schedule;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.schedule.R;

public class ScheduleActivity extends AppCompatActivity {

    private int mCurrentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentDaysAdapter adapter = new FragmentDaysAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(mCurrentPosition == 15) {
                    viewPager.setCurrentItem(1, false);
                } else if (mCurrentPosition == 0) {
                    viewPager.setCurrentItem(14, false);
                }
            }
        });

    }
}
