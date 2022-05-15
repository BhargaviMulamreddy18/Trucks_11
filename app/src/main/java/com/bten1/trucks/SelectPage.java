package com.bten1.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);


        Button Button1 = (Button) findViewById(R.id.truckownerrbtn);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectPage.this, TruckOwnerReg.class));
            }
        });

        Button Button2 = (Button) findViewById(R.id.xbtn);

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectPage.this, PartyReg.class));
            }
        });


        Button Button3 = (Button) findViewById(R.id.transporterrbtn);

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectPage.this, TransporterReg.class));
            }
        });


    }
}