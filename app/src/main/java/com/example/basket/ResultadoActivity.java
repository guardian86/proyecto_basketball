package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.basket.entity.Equipo;
import com.example.basket.entity.Resultado;

import org.w3c.dom.Text;

public class ResultadoActivity extends AppCompatActivity {

    private Equipo resultEquipo;
    private TextView ganador, puntuacion, estatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        ganador = findViewById(R.id.ganador);
        puntuacion = findViewById(R.id.puntuacion);
        estatus = findViewById(R.id.estatus);

        //se optiene información
        Intent inputText = getIntent();
        resultEquipo =(Equipo) inputText.getSerializableExtra("currentEquipo");
        //se valida que equipo fue el ganador
        if(resultEquipo.getResultado().getResultadoUno() > resultEquipo.getResultado().getResultadoDos())
        {
            ganador.setText(resultEquipo.getUno());
            puntuacion.setText("Puntuaciòn: " + Integer.toString(resultEquipo.getResultado().getResultadoUno()));
        }else if(resultEquipo.getResultado().getResultadoUno() == resultEquipo.getResultado().getResultadoDos())
        {
            estatus.setText("");
            ganador.setText("Hay un Empate");
            puntuacion.setText("Puntuaciòn: " + Integer.toString(resultEquipo.getResultado().getResultadoUno()));
        }else
        {
            ganador.setText(resultEquipo.getDos());
            puntuacion.setText("Puntuaciòn: " + Integer.toString(resultEquipo.getResultado().getResultadoDos()));
        }
    }

    // Reinicia el juego con los mismo equipos
    public void reiniciar (View v)
    {
        resultEquipo = new Equipo(resultEquipo.getUno(), resultEquipo.getDos(), new Resultado(0, 0));
        Intent secondActivity = new Intent(this, SecondActivity.class);
        secondActivity.putExtra("currentEquipo", resultEquipo);
        startActivity(secondActivity);
    }

    // finaliza la aplicación
    public void finish (View v)
    {
        finish();
    }



    //Acción de botón de retroceso desactivado.
    @Override public void onBackPressed() { }
}