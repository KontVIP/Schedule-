package com.example.schedule.Schedule;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.schedule.R;

import java.util.Calendar;

public class ScheduleActivity extends AppCompatActivity {

    public int mCurrentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentDaysAdapter adapter = new FragmentDaysAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // x % 2; 1 - нечетная, 0 - четная


        if (weekOfYear % 2 == 0) {
            switch (dayOfWeek) {
                case Calendar.MONDAY:
                    viewPager.setCurrentItem(0, false);
                    break;
                case Calendar.TUESDAY:
                    viewPager.setCurrentItem(1, false);
                    break;
                case Calendar.WEDNESDAY:
                    viewPager.setCurrentItem(2, false);
                    break;
                case Calendar.THURSDAY:
                    viewPager.setCurrentItem(3, false);
                    break;
                case Calendar.FRIDAY:
                    viewPager.setCurrentItem(4, false);
                    break;
                case Calendar.SATURDAY:
                    viewPager.setCurrentItem(5, false);
                    break;
                case Calendar.SUNDAY:
                    viewPager.setCurrentItem(6, false);
                    break;
            }
        } else {
            switch (dayOfWeek) {
                case Calendar.MONDAY:
                    viewPager.setCurrentItem(7, false);
                    break;
                case Calendar.TUESDAY:
                    viewPager.setCurrentItem(8, false);
                    break;
                case Calendar.WEDNESDAY:
                    viewPager.setCurrentItem(9, false);
                    break;
                case Calendar.THURSDAY:
                    viewPager.setCurrentItem(10, false);
                    break;
                case Calendar.FRIDAY:
                    viewPager.setCurrentItem(11, false);
                    break;
                case Calendar.SATURDAY:
                    viewPager.setCurrentItem(12, false);
                    break;
                case Calendar.SUNDAY:
                    viewPager.setCurrentItem(13, false);
                    break;
            }
        }

        viewPager.addOnPageChangeListener(new CircularViewPagerHandler(viewPager));

    }
}
