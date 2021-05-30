package com.example.schedule.EditSchedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.schedule.R;
import com.google.android.material.tabs.TabLayout;

import io.paperdb.Paper;

public class EditScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_schedule);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        WeeksAdapter adapter = new WeeksAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}