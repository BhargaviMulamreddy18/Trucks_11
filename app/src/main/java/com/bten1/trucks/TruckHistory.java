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

public class TruckHistory extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    ArrayList<person2> person2ArrayList;
    person2Adapter person2Adapter;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    //  String currentUserId = mAuth.getCurrentUser().getUid();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String  uid = user.getUid();
    String umail=user.getEmail();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_history);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();
        recyclerView=findViewById(R.id.userList1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        person2ArrayList =new ArrayList<person2>();
        person2Adapter=new person2Adapter(TruckHistory.this,person2ArrayList);
        recyclerView.setAdapter(person2Adapter);

        getTruckData();

    }


    private void getTruckData() {
        db.collection("person2").whereEqualTo("user_mail",umail)
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
                                person2ArrayList.add(dc.getDocument().toObject(person2.class));


                            }
                            person2Adapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });

    }

}


