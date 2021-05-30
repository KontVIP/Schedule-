package com.example.schedule.EditSchedule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.schedule.Auth.User;
import com.example.schedule.Group;
import com.example.schedule.R;
import com.example.schedule.Schedule.Lesson;
import com.example.schedule.Schedule.Schedule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;


public class WeekOneFragment extends Fragment {

    private EditText firstLesson1, first_full_name_teacher_1, first_teacher_email_1,
            firstLesson2, first_full_name_teacher_2, first_teacher_email_2,
            firstLesson3, first_full_name_teacher_3, first_teacher_email_3,
            firstLesson4, first_full_name_teacher_4, first_teacher_email_4,
            firstLesson5, first_full_name_teacher_5, first_teacher_email_5,
            firstLesson6, first_full_name_teacher_6, first_teacher_email_6,
            firstLesson7, first_full_name_teacher_7, first_teacher_email_7;

    private EditText secondLesson1, second_full_name_teacher_1, second_teacher_email_1,
            secondLesson2, second_full_name_teacher_2, second_teacher_email_2,
            secondLesson3, second_full_name_teacher_3, second_teacher_email_3,
            secondLesson4, second_full_name_teacher_4, second_teacher_email_4,
            secondLesson5, second_full_name_teacher_5, second_teacher_email_5,
            secondLesson6, second_full_name_teacher_6, second_teacher_email_6,
            secondLesson7, second_full_name_teacher_7, second_teacher_email_7;

    private EditText thirdLesson1, third_full_name_teacher_1, third_teacher_email_1,
            thirdLesson2, third_full_name_teacher_2, third_teacher_email_2,
            thirdLesson3, third_full_name_teacher_3, third_teacher_email_3,
            thirdLesson4, third_full_name_teacher_4, third_teacher_email_4,
            thirdLesson5, third_full_name_teacher_5, third_teacher_email_5,
            thirdLesson6, third_full_name_teacher_6, third_teacher_email_6,
            thirdLesson7, third_full_name_teacher_7, third_teacher_email_7;

    private EditText fourthLesson1, fourth_full_name_teacher_1, fourth_teacher_email_1,
            fourthLesson2, fourth_full_name_teacher_2, fourth_teacher_email_2,
            fourthLesson3, fourth_full_name_teacher_3, fourth_teacher_email_3,
            fourthLesson4, fourth_full_name_teacher_4, fourth_teacher_email_4,
            fourthLesson5, fourth_full_name_teacher_5, fourth_teacher_email_5,
            fourthLesson6, fourth_full_name_teacher_6, fourth_teacher_email_6,
            fourthLesson7, fourth_full_name_teacher_7, fourth_teacher_email_7;

    private EditText fifthLesson1, fifth_full_name_teacher_1, fifth_teacher_email_1,
            fifthLesson2, fifth_full_name_teacher_2, fifth_teacher_email_2,
            fifthLesson3, fifth_full_name_teacher_3, fifth_teacher_email_3,
            fifthLesson4, fifth_full_name_teacher_4, fifth_teacher_email_4,
            fifthLesson5, fifth_full_name_teacher_5, fifth_teacher_email_5,
            fifthLesson6, fifth_full_name_teacher_6, fifth_teacher_email_6,
            fifthLesson7, fifth_full_name_teacher_7, fifth_teacher_email_7;

    private EditText sixthLesson1, sixth_full_name_teacher_1, sixth_teacher_email_1,
            sixthLesson2, sixth_full_name_teacher_2, sixth_teacher_email_2,
            sixthLesson3, sixth_full_name_teacher_3, sixth_teacher_email_3,
            sixthLesson4, sixth_full_name_teacher_4, sixth_teacher_email_4,
            sixthLesson5, sixth_full_name_teacher_5, sixth_teacher_email_5,
            sixthLesson6, sixth_full_name_teacher_6, sixth_teacher_email_6,
            sixthLesson7, sixth_full_name_teacher_7, sixth_teacher_email_7;

    private EditText seventhLesson1, seventh_full_name_teacher_1, seventh_teacher_email_1,
            seventhLesson2, seventh_full_name_teacher_2, seventh_teacher_email_2,
            seventhLesson3, seventh_full_name_teacher_3, seventh_teacher_email_3,
            seventhLesson4, seventh_full_name_teacher_4, seventh_teacher_email_4,
            seventhLesson5, seventh_full_name_teacher_5, seventh_teacher_email_5,
            seventhLesson6, seventh_full_name_teacher_6, seventh_teacher_email_6,
            seventhLesson7, seventh_full_name_teacher_7, seventh_teacher_email_7;

