package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, direccion, telefono, email,usuario, contraseña;
    TextView usuact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuact = findViewById(R.id.txtusuact);

        Bundle bundle = getIntent().getExtras();
        String usuatxt  = bundle.getString("usuario");
        usuact.setText(usuatxt);

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
        int usu = Integer.parseInt(usuario.getText().toString());
        String cont = contraseña.getText().toString();

        Usuario user = new Usuario(nomb, apel, dir, tel, ema, usu, cont);
        user.save();
        limpiarTexto();
        Toast.makeText(getApplicationContext(), "Usuario Guardado Con Éxito", Toast.LENGTH_LONG).show();


    }

    public void consultar(View view){
        int usu = Integer.parseInt(usuario.getText().toString());

        List<Usuario> usua = Usuario.find(Usuario.class, "usuario="+usu, null);
        if(usua.size()<=0){
            Toast.makeText(getApplicationContext(), "Usuario no existe", Toast.LENGTH_LONG).show();

        } else {
            Usuario user = usua.get(0);
            nombre.setText(user.getNombre());
            apellido.setText(user.getApellido());
            direccion.setText(user.getDireccion());
            email.setText(user.getMail());
            contraseña.setText(user.getPass());
        }


    }

    public void limpiarTexto(){
        nombre.setText("");
        apellido.setText("");
        direccion.setText("");
        telefono.setText("");
        email.setText("");
        usuario.setText("");
        contraseña.setText("");
    }

    public void eliminar(View view){
        int usu = Integer.parseInt(usuario.getText().toString());
        List<Usuario> usua = Usuario.find(Usuario.class, "usuario="+usu, null);
        if(usua.size()<=0){
            Toast.makeText(getApplicationContext(), "Usuario no existe", Toast.LENGTH_LONG).show();

        } else{
            Usuario user = usua.get(0);
            user.delete();
            limpiarTexto();
            Toast.makeText(getApplicationContext(), "Usuario Eliminado", Toast.LENGTH_LONG).show();

        }

    }

    public void actualizar(View view){
        int usu = Integer.parseInt(usuario.getText().toString());
        List<Usuario> usua = Usuario.find(Usuario.class, "usuario="+usu, null);
        if(usua.size()<=0){
            Toast.makeText(getApplicationContext(), "Usuario no existe", Toast.LENGTH_LONG).show();

        } else{
            Usuario user = usua.get(0);
            user.setNombre(nombre.getText().toString());
            user.setApellido(apellido.getText().toString());
            user.setDireccion(direccion.getText().toString());
            user.setTelefono(telefono.getText().toString());
            user.setMail(email.getText().toString());
            user.setPass(contraseña.getText().toString());
            user.save();
            limpiarTexto();
            Toast.makeText(getApplicationContext(), "Usuario Actualizado", Toast.LENGTH_LONG).show();

        }



    }

}