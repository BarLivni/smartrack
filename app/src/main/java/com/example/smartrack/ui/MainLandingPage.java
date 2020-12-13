package com.example.smartrack.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.smartrack.R;
import com.google.android.material.navigation.NavigationView;

public class MainLandingPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Button btnLogout; //maybe add logout button
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing_page);

        Toolbar toolbar =   findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer);
        navView=findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,"open","close");
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            default:
                Toast.makeText(this,"Coming soon",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.setting) {
            Toast.makeText(this,"Setting menu is clicked",Toast.LENGTH_LONG).show();}
        return super.onOptionsItemSelected(item);
    }
}