package com.example.schedule.Schedule.Days;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class SundayFirst extends Fragment implements View.OnClickListener {
    private TextView sundayFirstTV, sundaySecondTV, sundayThirdTV, sundayFourthTV, sundayFifthTV, sundaySixthTV, sundaySeventhTV, sundayEighthTV;
    private DatabaseReference scheduleReference;
    private DatabaseReference userReference;
    private DatabaseReference groupReference;

    private String userId, scheduleId;
    private User user;
    Schedule schedule;

    ImageView editImageView;

    AlertDialog alert;
    View lessonField_1, lessonField_2, lessonField_3, lessonField_4, lessonField_5, lessonField_6, lessonField_7, lessonField_8;
    String name1, name2, name3, name4, name5, name6, name7, name8;
    String email1, email2, email3, email4, email5, email6, email7, email8;
    AlertDialog.Builder builder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sunday_first, container, false);

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
                                sundayFirstTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                sundaySecondTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 2").child("lessonName").getValue(String.class));
                                sundayThirdTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 3").child("lessonName").getValue(String.class));
                                sundayFourthTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 4").child("lessonName").getValue(String.class));
                                sundayFifthTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 5").child("lessonName").getValue(String.class));
                                sundaySixthTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 6").child("lessonName").getValue(String.class));
                                sundaySeventhTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 7").child("lessonName").getValue(String.class));
                                sundayEighthTV.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 8").child("lessonName").getValue(String.class));

                                name1 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class);
                                name2 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 2").child("teacherName").getValue(String.class);
                                name3 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 3").child("teacherName").getValue(String.class);
                                name4 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 4").child("teacherName").getValue(String.class);
                                name5 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 5").child("teacherName").getValue(String.class);
                                name6 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 6").child("teacherName").getValue(String.class);
                                name7 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 7").child("teacherName").getValue(String.class);
                                name8 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 8").child("teacherName").getValue(String.class);
                                email1 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class);
                                email2 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 2").child("teacherEmail").getValue(String.class);
                                email3 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 3").child("teacherEmail").getValue(String.class);
                                email4 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 4").child("teacherEmail").getValue(String.class);
                                email5 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 5").child("teacherEmail").getValue(String.class);
                                email6 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 6").child("teacherEmail").getValue(String.class);
                                email7 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 7").child("teacherEmail").getValue(String.class);
                                email8 = snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 8").child("teacherEmail").getValue(String.class);
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

        builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(true);
        builder.setNeutralButton("????", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,
                                int id) {
                dialog.cancel();
            }
        });
        lessonField_1 = rootView.findViewById(R.id.ln_first);
        lessonField_1.setOnClickListener(this);
        lessonField_2 = rootView.findViewById(R.id.ln_second);
        lessonField_2.setOnClickListener(this);
        lessonField_3=rootView.findViewById(R.id.ln_third);
        lessonField_3.setOnClickListener(this);
        lessonField_4=rootView.findViewById(R.id.ln_fourth);
        lessonField_4.setOnClickListener(this);
        lessonField_5=rootView.findViewById(R.id.ln_fifth);
        lessonField_5.setOnClickListener(this);
        lessonField_6=rootView.findViewById(R.id.ln_sixth);
        lessonField_6.setOnClickListener(this);
        lessonField_7=rootView.findViewById(R.id.ln_seventh);
        lessonField_7.setOnClickListener(this);
        lessonField_8=rootView.findViewById(R.id.ln_eighth);
        lessonField_8.setOnClickListener(this);
        return rootView;
    }

    public void init(View rootView) {
        editImageView = rootView.findViewById(R.id.edit_image_view);
        scheduleReference = FirebaseDatabase.getInstance().getReference("Schedule");
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");

        sundayFirstTV = rootView.findViewById(R.id.lesson_first);
        sundaySecondTV = rootView.findViewById(R.id.lesson_second);
        sundayThirdTV = rootView.findViewById(R.id.lesson_third);
        sundayFourthTV = rootView.findViewById(R.id.lesson_fourth);
        sundayFifthTV = rootView.findViewById(R.id.lesson_fifth);
        sundaySixthTV = rootView.findViewById(R.id.lesson_sixth);
        sundaySeventhTV = rootView.findViewById(R.id.lesson_seventh);
        sundayEighthTV = rootView.findViewById(R.id.lesson_eight);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_image_view:
                startActivity(new Intent(getActivity(), EditScheduleActivity.class));
                break;

            case R.id.ln_first:
                builder.setMessage("8:00-9:20" + "\n????'?? ??????????????????: " + name1 + "\n?????????? ??????????????????: " + email1);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_second:
                builder.setMessage("9:40-11:00" + "\n????'?? ??????????????????: " + name2 + "\n?????????? ??????????????????: " + email2);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_third:
                builder.setMessage("11:20-12:40" + "\n????'?? ??????????????????: " + name3 + "\n?????????? ??????????????????: " + email3);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_fourth:
                builder.setMessage("13:00-14:20" + "\n????'?? ??????????????????: " + name4 + "\n?????????? ??????????????????: " + email4);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_fifth:
                builder.setMessage("14:40-16:00" + "\n????'?? ??????????????????: " + name5 + "\n?????????? ??????????????????: " + email5);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_sixth:
                builder.setMessage("16:20-17:40" + "\n????'?? ??????????????????: " + name6 + "\n?????????? ??????????????????: " + email6);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_seventh:
                builder.setMessage("18:00-19:20" + "\n????'?? ??????????????????: " + name7 + "\n?????????? ??????????????????: " + email7);
                alert = builder.create();
                alert.show();
                break;
            case R.id.ln_eighth:
                builder.setMessage("19:40-21:00" + "\n????'?? ??????????????????: " + name8 + "\n?????????? ??????????????????: " + email8);
                alert = builder.create();
                alert.show();
                break;
        }
    }
}