package com.example.basket.entity;

import java.io.Serializable;

public class Resultado implements Serializable {
    private int resultadoUno;
    private int resultadoDos;

    public Resultado(int resultadoUno, int resultadoDos) {
        this.resultadoUno = resultadoUno;
        this.resultadoDos = resultadoDos;
    }

    public int getResultadoUno() {
        return resultadoUno;
    }

    public void setResultadoUno(int resultadoUno) {
        this.resultadoUno = resultadoUno;
    }

    public int getResultadoDos() {
        return resultadoDos;
    }

    public void setResultadoDos(int resultadoDos) {
        this.resultadoDos = resultadoDos;
    }
}
