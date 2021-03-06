package com.example.schedule;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.Auth.User;
import com.example.schedule.Schedule.ScheduleActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fullNameTextView, emailTextView, studentTextView, groupNameTextView;
    private DatabaseReference userReference;
    private DatabaseReference groupReference;
    private User user;
    public static String userId;
    private Button leaveButton, addGroupButton, findGroupButton, scheduleButton, markButton, journalButton;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(userId).getValue(User.class);
                fullNameTextView.setText(user.fullName);
                emailTextView.setText(user.email);
                studentTextView.setText(user.userType);
                if (!user.groupId.equals("")) {
                    scheduleButton.setVisibility(View.VISIBLE);
                    markButton.setVisibility(View.VISIBLE);
                    journalButton.setVisibility(View.VISIBLE);
                    groupReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            groupNameTextView.setText(snapshot.child(user.groupId).child("groupName").getValue(String.class));
                            if (user.userType.equals("????????????????") ) {
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                } else {
                    groupNameTextView.setText("?????? ??????????");
                    if (user.userType.equals("????????????????")) {

                        addGroupButton.setVisibility(View.VISIBLE);
                    } else {
                        findGroupButton.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        markButton.setOnClickListener(this);
        journalButton.setOnClickListener(this);
        leaveButton.setOnClickListener(this);
        emailTextView.setOnClickListener(this);
        addGroupButton.setOnClickListener(this);
        scheduleButton.setOnClickListener(this);
        findGroupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_leave:
                Paper.book().destroy();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, com.example.schedule.Auth.AuthActivity.class));
                break;
            case R.id.email_edit_text:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Email", user.email);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "??????????????????????", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_group:
                startActivity(new Intent(this, CreateGroupActivity.class));
                break;
            case R.id.btn_s??hedule:
                startActivity(new Intent(this, ScheduleActivity.class));
                break;
            case R.id.btn_mark:
                startActivity(new Intent(this, MarkActivity.class));
                break;
            case R.id.btn_journal:
                startActivity(new Intent(this, JournalActivity.class));
                break;
            case R.id.btn_find_group:
                startActivity(new Intent(this, FindGroup.class));
                break;
        }
    }

    private void init() {
        Paper.init(this);
        scheduleButton = findViewById(R.id.btn_s??hedule);
        findGroupButton = findViewById(R.id.btn_find_group);
        studentTextView = findViewById(R.id.tv_student);
        leaveButton = findViewById(R.id.btn_leave);
        userId = Paper.book().read("UserId");
        emailTextView = findViewById(R.id.email_edit_text);
        groupNameTextView = findViewById(R.id.tv_groupId);
        fullNameTextView = findViewById(R.id.tv_name);
        addGroupButton = findViewById(R.id.btn_add_group);
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");
        markButton = findViewById(R.id.btn_mark);
        journalButton = findViewById(R.id.btn_journal);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            this.finishAffinity();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "?????????????????? ?????????? ???? ?????? ?????? ????????????", Toast.LENGTH_SHORT).show();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doubleBackToExitPressedOnce = false;
            }
        };
        thread.start();

    }

}