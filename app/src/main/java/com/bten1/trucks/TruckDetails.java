package com.bten1.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TruckDetails extends AppCompatActivity {
    Button btn_submit;
    EditText truck_no;
     FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_details);

        Button p_history = (Button) findViewById(R.id.p_history);

        p_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TruckDetails.this, PartyHistory.class));

            }
        });
        Button logout= (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(TruckDetails.this, LogIn.class));

            }
        });
        Button t_history = (Button) findViewById(R.id.t_history);

        t_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TruckDetails.this,TruckHistory.class));

            }
        });

        truck_no= findViewById(R.id.truckno1);
        mAuth = FirebaseAuth.getInstance();
        btn_submit = findViewById(R.id.submit1);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String truck_no1 = truck_no.getText().toString();
                HashMap<String, Object> m = new HashMap<>();
                m.put("Truck Number", truck_no1);
                FirebaseDatabase.getInstance().getReference().child("Truck_Number").child(truck_no1).updateChildren(m);
                startActivity(new Intent(TruckDetails.this,Mappage.class));


            }
        });

    }



}