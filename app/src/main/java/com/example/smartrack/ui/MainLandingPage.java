package com.example.smartrack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smartrack.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainLandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing_page);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(),LoginPage.class)); //goto loginActivity
        finish();
    }
}