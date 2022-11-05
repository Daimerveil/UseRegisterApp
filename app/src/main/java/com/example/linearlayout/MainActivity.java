package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, direccion, telefono, email,usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        direccion = findViewById(R.id.txtdireccion);
        telefono = findViewById(R.id.txttelefono);
        email = findViewById(R.id.txtemail);
        usuario = findViewById(R.id.txtcodusuario);
        contraseña = findViewById(R.id.txtrpass);
    }

    public void Guardar (View view){

        String nomb = nombre.getText().toString();
        String apel = apellido.getText().toString();
        String dir = direccion.getText().toString();
        String tel = telefono.getText().toString();
        String ema = email.getText().toString();
        String usu = usuario.getText().toString();
        String cont = contraseña.getText().toString();

        if(nomb.equals("")){
            nombre.setError("Usuario Vacio");
        }



    }
}