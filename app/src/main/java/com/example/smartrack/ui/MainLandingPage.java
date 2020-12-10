package com.example.smartrack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartrack.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainLandingPage extends AppCompatActivity {
    Button btnLogout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing_page);





        btnLogout=findViewById(R.id.logoutButton);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut(); //logout
                startActivity(new Intent(getApplicationContext(),LoginPage.class)); //goto loginActivity
                finish();
            }
        });
    }




}