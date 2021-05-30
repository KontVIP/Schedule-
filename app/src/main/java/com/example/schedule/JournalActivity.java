package com.example.schedule;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.Auth.User;
import com.example.schedule.Schedule.Schedule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

    FloatingActionButton fab;

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


                        journalReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                student1.setText(snapshot.child(journalId).child("student1").getValue(String.class));
                                student2.setText(snapshot.child(journalId).child("student2").getValue(String.class));
                                student3.setText(snapshot.child(journalId).child("student3").getValue(String.class));
                                student4.setText(snapshot.child(journalId).child("student4").getValue(String.class));
                                student5.setText(snapshot.child(journalId).child("student5").getValue(String.class));
                                student6.setText(snapshot.child(journalId).child("student6").getValue(String.class));
                                student7.setText(snapshot.child(journalId).child("student7").getValue(String.class));
                                student8.setText(snapshot.child(journalId).child("student8").getValue(String.class));
                                student9.setText(snapshot.child(journalId).child("student9").getValue(String.class));
                                student10.setText(snapshot.child(journalId).child("student10").getValue(String.class));
                                student11.setText(snapshot.child(journalId).child("student11").getValue(String.class));
                                student12.setText(snapshot.child(journalId).child("student12").getValue(String.class));
                                student13.setText(snapshot.child(journalId).child("student13").getValue(String.class));
                                student14.setText(snapshot.child(journalId).child("student14").getValue(String.class));
                                student15.setText(snapshot.child(journalId).child("student15").getValue(String.class));
                                student16.setText(snapshot.child(journalId).child("student16").getValue(String.class));
                                student17.setText(snapshot.child(journalId).child("student17").getValue(String.class));
                                student18.setText(snapshot.child(journalId).child("student18").getValue(String.class));
                                student19.setText(snapshot.child(journalId).child("student19").getValue(String.class));
                                student20.setText(snapshot.child(journalId).child("student20").getValue(String.class));
                                student21.setText(snapshot.child(journalId).child("student21").getValue(String.class));
                                student22.setText(snapshot.child(journalId).child("student22").getValue(String.class));
                                student23.setText(snapshot.child(journalId).child("student23").getValue(String.class));
                                student24.setText(snapshot.child(journalId).child("student24").getValue(String.class));
                                student25.setText(snapshot.child(journalId).child("student25").getValue(String.class));
                                student26.setText(snapshot.child(journalId).child("student26").getValue(String.class));
                                student27.setText(snapshot.child(journalId).child("student27").getValue(String.class));
                                student28.setText(snapshot.child(journalId).child("student28").getValue(String.class));
                                student29.setText(snapshot.child(journalId).child("student29").getValue(String.class));
                                student30.setText(snapshot.child(journalId).child("student30").getValue(String.class));

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

                        groupReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                journalReference.child(journalId).setValue(new Journal(student1.getText().toString().trim(),
                                        student2.getText().toString().trim(),student3.getText().toString().trim(),
                                        student4.getText().toString().trim(),student5.getText().toString().trim(),
                                        student6.getText().toString().trim(),student7.getText().toString().trim(),
                                        student8.getText().toString().trim(),student9.getText().toString().trim(),
                                        student10.getText().toString().trim(),student11.getText().toString().trim(),
                                        student12.getText().toString().trim(),student13.getText().toString().trim(),
                                        student14.getText().toString().trim(),student15.getText().toString().trim(),
                                        student16.getText().toString().trim(),student17.getText().toString().trim(),
                                        student18.getText().toString().trim(),student19.getText().toString().trim(),
                                        student20.getText().toString().trim(),student21.getText().toString().trim(),
                                        student22.getText().toString().trim(),student23.getText().toString().trim(),
                                        student24.getText().toString().trim(),student25.getText().toString().trim(),
                                        student26.getText().toString().trim(),student27.getText().toString().trim(),
                                        student28.getText().toString().trim(),student29.getText().toString().trim(),
                                        student30.getText().toString().trim()));

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

    }

    private void init() {
        fab = findViewById(R.id.floating_done_button);

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