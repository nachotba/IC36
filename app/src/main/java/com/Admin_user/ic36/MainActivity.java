package com.Admin_user.ic36;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String Bienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nombre = (EditText) findViewById(R.id.EDT_Usuario);
        EditText password = (EditText) findViewById(R.id.EDT_Password);
        //String nombre_texto = nombre.getText().toString();
        Button login= (Button) findViewById(R.id.Btn_Login);
        login.setOnClickListener((v) -> {
                    String user = "admin";
                    String psw = "admin";
                   // Toast.makeText(getApplicationContext(), nombre.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (nombre.getText().toString().equals("") ){
                        //Toast.makeText(getApplicationContext(), "Campo Usuario no debe estar vacio", Toast.LENGTH_SHORT).show();
                        Snackbar Snackbar_mu_vacio = Snackbar.make(findViewById(R.id.ly_principal), "Campo Usuario no debe estar vacio", Snackbar.LENGTH_LONG);
                        Snackbar_mu_vacio.show();
                        }
                    else if (password.getText().toString().equals("") ) {
                        //Toast.makeText(getApplicationContext(), "Campo Password no debe estar vacio", Toast.LENGTH_SHORT).show();
                        Snackbar Snackbar_mp_vacio = Snackbar.make(findViewById(R.id.ly_principal), "Campo Password no debe estar vacio", Snackbar.LENGTH_LONG);
                        Snackbar_mp_vacio.show();
                    }
                    else {
                        if (nombre.getText().toString().equals(user) && password.getText().toString().equals(psw)) {
                            //Toast.makeText(getApplicationContext(), "Acceso Correcto", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(this, Inicio.class);
                            intent.putExtra(Bienvenido, "Bienvenido Admin");
                            startActivity(intent);
                        } else {
                            //Toast.makeText(getApplicationContext(), "Credenciales no correctas", Toast.LENGTH_SHORT).show();
                            Snackbar Snackbar_mc_vacio = Snackbar.make(findViewById(R.id.ly_principal), "Credenciales no correctas", Snackbar.LENGTH_LONG);
                            Snackbar_mc_vacio.show();

                        }
                    }


                }
                );
    }



}