    private EditText eighthLesson1, eighth_full_name_teacher_1, eighth_teacher_email_1,
            eighthLesson2, eighth_full_name_teacher_2, eighth_teacher_email_2,
            eighthLesson3, eighth_full_name_teacher_3, eighth_teacher_email_3,
            eighthLesson4, eighth_full_name_teacher_4, eighth_teacher_email_4,
            eighthLesson5, eighth_full_name_teacher_5, eighth_teacher_email_5,
            eighthLesson6, eighth_full_name_teacher_6, eighth_teacher_email_6,
            eighthLesson7, eighth_full_name_teacher_7, eighth_teacher_email_7;

    private FloatingActionButton fab;

    private DatabaseReference userReference;
    private DatabaseReference groupReference;
    private DatabaseReference scheduleReference;

    private String userId, groupId, scheduleId;

    User user;
    Group group;
    Schedule schedule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_week_one, container, false);

        init(rootView);

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
                                firstLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                firstLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                first_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                first_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                secondLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                secondLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                second_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                second_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                thirdLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                thirdLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                third_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                third_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                fourthLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fourthLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                fourth_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                fourth_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                fifthLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                fifthLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                fifth_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                fifth_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                sixthLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                sixthLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                sixth_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                sixth_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                seventhLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                seventhLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                seventh_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                seventh_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));


                                eighthLesson1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_1.setText(snapshot.child(scheduleId).child("week 1").child("monday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_2.setText(snapshot.child(scheduleId).child("week 1").child("tuesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_3.setText(snapshot.child(scheduleId).child("week 1").child("wednesday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_4.setText(snapshot.child(scheduleId).child("week 1").child("thursday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_5.setText(snapshot.child(scheduleId).child("week 1").child("friday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_6.setText(snapshot.child(scheduleId).child("week 1").child("saturday").child("lesson 1").child("teacherEmail").getValue(String.class));

                                eighthLesson7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("lessonName").getValue(String.class));
                                eighth_full_name_teacher_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherName").getValue(String.class));
                                eighth_teacher_email_7.setText(snapshot.child(scheduleId).child("week 1").child("sunday").child("lesson 1").child("teacherEmail").getValue(String.class));
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


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        user = snapshot.child(userId).getValue(User.class);

                        groupReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                scheduleReference.child(scheduleId).setValue(schedule);
                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson1.getText().toString().trim(),
                                        first_full_name_teacher_1.getText().toString().trim(),
                                        first_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson2.getText().toString().trim(),
                                        first_full_name_teacher_2.getText().toString().trim(),
                                        first_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson3.getText().toString().trim(),
                                        first_full_name_teacher_3.getText().toString().trim(),
                                        first_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson4.getText().toString().trim(),
                                        first_full_name_teacher_4.getText().toString().trim(),
                                        first_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson5.getText().toString().trim(),
                                        first_full_name_teacher_5.getText().toString().trim(),
                                        first_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson6.getText().toString().trim(),
                                        first_full_name_teacher_6.getText().toString().trim(),
                                        first_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 1").setValue(new Lesson(firstLesson7.getText().toString().trim(),
                                        first_full_name_teacher_7.getText().toString().trim(),
                                        first_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson1.getText().toString().trim(),
                                        second_full_name_teacher_1.getText().toString().trim(),
                                        second_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson2.getText().toString().trim(),
                                        second_full_name_teacher_2.getText().toString().trim(),
                                        second_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson3.getText().toString().trim(),
                                        second_full_name_teacher_3.getText().toString().trim(),
                                        second_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson4.getText().toString().trim(),
                                        second_full_name_teacher_4.getText().toString().trim(),
                                        second_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson5.getText().toString().trim(),
                                        second_full_name_teacher_5.getText().toString().trim(),
                                        second_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson6.getText().toString().trim(),
                                        second_full_name_teacher_6.getText().toString().trim(),
                                        second_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 2").setValue(new Lesson(secondLesson7.getText().toString().trim(),
                                        second_full_name_teacher_7.getText().toString().trim(),
                                        second_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson1.getText().toString().trim(),
                                        third_full_name_teacher_1.getText().toString().trim(),
                                        third_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson2.getText().toString().trim(),
                                        third_full_name_teacher_2.getText().toString().trim(),
                                        third_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson3.getText().toString().trim(),
                                        third_full_name_teacher_3.getText().toString().trim(),
                                        third_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson4.getText().toString().trim(),
                                        third_full_name_teacher_4.getText().toString().trim(),
                                        third_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson5.getText().toString().trim(),
                                        third_full_name_teacher_5.getText().toString().trim(),
                                        third_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson6.getText().toString().trim(),
                                        third_full_name_teacher_6.getText().toString().trim(),
                                        third_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 3").setValue(new Lesson(thirdLesson7.getText().toString().trim(),
                                        third_full_name_teacher_7.getText().toString().trim(),
                                        third_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson1.getText().toString().trim(),
                                        fourth_full_name_teacher_1.getText().toString().trim(),
                                        fourth_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson2.getText().toString().trim(),
                                        fourth_full_name_teacher_2.getText().toString().trim(),
                                        fourth_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson3.getText().toString().trim(),
                                        fourth_full_name_teacher_3.getText().toString().trim(),
                                        fourth_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson4.getText().toString().trim(),
                                        fourth_full_name_teacher_4.getText().toString().trim(),
                                        fourth_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson5.getText().toString().trim(),
                                        fourth_full_name_teacher_5.getText().toString().trim(),
                                        fourth_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson6.getText().toString().trim(),
                                        fourth_full_name_teacher_6.getText().toString().trim(),
                                        fourth_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 4").setValue(new Lesson(fourthLesson7.getText().toString().trim(),
                                        fourth_full_name_teacher_7.getText().toString().trim(),
                                        fourth_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson1.getText().toString().trim(),
                                        fifth_full_name_teacher_1.getText().toString().trim(),
                                        fifth_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson2.getText().toString().trim(),
                                        fifth_full_name_teacher_2.getText().toString().trim(),
                                        fifth_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson3.getText().toString().trim(),
                                        fifth_full_name_teacher_3.getText().toString().trim(),
                                        fifth_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson4.getText().toString().trim(),
                                        fifth_full_name_teacher_4.getText().toString().trim(),
                                        fifth_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson5.getText().toString().trim(),
                                        fifth_full_name_teacher_5.getText().toString().trim(),
                                        fifth_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson6.getText().toString().trim(),
                                        fifth_full_name_teacher_6.getText().toString().trim(),
                                        fifth_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 5").setValue(new Lesson(fifthLesson7.getText().toString().trim(),
                                        fifth_full_name_teacher_7.getText().toString().trim(),
                                        fifth_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson1.getText().toString().trim(),
                                        sixth_full_name_teacher_1.getText().toString().trim(),
                                        sixth_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson2.getText().toString().trim(),
                                        sixth_full_name_teacher_2.getText().toString().trim(),
                                        sixth_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson3.getText().toString().trim(),
                                        sixth_full_name_teacher_3.getText().toString().trim(),
                                        sixth_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson4.getText().toString().trim(),
                                        sixth_full_name_teacher_4.getText().toString().trim(),
                                        sixth_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson5.getText().toString().trim(),
                                        sixth_full_name_teacher_5.getText().toString().trim(),
                                        sixth_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson6.getText().toString().trim(),
                                        sixth_full_name_teacher_6.getText().toString().trim(),
                                        sixth_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 6").setValue(new Lesson(sixthLesson7.getText().toString().trim(),
                                        sixth_full_name_teacher_7.getText().toString().trim(),
                                        sixth_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson1.getText().toString().trim(),
                                        seventh_full_name_teacher_1.getText().toString().trim(),
                                        seventh_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson2.getText().toString().trim(),
                                        seventh_full_name_teacher_2.getText().toString().trim(),
                                        seventh_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson3.getText().toString().trim(),
                                        seventh_full_name_teacher_3.getText().toString().trim(),
                                        seventh_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson4.getText().toString().trim(),
                                        seventh_full_name_teacher_4.getText().toString().trim(),
                                        seventh_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson5.getText().toString().trim(),
                                        seventh_full_name_teacher_5.getText().toString().trim(),
                                        seventh_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson6.getText().toString().trim(),
                                        seventh_full_name_teacher_6.getText().toString().trim(),
                                        seventh_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 7").setValue(new Lesson(seventhLesson7.getText().toString().trim(),
                                        seventh_full_name_teacher_7.getText().toString().trim(),
                                        seventh_teacher_email_7.getText().toString().trim()));


                                scheduleReference.child(scheduleId).child("week 1").child("monday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson1.getText().toString().trim(),
                                        eighth_full_name_teacher_1.getText().toString().trim(),
                                        eighth_teacher_email_1.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("tuesday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson2.getText().toString().trim(),
                                        eighth_full_name_teacher_2.getText().toString().trim(),
                                        eighth_teacher_email_2.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("wednesday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson3.getText().toString().trim(),
                                        eighth_full_name_teacher_3.getText().toString().trim(),
                                        eighth_teacher_email_3.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("thursday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson4.getText().toString().trim(),
                                        eighth_full_name_teacher_4.getText().toString().trim(),
                                        eighth_teacher_email_4.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("friday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson5.getText().toString().trim(),
                                        eighth_full_name_teacher_5.getText().toString().trim(),
                                        eighth_teacher_email_5.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("saturday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson6.getText().toString().trim(),
                                        eighth_full_name_teacher_6.getText().toString().trim(),
                                        eighth_teacher_email_6.getText().toString().trim()));

                                scheduleReference.child(scheduleId).child("week 1").child("sunday")
                                        .child("lesson 8").setValue(new Lesson(eighthLesson7.getText().toString().trim(),
                                        eighth_full_name_teacher_7.getText().toString().trim(),
                                        eighth_teacher_email_7.getText().toString().trim()));
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
        });



        return rootView;
    }

    private void init(View rootView) {


        scheduleReference = FirebaseDatabase.getInstance().getReference("Schedule");
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");

        fab = rootView.findViewById(R.id.floating_done_button);

        firstLesson1 = rootView.findViewById(R.id.first_lesson_1);
        first_full_name_teacher_1 = rootView.findViewById(R.id.first_full_name_teacher_1);
        first_teacher_email_1 = rootView.findViewById(R.id.first_teacher_email_1);
        firstLesson2 = rootView.findViewById(R.id.first_lesson_2);
        first_full_name_teacher_2 = rootView.findViewById(R.id.first_full_name_teacher_2);
        first_teacher_email_2 = rootView.findViewById(R.id.first_teacher_email_2);
        firstLesson3 = rootView.findViewById(R.id.first_lesson_3);
        first_full_name_teacher_3 = rootView.findViewById(R.id.first_full_name_teacher_3);
        first_teacher_email_3 = rootView.findViewById(R.id.first_teacher_email_3);
        firstLesson4 = rootView.findViewById(R.id.first_lesson_4);
        first_full_name_teacher_4 = rootView.findViewById(R.id.first_full_name_teacher_4);
        first_teacher_email_4 = rootView.findViewById(R.id.first_teacher_email_4);
        firstLesson5 = rootView.findViewById(R.id.first_lesson_5);
        first_full_name_teacher_5 = rootView.findViewById(R.id.first_full_name_teacher_5);
        first_teacher_email_5 = rootView.findViewById(R.id.first_teacher_email_5);
        firstLesson6 = rootView.findViewById(R.id.first_lesson_6);
        first_full_name_teacher_6 = rootView.findViewById(R.id.first_full_name_teacher_6);
        first_teacher_email_6 = rootView.findViewById(R.id.first_teacher_email_6);
        firstLesson7 = rootView.findViewById(R.id.first_lesson_7);
        first_full_name_teacher_7 = rootView.findViewById(R.id.first_full_name_teacher_7);
        first_teacher_email_7 = rootView.findViewById(R.id.first_teacher_email_7);

        secondLesson1 = rootView.findViewById(R.id.second_lesson_1);
        second_full_name_teacher_1 = rootView.findViewById(R.id.second_full_name_teacher_1);
        second_teacher_email_1 = rootView.findViewById(R.id.second_teacher_email_1);
        secondLesson2 = rootView.findViewById(R.id.second_lesson_2);
        second_full_name_teacher_2 = rootView.findViewById(R.id.second_full_name_teacher_2);
        second_teacher_email_2 = rootView.findViewById(R.id.second_teacher_email_2);
        secondLesson3 = rootView.findViewById(R.id.second_lesson_3);
        second_full_name_teacher_3 = rootView.findViewById(R.id.second_full_name_teacher_3);
        second_teacher_email_3 = rootView.findViewById(R.id.second_teacher_email_3);
        secondLesson4 = rootView.findViewById(R.id.second_lesson_4);
        second_full_name_teacher_4 = rootView.findViewById(R.id.second_full_name_teacher_4);
        second_teacher_email_4 = rootView.findViewById(R.id.second_teacher_email_4);
        secondLesson5 = rootView.findViewById(R.id.second_lesson_5);
        second_full_name_teacher_5 = rootView.findViewById(R.id.second_full_name_teacher_5);
        second_teacher_email_5 = rootView.findViewById(R.id.second_teacher_email_5);
        secondLesson6 = rootView.findViewById(R.id.second_lesson_6);
        second_full_name_teacher_6 = rootView.findViewById(R.id.second_full_name_teacher_6);
        second_teacher_email_6 = rootView.findViewById(R.id.second_teacher_email_6);
        secondLesson7 = rootView.findViewById(R.id.second_lesson_7);
        second_full_name_teacher_7 = rootView.findViewById(R.id.second_full_name_teacher_7);
        second_teacher_email_7 = rootView.findViewById(R.id.second_teacher_email_7);

        thirdLesson1 = rootView.findViewById(R.id.third_lesson_1);
        third_full_name_teacher_1 = rootView.findViewById(R.id.third_full_name_teacher_1);
        third_teacher_email_1 = rootView.findViewById(R.id.third_teacher_email_1);
        thirdLesson2 = rootView.findViewById(R.id.third_lesson_2);
        third_full_name_teacher_2 = rootView.findViewById(R.id.third_full_name_teacher_2);
        third_teacher_email_2 = rootView.findViewById(R.id.third_teacher_email_2);
        thirdLesson3 = rootView.findViewById(R.id.third_lesson_3);
        third_full_name_teacher_3 = rootView.findViewById(R.id.third_full_name_teacher_3);
        third_teacher_email_3 = rootView.findViewById(R.id.third_teacher_email_3);
        thirdLesson4 = rootView.findViewById(R.id.third_lesson_4);
        third_full_name_teacher_4 = rootView.findViewById(R.id.third_full_name_teacher_4);
        third_teacher_email_4 = rootView.findViewById(R.id.third_teacher_email_4);
        thirdLesson5 = rootView.findViewById(R.id.third_lesson_5);
        third_full_name_teacher_5 = rootView.findViewById(R.id.third_full_name_teacher_5);
        third_teacher_email_5 = rootView.findViewById(R.id.third_teacher_email_5);
        thirdLesson6 = rootView.findViewById(R.id.third_lesson_6);
        third_full_name_teacher_6 = rootView.findViewById(R.id.third_full_name_teacher_6);
        third_teacher_email_6 = rootView.findViewById(R.id.third_teacher_email_6);
        thirdLesson7 = rootView.findViewById(R.id.third_lesson_7);
        third_full_name_teacher_7 = rootView.findViewById(R.id.third_full_name_teacher_7);
        third_teacher_email_7 = rootView.findViewById(R.id.third_teacher_email_7);

        fourthLesson1 = rootView.findViewById(R.id.fourth_lesson_1);
        fourth_full_name_teacher_1 = rootView.findViewById(R.id.fourth_full_name_teacher_1);
        fourth_teacher_email_1 = rootView.findViewById(R.id.fourth_teacher_email_1);
        fourthLesson2 = rootView.findViewById(R.id.fourth_lesson_2);
        fourth_full_name_teacher_2 = rootView.findViewById(R.id.fourth_full_name_teacher_2);
        fourth_teacher_email_2 = rootView.findViewById(R.id.fourth_teacher_email_2);
        fourthLesson3 = rootView.findViewById(R.id.fourth_lesson_3);
        fourth_full_name_teacher_3 = rootView.findViewById(R.id.fourth_full_name_teacher_3);
        fourth_teacher_email_3 = rootView.findViewById(R.id.fourth_teacher_email_3);
        fourthLesson4 = rootView.findViewById(R.id.fourth_lesson_4);
        fourth_full_name_teacher_4 = rootView.findViewById(R.id.fourth_full_name_teacher_4);
        fourth_teacher_email_4 = rootView.findViewById(R.id.fourth_teacher_email_4);
        fourthLesson5 = rootView.findViewById(R.id.fourth_lesson_5);
        fourth_full_name_teacher_5 = rootView.findViewById(R.id.fourth_full_name_teacher_5);
        fourth_teacher_email_5 = rootView.findViewById(R.id.fourth_teacher_email_5);
        fourthLesson6 = rootView.findViewById(R.id.fourth_lesson_6);
        fourth_full_name_teacher_6 = rootView.findViewById(R.id.fourth_full_name_teacher_6);
        fourth_teacher_email_6 = rootView.findViewById(R.id.fourth_teacher_email_6);
        fourthLesson7 = rootView.findViewById(R.id.fourth_lesson_7);
        fourth_full_name_teacher_7 = rootView.findViewById(R.id.fourth_full_name_teacher_7);
        fourth_teacher_email_7 = rootView.findViewById(R.id.fourth_teacher_email_7);

        fifthLesson1 = rootView.findViewById(R.id.fifth_lesson_1);
        fifth_full_name_teacher_1 = rootView.findViewById(R.id.fifth_full_name_teacher_1);
        fifth_teacher_email_1 = rootView.findViewById(R.id.fifth_teacher_email_1);
        fifthLesson2 = rootView.findViewById(R.id.fifth_lesson_2);
        fifth_full_name_teacher_2 = rootView.findViewById(R.id.fifth_full_name_teacher_2);
        fifth_teacher_email_2 = rootView.findViewById(R.id.fifth_teacher_email_2);
        fifthLesson3 = rootView.findViewById(R.id.fifth_lesson_3);
        fifth_full_name_teacher_3 = rootView.findViewById(R.id.fifth_full_name_teacher_3);
        fifth_teacher_email_3 = rootView.findViewById(R.id.fifth_teacher_email_3);
        fifthLesson4 = rootView.findViewById(R.id.fifth_lesson_4);
        fifth_full_name_teacher_4 = rootView.findViewById(R.id.fifth_full_name_teacher_4);
        fifth_teacher_email_4 = rootView.findViewById(R.id.fifth_teacher_email_4);
        fifthLesson5 = rootView.findViewById(R.id.fifth_lesson_5);
        fifth_full_name_teacher_5 = rootView.findViewById(R.id.fifth_full_name_teacher_5);
        fifth_teacher_email_5 = rootView.findViewById(R.id.fifth_teacher_email_5);
        fifthLesson6 = rootView.findViewById(R.id.fifth_lesson_6);
        fifth_full_name_teacher_6 = rootView.findViewById(R.id.fifth_full_name_teacher_6);
        fifth_teacher_email_6 = rootView.findViewById(R.id.fifth_teacher_email_6);
        fifthLesson7 = rootView.findViewById(R.id.fifth_lesson_7);
        fifth_full_name_teacher_7 = rootView.findViewById(R.id.fifth_full_name_teacher_7);
        fifth_teacher_email_7 = rootView.findViewById(R.id.fifth_teacher_email_7);

        sixthLesson1 = rootView.findViewById(R.id.sixth_lesson_1);
        sixth_full_name_teacher_1 = rootView.findViewById(R.id.sixth_full_name_teacher_1);
        sixth_teacher_email_1 = rootView.findViewById(R.id.sixth_teacher_email_1);
        sixthLesson2 = rootView.findViewById(R.id.sixth_lesson_2);
        sixth_full_name_teacher_2 = rootView.findViewById(R.id.sixth_full_name_teacher_2);
        sixth_teacher_email_2 = rootView.findViewById(R.id.sixth_teacher_email_2);
        sixthLesson3 = rootView.findViewById(R.id.sixth_lesson_3);
        sixth_full_name_teacher_3 = rootView.findViewById(R.id.sixth_full_name_teacher_3);
        sixth_teacher_email_3 = rootView.findViewById(R.id.sixth_teacher_email_3);
        sixthLesson4 = rootView.findViewById(R.id.sixth_lesson_4);
        sixth_full_name_teacher_4 = rootView.findViewById(R.id.sixth_full_name_teacher_4);
        sixth_teacher_email_4 = rootView.findViewById(R.id.sixth_teacher_email_4);
        sixthLesson5 = rootView.findViewById(R.id.sixth_lesson_5);
        sixth_full_name_teacher_5 = rootView.findViewById(R.id.sixth_full_name_teacher_5);
        sixth_teacher_email_5 = rootView.findViewById(R.id.sixth_teacher_email_5);
        sixthLesson6 = rootView.findViewById(R.id.sixth_lesson_6);
        sixth_full_name_teacher_6 = rootView.findViewById(R.id.sixth_full_name_teacher_6);
        sixth_teacher_email_6 = rootView.findViewById(R.id.sixth_teacher_email_6);
        sixthLesson7 = rootView.findViewById(R.id.sixth_lesson_7);
        sixth_full_name_teacher_7 = rootView.findViewById(R.id.sixth_full_name_teacher_7);
        sixth_teacher_email_7 = rootView.findViewById(R.id.sixth_teacher_email_7);

        seventhLesson1 = rootView.findViewById(R.id.seventh_lesson_1);
        seventh_full_name_teacher_1 = rootView.findViewById(R.id.seventh_full_name_teacher_1);
        seventh_teacher_email_1 = rootView.findViewById(R.id.seventh_teacher_email_1);
        seventhLesson2 = rootView.findViewById(R.id.seventh_lesson_2);
        seventh_full_name_teacher_2 = rootView.findViewById(R.id.seventh_full_name_teacher_2);
        seventh_teacher_email_2 = rootView.findViewById(R.id.seventh_teacher_email_2);
        seventhLesson3 = rootView.findViewById(R.id.seventh_lesson_3);
        seventh_full_name_teacher_3 = rootView.findViewById(R.id.seventh_full_name_teacher_3);
        seventh_teacher_email_3 = rootView.findViewById(R.id.seventh_teacher_email_3);
        seventhLesson4 = rootView.findViewById(R.id.seventh_lesson_4);
        seventh_full_name_teacher_4 = rootView.findViewById(R.id.seventh_full_name_teacher_4);
        seventh_teacher_email_4 = rootView.findViewById(R.id.seventh_teacher_email_4);
        seventhLesson5 = rootView.findViewById(R.id.seventh_lesson_5);
        seventh_full_name_teacher_5 = rootView.findViewById(R.id.seventh_full_name_teacher_5);
        seventh_teacher_email_5 = rootView.findViewById(R.id.seventh_teacher_email_5);
        seventhLesson6 = rootView.findViewById(R.id.seventh_lesson_6);
        seventh_full_name_teacher_6 = rootView.findViewById(R.id.seventh_full_name_teacher_6);
        seventh_teacher_email_6 = rootView.findViewById(R.id.seventh_teacher_email_6);
        seventhLesson7 = rootView.findViewById(R.id.seventh_lesson_7);
        seventh_full_name_teacher_7 = rootView.findViewById(R.id.seventh_full_name_teacher_7);
        seventh_teacher_email_7 = rootView.findViewById(R.id.seventh_teacher_email_7);

        eighthLesson1 = rootView.findViewById(R.id.eighth_lesson_1);
        eighth_full_name_teacher_1 = rootView.findViewById(R.id.eighth_full_name_teacher_1);
        eighth_teacher_email_1 = rootView.findViewById(R.id.eighth_teacher_email_1);
        eighthLesson2 = rootView.findViewById(R.id.eighth_lesson_2);
        eighth_full_name_teacher_2 = rootView.findViewById(R.id.eighth_full_name_teacher_2);
        eighth_teacher_email_2 = rootView.findViewById(R.id.eighth_teacher_email_2);
        eighthLesson3 = rootView.findViewById(R.id.eighth_lesson_3);
        eighth_full_name_teacher_3 = rootView.findViewById(R.id.eighth_full_name_teacher_3);
        eighth_teacher_email_3 = rootView.findViewById(R.id.eighth_teacher_email_3);
        eighthLesson4 = rootView.findViewById(R.id.eighth_lesson_4);
        eighth_full_name_teacher_4 = rootView.findViewById(R.id.eighth_full_name_teacher_4);
        eighth_teacher_email_4 = rootView.findViewById(R.id.eighth_teacher_email_4);
        eighthLesson5 = rootView.findViewById(R.id.eighth_lesson_5);
        eighth_full_name_teacher_5 = rootView.findViewById(R.id.eighth_full_name_teacher_5);
        eighth_teacher_email_5 = rootView.findViewById(R.id.eighth_teacher_email_5);
        eighthLesson6 = rootView.findViewById(R.id.eighth_lesson_6);
        eighth_full_name_teacher_6 = rootView.findViewById(R.id.eighth_full_name_teacher_6);
        eighth_teacher_email_6 = rootView.findViewById(R.id.eighth_teacher_email_6);
        eighthLesson7 = rootView.findViewById(R.id.eighth_lesson_7);
        eighth_full_name_teacher_7 = rootView.findViewById(R.id.eighth_full_name_teacher_7);
        eighth_teacher_email_7 = rootView.findViewById(R.id.eighth_teacher_email_7);


    }
}