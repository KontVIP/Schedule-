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


public class FridaySecond extends Fragment implements View.OnClickListener {

    private TextView fridayFirstTV, fridaySecondTV, fridayThirdTV, fridayFourthTV, fridayFifthTV, fridaySixthTV, fridaySeventhTV, fridayEighthTV;
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
        View rootView = inflater.inflate(R.layout.fragment_friday_second, container, false);

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
                                fridayFirstTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                fridaySecondTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 2").child("lessonName").getValue(String.class));
                                fridayThirdTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 3").child("lessonName").getValue(String.class));
                                fridayFourthTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 4").child("lessonName").getValue(String.class));
                                fridayFifthTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 5").child("lessonName").getValue(String.class));
                                fridaySixthTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 6").child("lessonName").getValue(String.class));
                                fridaySeventhTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 7").child("lessonName").getValue(String.class));
                                fridayEighthTV.setText(snapshot.child(scheduleId).child("week 2").child("friday").child("lesson 8").child("lessonName").getValue(String.class));
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

        fridayFirstTV = rootView.findViewById(R.id.lesson_first);
        fridaySecondTV = rootView.findViewById(R.id.lesson_second);
        fridayThirdTV = rootView.findViewById(R.id.lesson_third);
        fridayFourthTV = rootView.findViewById(R.id.lesson_fourth);
        fridayFifthTV = rootView.findViewById(R.id.lesson_fifth);
        fridaySixthTV = rootView.findViewById(R.id.lesson_sixth);
        fridaySeventhTV = rootView.findViewById(R.id.lesson_seventh);
        fridayEighthTV = rootView.findViewById(R.id.lesson_eight);
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