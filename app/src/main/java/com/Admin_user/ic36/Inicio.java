package com.Admin_user.ic36;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Bienvenido);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.tv_bienvenido);
        textView.setText(message);
        Snackbar Snackbar_ma_vacio = Snackbar.make(findViewById(R.id.ly_inicio), "Acceso Correcto", Snackbar.LENGTH_LONG);
        Snackbar_ma_vacio.show();
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}