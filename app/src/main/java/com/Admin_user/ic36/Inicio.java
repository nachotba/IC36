package com.Admin_user.ic36;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //private Toolbar toolbar;

    private SharedPreferences prefs;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Bienvenido);

        // Capture the layout's TextView and set the string as its text
        /*TextView textView = findViewById(R.id.tv_bienvenido);
        textView.setText(message);*/
        Snackbar Snackbar_ma_vacio = Snackbar.make(findViewById(R.id.ly_inicio), "Acceso Correcto", Snackbar.LENGTH_LONG);
        Snackbar_ma_vacio.show();
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.salir:
                removeSharedPreference();
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void logOut() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void removeSharedPreference() { prefs.edit().clear().apply(); }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}