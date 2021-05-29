package com.example.schedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schedule.Auth.User;
import com.example.schedule.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fullNameTextView, emailTextView, studentTextView;
    private DatabaseReference databaseReference;
    private User user;
    private String userId;
    private Button leaveButton, addGroupButton;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(userId).getValue(User.class);
                fullNameTextView.setText(user.fullName);
                emailTextView.setText(user.email);
                studentTextView.setText(user.userType);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        leaveButton.setOnClickListener(this);
        emailTextView.setOnClickListener(this);
        addGroupButton.setOnClickListener(this);

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
                Toast.makeText(this, "Скопійовано", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_group:
                startActivity(new Intent(this, CreateGroupActivity.class));
                break;
        }
    }

    private void init() {
        studentTextView = findViewById(R.id.tv_student);
        leaveButton = findViewById(R.id.btn_leave);
        userId = Paper.book().read("UserId");
        emailTextView = findViewById(R.id.email_edit_text);
        fullNameTextView = findViewById(R.id.tv_name);
        addGroupButton = findViewById(R.id.btn_add_group);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            this.finishAffinity();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Натисніть НАЗАД ще раз для виходу", Toast.LENGTH_SHORT).show();

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