package com.example.schedule;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.Auth.User;
import com.example.schedule.Schedule.Schedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JournalActivity extends AppCompatActivity {

    private EditText student1, student2, student3, student4, student5, student6, student7,
            student8, student9, student10, student11, student12, student13, student14,
            student15, student16, student17, student18, student19, student20, student21,
            student22, student23, student24, student25, student26, student27, student28,
            student29, student30;

    private DatabaseReference userReference;
    private DatabaseReference groupReference;
    private DatabaseReference journalReference;

    private String userId, groupId, journalId;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        init();

        userId = com.example.schedule.MainActivity.userId;
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(userId).getValue(User.class);

                groupReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        journalId = snapshot.child(user.groupId).child("journalId").getValue(String.class);

                        journalReference.child(journalId).setValue("1", "2", "3", "4");

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

    private void init() {
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");
        journalReference = FirebaseDatabase.getInstance().getReference("Journal");

        student1 = findViewById(R.id.student_1_edit_text);
        student2 = findViewById(R.id.student_2_edit_text);
        student3 = findViewById(R.id.student_3_edit_text);
        student4 = findViewById(R.id.student_4_edit_text);
        student5 = findViewById(R.id.student_5_edit_text);
        student6 = findViewById(R.id.student_6_edit_text);
        student7 = findViewById(R.id.student_7_edit_text);
        student8 = findViewById(R.id.student_8_edit_text);
        student9 = findViewById(R.id.student_9_edit_text);
        student10 = findViewById(R.id.student_10_edit_text);
        student11 = findViewById(R.id.student_11_edit_text);
        student12 = findViewById(R.id.student_12_edit_text);
        student13 = findViewById(R.id.student_13_edit_text);
        student14 = findViewById(R.id.student_14_edit_text);
        student15 = findViewById(R.id.student_15_edit_text);
        student16 = findViewById(R.id.student_16_edit_text);
        student17 = findViewById(R.id.student_17_edit_text);
        student18 = findViewById(R.id.student_18_edit_text);
        student19 = findViewById(R.id.student_19_edit_text);
        student20 = findViewById(R.id.student_20_edit_text);
        student21 = findViewById(R.id.student_21_edit_text);
        student22 = findViewById(R.id.student_22_edit_text);
        student23 = findViewById(R.id.student_23_edit_text);
        student24 = findViewById(R.id.student_24_edit_text);
        student25 = findViewById(R.id.student_25_edit_text);
        student26 = findViewById(R.id.student_26_edit_text);
        student27 = findViewById(R.id.student_27_edit_text);
        student28 = findViewById(R.id.student_28_edit_text);
        student29 = findViewById(R.id.student_29_edit_text);
        student30 = findViewById(R.id.student_30_edit_text);
    }

}