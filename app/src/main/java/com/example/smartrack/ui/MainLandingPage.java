package com.example.smartrack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.smartrack.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainLandingPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ImageView carImage,optionImage,settingImage,shareImage,logoutImage, rateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbarHomePage);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        //toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.home);

        findViewById(R.id.carImage).setOnClickListener(this);
        findViewById(R.id.optionImage).setOnClickListener(this);
        findViewById(R.id.settingImage).setOnClickListener(this);
        findViewById(R.id.shareImage).setOnClickListener(this);
        findViewById(R.id.logoutImage).setOnClickListener(this);
        findViewById(R.id.rateImage).setOnClickListener(this);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newDrive:
                Intent newDriveIntent = new Intent(MainLandingPage.this,NewDrivePage.class);
                startActivity(newDriveIntent);
                break;
            case R.id.supplierOptions:
                Intent supplierHomeIntent = new Intent(MainLandingPage.this,SupplierHomePage.class);
                startActivity(supplierHomeIntent);
                break;
            case R.id.setting:
                break;
            case R.id.rateApp:
                Toast.makeText(this,"5 stars",Toast.LENGTH_LONG).show();
                break;
            case R.id.shareApp:
                Toast.makeText(this,"Share",Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent loginIntent = new Intent(MainLandingPage.this,LoginPage.class);
                startActivity(loginIntent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.carImage:
                Intent intent = new Intent(MainLandingPage.this,NewDrivePage.class);
                startActivity(intent);
                break;
            case R.id.optionImage:
                Intent intent1 = new Intent(MainLandingPage.this,SupplierHomePage.class);
                startActivity(intent1);
                break;
            case R.id.settingImage:
                Toast.makeText(MainLandingPage.this,"Setting",Toast.LENGTH_LONG).show();
                break;
            case R.id.rateImage:
                Toast.makeText(MainLandingPage.this,"5 stars",Toast.LENGTH_LONG).show();
                break;
            case R.id.shareImage:
                Toast.makeText(MainLandingPage.this,"Share",Toast.LENGTH_LONG).show();
                break;
            case R.id.logoutImage:
                FirebaseAuth.getInstance().signOut();
                Intent loginIntent = new Intent(MainLandingPage.this,LoginPage.class);
                startActivity(loginIntent);
                break;
        }
    }




}