package com.example.schedule.Schedule;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.schedule.Schedule.Days.FridayFirst;
import com.example.schedule.Schedule.Days.FridaySecond;
import com.example.schedule.Schedule.Days.MondayFirst;
import com.example.schedule.Schedule.Days.MondaySecond;
import com.example.schedule.Schedule.Days.SaturdayFirst;
import com.example.schedule.Schedule.Days.SaturdaySecond;
import com.example.schedule.Schedule.Days.SundayFirst;
import com.example.schedule.Schedule.Days.SundaySecond;
import com.example.schedule.Schedule.Days.ThursdayFirst;
import com.example.schedule.Schedule.Days.ThursdaySecond;
import com.example.schedule.Schedule.Days.TuesdayFirst;
import com.example.schedule.Schedule.Days.TuesdaySecond;
import com.example.schedule.Schedule.Days.WednesDayFirst;
import com.example.schedule.Schedule.Days.WednesdaySecond;


public class FragmentDaysAdapter extends FragmentPagerAdapter {

    public FragmentDaysAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MondayFirst();
        } else if (position == 1){
            return new TuesdayFirst();
        } else if (position == 2){
            return new WednesDayFirst();
        } else if (position == 3){
            return new ThursdayFirst();
        } else if (position == 4){
            return new FridayFirst();
        }  else if (position == 5){
            return new SaturdayFirst();
        } else if (position == 6){
            return new SundayFirst();
        } else if (position == 7){
            return new MondaySecond();
        } else if (position == 8){
            return new TuesdaySecond();
        } else if (position == 9){
            return new WednesdaySecond();
        } else if (position == 10){
            return new ThursdaySecond();
        } else if (position == 11){
            return new FridaySecond();
        } else if (position == 12){
            return new SaturdaySecond();
        } else {
            return new SundaySecond();
        }
    }

    @Override
    public int getCount() {
        return 14;
    }
}