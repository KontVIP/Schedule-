package com.example.schedule;

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
    private String groupId;
    private User user;
    private EditText groupNameEditText;
    private Button createGroupButton;
    private TextView groupNameTextView,
    Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        init();

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        user = snapshot.child(Paper.book().read("UserId")).getValue(User.class);
                        createGroup(groupNameEditText.getText().toString().trim(), user.fullName);

                        groupReference.child(groupId).setValue(group).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(CreateGroupActivity.this, "Групу створено", Toast.LENGTH_SHORT).show();

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

    }

    private void init() {
        createGroupButton = findViewById(R.id.btn_apply_group);
        groupNameEditText = findViewById(R.id.et_create_group);
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");

        groupId = groupReference.push().getKey();
    }

    private void createGroup(String groupName, String student) {
        if(!groupName.isEmpty()) {
            List<String> students = new ArrayList<>();
            students.add(student);
            group = new Group(groupName, students);
        }
    }
}