package com.bten1.trucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Register1 extends AppCompatActivity {
    Button sign;
    EditText username, password1,name,phone;
    FirebaseFirestore dbroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        username = findViewById(R.id.username);
        password1 = findViewById(R.id.password1);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        sign = findViewById(R.id.sign);

        dbroot=FirebaseFirestore.getInstance();

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertdata();

            }


        });
    }


    private void insertdata() {
        Map<String,String> items=new HashMap<>();
        items.put("name",name.getText().toString().trim());
        items.put("phone number",phone.getText().toString().trim());
        items.put("username",username.getText().toString().trim());

        dbroot.collection("Registrations").add(items).addOnCompleteListener(new OnCompleteListener<com.google.firebase.firestore.DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<com.google.firebase.firestore.DocumentReference> task) {
                name.setText("");
                username.setText("");
                phone.setText("");
                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }


/*

        mAuth=FirebaseAuth.getInstance();
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register1.this, LogIn.class));
                String email = username.getText().toString().trim();
                String password= password1.getText().toString().trim();
                if(email.isEmpty())
                {
                    username.setError("Email is empty");
                    username.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    username.setError("Enter the valid email address");
                    username.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    password1.setError("Enter the password");
                    password1.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    password1.setError("Length of the password should be more than 6");
                    password1.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register1.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                            String name_v = name.getText().toString();
                            String phone_v=phone.getText().toString();

                            if(name_v.isEmpty()){
                                Toast.makeText(Register1.this,"No name entered!",Toast.LENGTH_SHORT).show();
                            }
                            if(phone_v.isEmpty()){
                                Toast.makeText(Register1.this,"No ph number entered!",Toast.LENGTH_SHORT).show();
                            }
                            HashMap<String,Object> map=new HashMap<>();
                            map.put("Name",name_v);
                            map.put("phone number",phone_v);
                            map.put("email",email);
                            FirebaseDatabase.getInstance().getReference().child("Registrations").child(name_v).updateChildren(map);
                        }
                        else
                        {
                            Toast.makeText(Register1.this,"You are not Registered! Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }*/
    }

