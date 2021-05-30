package com.example.schedule;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.Auth.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Book;
import io.paperdb.Paper;

public class CreateGroupActivity extends AppCompatActivity {

    private DatabaseReference groupReference;
    private DatabaseReference userReference;
    private DatabaseReference scheduleReference;
    private String groupId, scheduleId;
    private User user;
    private EditText groupNameEditText;
    private Button createGroupButton, okButton;
    private TextView groupNameTextView, groupCodeTextView, codeInfoTextView;
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        init();

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (groupNameEditText.getText().toString().trim().isEmpty()) {
                    groupNameEditText.setError("Введіть назву групи!");
                    groupNameEditText.requestFocus();
                    return;
                }

                userReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        user = snapshot.child(Paper.book().read("UserId")).getValue(User.class);
                        createGroup(groupNameEditText.getText().toString().trim(), user.fullName);
                        group.scheduleId = scheduleId;

                        groupReference.child(groupId).setValue(group).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clip = ClipData.newPlainText("GroupCode", groupId);
                                    clipboard.setPrimaryClip(clip);

                                    groupCodeTextView.setText(groupId);

                                    groupNameTextView.setVisibility(View.GONE);
                                    groupNameEditText.setVisibility(View.GONE);
                                    createGroupButton.setVisibility(View.GONE);
                                    okButton.setVisibility(View.VISIBLE);
                                    groupCodeTextView.setVisibility(View.VISIBLE);
                                    codeInfoTextView.setVisibility(View.VISIBLE);

                                    user.groupId = groupId;
                                    userReference.child(Paper.book().read("UserId")).setValue(user);

                                } else {
                                    Toast.makeText(CreateGroupActivity.this, "Помилка!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateGroupActivity.this, MainActivity.class));
            }
        });

        groupCodeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("GroupCode", groupId);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(CreateGroupActivity.this, "Скопійовано", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {
        Paper.init(this);
        codeInfoTextView = findViewById(R.id.code_info_text_view);
        groupNameTextView = findViewById(R.id.tv_text_create);
        groupCodeTextView = findViewById(R.id.tv_create_code_group);
        okButton = findViewById(R.id.ok_button);
        createGroupButton = findViewById(R.id.btn_apply_group);
        groupNameEditText = findViewById(R.id.et_create_group);
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");
        scheduleReference = FirebaseDatabase.getInstance().getReference("Schedule");

        scheduleId = scheduleReference.push().getKey();
        groupId = groupReference.push().getKey();
    }

    private void createGroup(String groupName, String student) {

            List<String> students = new ArrayList<>();
            students.add(student);
            group = new Group(groupName, students);
    }

    @Override
    public void onBackPressed() {
    }

}