package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basket.entity.Equipo;
import com.example.basket.entity.Resultado;

// se implemente el motodo de view.Ocliklistener

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView equipoUnoText, equipoDosText, puntajeUnoText, puntajeDosText;
    private Equipo resultEquipo;
    private Resultado resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_second);
        equipoUnoText = findViewById(R.id.equipoUno);
        puntajeUnoText =  findViewById(R.id.puntajeUno);
        equipoDosText = findViewById(R.id.equipoDos);
        puntajeDosText =  findViewById(R.id.puntajeDos);

        // se obtiene la información
        Intent inputText = getIntent();
        resultEquipo =(Equipo) inputText.getSerializableExtra("currentEquipo");


        // se asigna la información a los text
        equipoUnoText.setText(resultEquipo.getUno());
        equipoDosText.setText(resultEquipo.getDos());
        puntajeUnoText.setText(Integer.toString(resultEquipo.getResultado().getResultadoUno()));
        puntajeDosText.setText(Integer.toString(resultEquipo.getResultado().getResultadoDos()));

        // se obtiene los onclick de los butones
        findViewById(R.id.send_1).setOnClickListener(this);
        findViewById(R.id.send_2).setOnClickListener(this);
        findViewById(R.id.send_3).setOnClickListener(this);
        findViewById(R.id.send_s1).setOnClickListener(this);
        findViewById(R.id.send_s2).setOnClickListener(this);
        findViewById(R.id.send_s3).setOnClickListener(this);
        findViewById(R.id.send_reset).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Instancio la clase y le envio los datos actuales de los puntajes
        resultado = new Resultado(Integer.parseInt(puntajeUnoText.getText().toString()), Integer.parseInt(puntajeDosText.getText().toString()));

        // valido que punto se esta sumando
        switch (v.getId()) {
            case R.id.send_1:
                resultado.setResultadoUno(resultado.getResultadoUno() + 1);
                break;
            case R.id.send_2:
                resultado.setResultadoUno(resultado.getResultadoUno() + 2);
                break;
            case R.id.send_3:
                resultado.setResultadoUno(resultado.getResultadoUno() + 3);
                break;
            case R.id.send_s1:
                resultado.setResultadoDos(resultado.getResultadoDos() + 1);
                break;
            case R.id.send_s2:
                resultado.setResultadoDos(resultado.getResultadoDos() + 2);
                break;
            case R.id.send_s3:
                resultado.setResultadoDos(resultado.getResultadoDos() + 3);
                break;
            case R.id.send_reset:
                resultEquipo = new Equipo(resultEquipo.getUno(), resultEquipo.getDos(), new Resultado(resultado.getResultadoUno(), resultado.getResultadoDos()));
                Intent resultadoActivity = new Intent(this, ResultadoActivity.class);
                resultadoActivity.putExtra("currentEquipo", resultEquipo);
                startActivity(resultadoActivity);
                finish();
                break;
            default:
                Toast.makeText(this, "Resultado Equipo Uno" + resultado.getResultadoUno() + " Equipo Dos" + resultado.getResultadoDos(),Toast.LENGTH_SHORT).show();
        }

        // muestra la puntuación actualizada
        puntajeUnoText.setText(Integer.toString(resultado.getResultadoUno()));
        puntajeDosText.setText(Integer.toString(resultado.getResultadoDos()));
    }

    //Acción de botón de retroceso desactivado.
    @Override public void onBackPressed() { }
}