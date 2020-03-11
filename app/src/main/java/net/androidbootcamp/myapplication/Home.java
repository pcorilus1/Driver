package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button btn_Jobs;
    Button btn_Account;
    Button btn_Complaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btn_Jobs = findViewById(R.id.btn_Jobs);
        btn_Jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(Home.this, Navigation_Vendor.class);
                startActivity(inToMain);
            }


        });

        btn_Account = findViewById(R.id.btn_Account);
        btn_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(Home.this, Vendor_Items.class);
                startActivity(inToMain);
            }


        });

        btn_Complaint = findViewById(R.id.btn_Complaint);
        btn_Complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToMain = new Intent(Home.this, Vendor_Items.class);
                startActivity(inToMain);
            }


        });





    }
}