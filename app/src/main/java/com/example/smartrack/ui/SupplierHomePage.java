package com.example.smartrack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartrack.R;

public class SupplierHomePage extends AppCompatActivity implements View.OnClickListener {

    Button btn,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_home_page);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(SupplierHomePage.this,AddVertex.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(SupplierHomePage.this,AddEdge.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(SupplierHomePage.this,MainLandingPage.class);
                startActivity(intent3);
                break;
        }



    }
}