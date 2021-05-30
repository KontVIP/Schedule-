package com.example.schedule.Schedule.Days;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.schedule.R;


public class FridayFirst extends Fragment {

    private TextView fridayFirstTV, fridaySecondTV, fridayThirdTV, fridayFourthTV, fridayFifthTV, fridaySixthTV, fridaySeventhTV, fridayEighthTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friday_first, container, false);
    }
}