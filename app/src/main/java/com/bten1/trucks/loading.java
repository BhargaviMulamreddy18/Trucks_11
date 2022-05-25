package com.bten1.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class loading extends AppCompatActivity {

    FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
    String umail=user1.getEmail();
    String Email,Freight,Load_type,Tons,loading_point,unloading_point,delivery_date,party_name,party_phone_no,advance_amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);
        Email=getIntent().getStringExtra("Email");
        Load_type=getIntent().getStringExtra("Load_Type");
        loading_point=getIntent().getStringExtra("loading_point");
        unloading_point=getIntent().getStringExtra("unloading_point");

        Freight=getIntent().getStringExtra("Freight");
        Tons=getIntent().getStringExtra("Tons");
        delivery_date=getIntent().getStringExtra("Delivery_Date");
        party_name=getIntent().getStringExtra("party_name");
        party_phone_no=getIntent().getStringExtra("party_phone_number");
        HashMap<String, Object> m = new HashMap<>();
        m.put("Load_type",Load_type);
        m.put("loading_point", loading_point);
        m.put("party_name", party_name);
        m.put("party_phone_no", party_phone_no);
        m.put("unloading_point",unloading_point);
        m.put("Freight", Freight);
        m.put("Tons", Tons);
        m.put("Delivery date",delivery_date);
        m.put("Email",Email);
        m.put("uid",umail);

        FirebaseDatabase.getInstance().getReference().child("Party_Data").child(umail).updateChildren(m);
        startActivity(new Intent(loading.this,TruckHistory.class));
    }
}