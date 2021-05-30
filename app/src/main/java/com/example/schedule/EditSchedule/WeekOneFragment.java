package com.example.schedule.EditSchedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.schedule.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class WeekOneFragment extends Fragment {

    private EditText firstLesson1, first_full_name_teacher_1, first_teacher_email_1,
            firstLesson2, first_full_name_teacher_2, first_teacher_email_2,
            firstLesson3, first_full_name_teacher_3, first_teacher_email_3,
            firstLesson4, first_full_name_teacher_4, first_teacher_email_4,
            firstLesson5, first_full_name_teacher_5, first_teacher_email_5,
            firstLesson6, first_full_name_teacher_6, first_teacher_email_6,
            firstLesson7, first_full_name_teacher_7, first_teacher_email_7;

    private FloatingActionButton fab;

    private DatabaseReference userReference;
    private DatabaseReference groupReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_week_one, container, false);

        init(rootView);



        return rootView;
    }

    private void init(View rootView) {
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

    }
}