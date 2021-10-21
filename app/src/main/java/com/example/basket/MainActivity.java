package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basket.entity.Equipo;
import com.example.basket.entity.Resultado;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText inputUno, inputDos;
    private TextInputLayout inputLayoutUno, inputLayoutDos;
    private Equipo currentEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutUno = findViewById(R.id.equipouno_layout);
        inputUno =  findViewById(R.id.equipoUno);
        inputLayoutDos = findViewById(R.id.equipodos_layout);
        inputDos = findViewById(R.id.equipoDos);

    }

    public  void  loadNextActivity(View view)
    {

        //validaciones
        String uno = inputUno.getText().toString().trim();
        String dos = inputDos.getText().toString().trim();

        if(uno.isEmpty())
            inputLayoutUno.setError("Equipo Uno es requerido!");
        else if(dos.isEmpty())
        {
            inputLayoutDos.setError("Equipo Dos es Requerido!");
            inputLayoutUno.setErrorEnabled(false);
        }else
        {
            //calcela los mensaje de alerta
            inputLayoutDos.setErrorEnabled(false);
            inputLayoutUno.setErrorEnabled(false);
            // se asigna la informacion a la clase
            currentEquipo = new Equipo(uno, dos, new Resultado(0,0));
            Toast.makeText(this, "Se enfrenta el equipo " + uno + " vs " + dos, Toast.LENGTH_SHORT).show();
            // se envia información a la secuanda Acivity
            Intent secondActivity = new Intent(this, SecondActivity.class);
            secondActivity.putExtra("currentEquipo", currentEquipo);
            startActivity(secondActivity);
            finish();
        }


    }
}