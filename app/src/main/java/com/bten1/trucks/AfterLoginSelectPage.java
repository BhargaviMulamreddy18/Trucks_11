package com.bten1.trucks;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

public class AfterLoginSelectPage extends AppCompatActivity {

    Button btn_save;
    EditText party_name,party_rno,load_type, loading_point, unloading_point, freight_v, tons_v,advance_v,delivery_v;
    FirebaseAuth mAuth;
    FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();
    String umail=user1.getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_after_login_select_page);

        party_name=findViewById(R.id.partyname);
        party_rno=findViewById(R.id.partyrno);
        load_type = findViewById(R.id.loadtype);
        loading_point = findViewById(R.id.loadingpoint);
        unloading_point = findViewById(R.id.unloadingpoint);
        freight_v = findViewById(R.id.freight);
        tons_v = findViewById(R.id.tons);
        advance_v = findViewById(R.id.advance);
        delivery_v = findViewById(R.id.delivery);
        mAuth = FirebaseAuth.getInstance();
        btn_save = findViewById(R.id.save);
        Button btn_truck = findViewById(R.id.truck1);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = UUID.randomUUID().toString();
                String party_name_v = party_name.getText().toString();
                String party_rno_v = party_rno.getText().toString();
                String load_type_v = load_type.getText().toString();
                String loading_point_v = loading_point.getText().toString();
                String unloading_point_v = unloading_point.getText().toString();
                String freight_v_v = freight_v.getText().toString();
                String tons_v_v = tons_v.getText().toString();
                String advance_v_v = advance_v.getText().toString();
                String delivery_v_v = delivery_v.getText().toString();
                HashMap<String, Object> m = new HashMap<>();
                m.put("Load_type", load_type_v);
                m.put("loading_point", loading_point_v);
                m.put("party_name", party_name_v);
                m.put("party_phone_no", party_rno_v);
                m.put("unloading_point", unloading_point_v);
                m.put("Freight", freight_v_v);
                m.put("Tons", tons_v_v);
                m.put("advance_amt", advance_v_v);
                m.put("delivery_date", delivery_v_v);
                m.put("Email",umail);
                m.put("uid",i);
                FirebaseDatabase.getInstance().getReference().child("Party_Data").child(i).updateChildren(m);
                startActivity(new Intent(AfterLoginSelectPage.this, userlist.class));
                btn_truck.setOnClickListener(v -> startActivity(new Intent(AfterLoginSelectPage.this,userlist.class )));
            }
        });

    }

}