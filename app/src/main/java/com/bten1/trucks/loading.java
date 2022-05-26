package com.bten1.trucks;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class loading extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
    String umail=user1.getEmail();
    String Email,Freight,Load_type,Tons,uid,loading_point,unloading_point,delivery_date,party_name,party_phone_no,advance_amt;
    CollectionReference cr=db.collection("person2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);
        Email=getIntent().getStringExtra("mail");
        Load_type=getIntent().getStringExtra("load_Type");
        loading_point=getIntent().getStringExtra("loading_point");
        unloading_point=getIntent().getStringExtra("unloading_point");
        advance_amt=getIntent().getStringExtra("advance_Amount");
        Freight=getIntent().getStringExtra("freight");
        Tons=getIntent().getStringExtra("tons");
        delivery_date=getIntent().getStringExtra("delivery_Date");
        party_name=getIntent().getStringExtra("party_name");
        party_phone_no=getIntent().getStringExtra("party_phone_number");
        uid=getIntent().getStringExtra("uid");


        HashMap<String, Object> m1 = new HashMap<>();
        m1.put("load_type_t", Load_type);
        m1.put("loading_point_t", loading_point);
        m1.put("party_name_t", party_name);
        m1.put("party_phone_no_t", party_phone_no);
        m1.put("unloading_point_t", unloading_point);
        m1.put("freight_t", Freight);
        m1.put("tons_t", Tons);
        m1.put("advance_amt_t", advance_amt);
        m1.put("delivery_date_t", delivery_date);
        m1.put("mail_t",Email);
        m1.put("owner_uid",uid);
        m1.put("user_mail",umail);
       // FirebaseDatabase.getInstance().getReference().child("Party_Data").child(Email).updateChildren(m1);



        cr.add(m1).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }

        });





        db.collection("person").whereEqualTo("uid",uid).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful() && !task.getResult().isEmpty()){
                    DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                    String documentid=documentSnapshot.getId();
                    db.collection("person").document(documentid).update("fix",true).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(loading.this,"Successfully fixed",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(loading.this,"Fixing Unsuccessful",Toast.LENGTH_SHORT).show();

                        }
                    });
                    db.collection("person").document(documentid).update("fixer",umail).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(loading.this,"Successfully fixed",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(loading.this,"fixing Unsuccessful",Toast.LENGTH_SHORT).show();

                        }
                    });
                }else {
                    Toast.makeText(loading.this,"Failed",Toast.LENGTH_SHORT).show();


                }
            }
        })      ;




        startActivity(new Intent(loading.this,TruckHistory.class));
    }
}