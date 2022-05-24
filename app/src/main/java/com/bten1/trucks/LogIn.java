package com.bten1.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private EditText username, password1;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username=findViewById(R.id.email);
        password1=findViewById(R.id.password);
        Button login = findViewById(R.id.btn_login);
        Button btn_signup = findViewById(R.id.btn_signup);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(v -> {
            String email= username.getText().toString().trim();
            String password=password1.getText().toString().trim();
            if(email.isEmpty())
            {
                username.setError("Email is empty");
                username.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                username.setError("Enter the valid email");
                username.requestFocus();
                return;
            }
            if(password.isEmpty())
            {
                password1.setError("Password is empty");
                password1.requestFocus();
                return;
            }
            if(password.length()<6)
            {
                password1.setError("Length of password is more than 6");
                password1.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    startActivity(new Intent(LogIn.this,Mappage.class));
                }
                else
                {
                    Toast.makeText(LogIn.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });
        });
        btn_signup.setOnClickListener(v -> startActivity(new Intent(LogIn.this,Register1.class )));
    }

}

