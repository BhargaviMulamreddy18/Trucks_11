package com.bten1.trucks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class PartyHistory extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();


    RecyclerView recyclerView;
    ArrayList<person> personArrayList;
    person3Adapter person3Adapter;
    ProgressDialog progressDialog;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid;
    String umail=user.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_history);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();

        recyclerView=findViewById(R.id.userList3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personArrayList =new ArrayList<person>();
        person3Adapter =new person3Adapter(PartyHistory.this,personArrayList);
        recyclerView.setAdapter(person3Adapter);

        getData();
    }


    private void getData() {
        db.collection("person").whereEqualTo("mail",umail)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null){
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(com.google.firebase.firestore.DocumentChange dc :value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED ){
                                personArrayList.add(dc.getDocument().toObject(person.class));


                            }
                            person3Adapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

}

