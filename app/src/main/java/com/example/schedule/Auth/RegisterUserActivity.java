package com.example.schedule.Auth;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schedule.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import io.paperdb.Paper;

public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView bannerTextView;
    private Button registerButton;
    private ProgressBar progressBar;
    private EditText fullNameEditText, dateEditText, emailEditText, passwordEditText;
    private Spinner userSpinner;
    private String userType;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        bannerTextView = (TextView) findViewById(R.id.banner_text_view);
        bannerTextView.setOnClickListener(this);

        fullNameEditText = (EditText) findViewById(R.id.full_name_edit_text);
        dateEditText = (EditText) findViewById(R.id.date_edit_text);
        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        userSpinner = findViewById(R.id.user_spinner);
        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userType = userSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_text_view:
                startActivity(new Intent(this, AuthActivity.class));
                break;
            case R.id.register_button:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String fullName = fullNameEditText.getText().toString().trim();
        String date = dateEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(fullName.isEmpty()) {
            fullNameEditText.setError("Необхідне повне ім'я!");
            fullNameEditText.requestFocus();
            return;
        }

        if(date.isEmpty()) {
            dateEditText.setError("Необхідний вік!");
            dateEditText.requestFocus();
            return;
        }

        if(email.isEmpty()) {
            emailEditText.setError("Необхідний Email!");
            emailEditText.requestFocus();
            return;
        }

        if(!email.contains("@stud.nau.edu.ua")) {
            emailEditText.setError("Введіть НАУ email!");
            emailEditText.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            passwordEditText.setError("Необхідний пароль!");
            passwordEditText.requestFocus();
            return;
        }

        if(password.length() < 6) {
            passwordEditText.setError("Мінімальна довжина 6 символів!");
            passwordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    User user = new User(fullName, date, email, userType);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {
                                Toast.makeText(RegisterUserActivity.this, "Користувач успішно зареєстрований!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterUserActivity.this, AuthActivity.class));
                            } else {
                                Toast.makeText(RegisterUserActivity.this, "Помилка! Спробуйте ще раз!", Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });

                } else {
                    Toast.makeText(RegisterUserActivity.this, "Помилка! Спробуйте ще раз!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}








