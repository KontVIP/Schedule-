package com.example.schedule.Schedule.Days;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.schedule.Auth.User;
import com.example.schedule.EditSchedule.EditScheduleActivity;
import com.example.schedule.R;
import com.example.schedule.Schedule.Schedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MondayFirst extends Fragment implements View.OnClickListener {

    private TextView mondayFirstTV, mondaySecondTV, mondayThirdTV, mondayFourthTV, mondayFifthTV, mondaySixthTV, mondaySeventhTV, mondayEighthTV;
    private DatabaseReference scheduleReference;
    private DatabaseReference userReference;
    private DatabaseReference groupReference;

    private String userId, scheduleId;
    private User user;
    Schedule schedule;
    ImageView editImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_monday_first, container, false);

        init(rootView);
        editImageView.setOnClickListener(this);
        userId = com.example.schedule.MainActivity.userId;
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(userId).getValue(User.class);

                groupReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        scheduleId = snapshot.child(user.groupId).child("scheduleId").getValue(String.class);
                        schedule = new Schedule();
                        schedule.scheduleId = scheduleId;

                        scheduleReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                mondayFirstTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                mondaySecondTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 2").child("lessonName").getValue(String.class));
                                mondayThirdTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 3").child("lessonName").getValue(String.class));
                                mondayFourthTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 4").child("lessonName").getValue(String.class));
                                mondayFifthTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 5").child("lessonName").getValue(String.class));
                                mondaySixthTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 6").child("lessonName").getValue(String.class));
                                mondaySeventhTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 7").child("lessonName").getValue(String.class));
                                mondayEighthTV.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 8").child("lessonName").getValue(String.class));
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        return rootView;
    }

    private void init(View rootView) {
        scheduleReference = FirebaseDatabase.getInstance().getReference("Schedule");
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");
        editImageView = rootView.findViewById(R.id.edit_image_view);
        mondayFirstTV = rootView.findViewById(R.id.tv_monday_first_lesson_first);
        mondaySecondTV = rootView.findViewById(R.id.tv_monday_first_lesson_second);
        mondayThirdTV = rootView.findViewById(R.id.tv_monday_first_lesson_third);
        mondayFourthTV = rootView.findViewById(R.id.tv_monday_first_lesson_fourth);
        mondayFifthTV = rootView.findViewById(R.id.tv_monday_first_lesson_fifth);
        mondaySixthTV = rootView.findViewById(R.id.tv_monday_first_lesson_sixth);
        mondaySeventhTV = rootView.findViewById(R.id.tv_monday_first_lesson_seventh);
        mondayEighthTV = rootView.findViewById(R.id.tv_monday_first_lesson_eighth);
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