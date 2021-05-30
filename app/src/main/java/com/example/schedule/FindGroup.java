package com.example.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.Auth.User;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FindGroup extends AppCompatActivity {

    private Button findGroupButton;
    private EditText findGroupEditText;
    private String userId;
    private DatabaseReference userReference;
    private DatabaseReference groupReference;
    private Context context = this;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);

        findGroupEditText = (EditText) findViewById(R.id.et_find_group);
        findGroupButton = (Button) findViewById(R.id.btn_apply_find_group);
        userId = MainActivity.userId;
        userReference = FirebaseDatabase.getInstance().getReference("Users");
        groupReference = FirebaseDatabase.getInstance().getReference("Groups");

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.child(userId).getValue(User.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        findGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.child(findGroupEditText.getText().toString().trim()).exists()) {
                            user.groupId = findGroupEditText.getText().toString().trim();
                            userReference.child(userId).setValue(user).onSuccessTask(new SuccessContinuation<Void, Object>() {

                                @NonNull
                                @Override
                                public Task<Object> then(@Nullable Void aVoid) throws Exception {
                                    startActivity(new Intent(context, MainActivity.class));
                                    Toast.makeText(FindGroup.this, "Долучено до групи!", Toast.LENGTH_SHORT).show();
                                    return null;
                                }
                            });

                        } else {
                            Toast.makeText(FindGroup.this, "Такої групи не існує!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}