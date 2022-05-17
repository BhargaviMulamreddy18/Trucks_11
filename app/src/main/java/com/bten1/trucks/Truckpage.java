package com.bten1.trucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class Truckpage extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    MainAdapter mainAdapter;
    ArrayList<Model> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truckpage);
        Button btn_party = findViewById(R.id.party);
        Button btn_truck = findViewById(R.id.truck);
        recyclerView =findViewById(R.id.truckNo);
        database= FirebaseDatabase.getInstance().getReference("Truck_Number");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list1=new ArrayList<>();
        mainAdapter = new MainAdapter(this,list1);
        recyclerView.setAdapter(mainAdapter);
        btn_party.setOnClickListener(v -> startActivity(new Intent(Truckpage.this,AfterLoginSelectPage.class )));
        btn_truck.setOnClickListener(v -> startActivity(new Intent(Truckpage.this,Truckpage.class )));
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Model model =dataSnapshot.getValue(Model.class);
                    list1.add(model);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}