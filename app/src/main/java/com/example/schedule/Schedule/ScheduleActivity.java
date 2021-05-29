package com.example.schedule.Schedule;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.schedule.R;

public class ScheduleActivity extends AppCompatActivity {

    public int mCurrentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentDaysAdapter adapter = new FragmentDaysAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new CircularViewPagerHandler(viewPager));

    }
}
