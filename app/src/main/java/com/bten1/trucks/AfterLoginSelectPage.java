package com.bten1.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterLoginSelectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_select_page);


        Button Button1 = (Button) findViewById(R.id.truckowneralbtn);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLoginSelectPage.this, TruckOwnerLogin.class));
            }
        });

        Button Button2 = (Button) findViewById(R.id.xalbtn);

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLoginSelectPage.this, PartyLogin.class));
            }
        });


        Button Button3 = (Button) findViewById(R.id.transporteralbtn);

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterLoginSelectPage.this, TransporterLogin.class));
            }
        });



    }
}