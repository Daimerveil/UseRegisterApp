package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    EditText usuario, clave;
    Button login, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        usuario = findViewById(R.id.txtusuario);
        clave = findViewById(R.id.txtpassword);

        login = findViewById(R.id.btnlogin);
        registrar = findViewById(R.id.btnregistrar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = usuario.getText().toString();
                String pass = clave.getText().toString();
                if (usu.equals("jac") && pass.equals("IUD")){
                    Toast.makeText(getApplicationContext() , "Bienvenido a la App", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(InicioSesion.this, MainActivity.class);
                    i.putExtra("usuario", usu);
                    i.putExtra("clave", pass);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext() , "Usuario o Contraseñas errados", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Has Pulsado Registrar", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(InicioSesion.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}