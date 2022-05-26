package com.bten1.trucks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayList<person> personArrayList;
    personAdapter personAdapter;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    DatabaseReference mbase;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);


        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();

        recyclerView=findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personArrayList =new ArrayList<person>();
        personAdapter =new personAdapter(userlist.this,personArrayList);
        recyclerView.setAdapter(personAdapter);
        personAdapter.setOnItemClickListener(new personAdapter.onItemClickListener() {




            @Override
            public void onDeleteClick(int position) {

                removeItem(position);
            }

            private void removeItem(int position) {
                if(user!=null){
                    uid1 = user.getUid();
                }
                personArrayList.remove(position);
                personAdapter.notifyItemRemoved(position);

            }
        });



/*
        recyclerView = findViewById(R.id.userList);
        mbase = FirebaseDatabase.getInstance().getReference("Party_Data");
        // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<person> options = new FirebaseRecyclerOptions.Builder<person>().setQuery(mbase, person.class).build();
        adapter = new personAdapter(options);
        recyclerView.setAdapter(adapter);

 */
        getData();






        Button btn_party = findViewById(R.id.party);

        btn_party.setOnClickListener(view -> startActivity(new Intent(userlist.this, AfterLoginSelectPage.class)));
        Button btn_history =  findViewById(R.id.history);

        btn_history.setOnClickListener(view -> startActivity(new Intent(userlist.this, TruckDetails.class)));


        Button btn_truck = findViewById(R.id.truck);


        btn_truck.setOnClickListener(view -> startActivity(new Intent(userlist.this,TruckDetails.class)));


    }



    private void getData() {
        db.collection("person").whereEqualTo("fix",false)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null){
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(DocumentChange dc :value.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED ){
                                personArrayList.add(dc.getDocument().toObject(person.class));


                            }
                            personAdapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });

    }



}