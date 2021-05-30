package com.example.schedule.Schedule.Days;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.schedule.EditSchedule.EditScheduleActivity;
import com.example.schedule.R;

public class SundaySecond extends Fragment implements View.OnClickListener {

    ImageView editImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sunday_second, container, false);

        init(rootView);

        editImageView.setOnClickListener(this);

        return rootView;
    }

    public void init(View rootView) {
        editImageView = rootView.findViewById(R.id.edit_image_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_image_view:
                startActivity(new Intent(getActivity(), EditScheduleActivity.class));
                break;
        }
    }
}