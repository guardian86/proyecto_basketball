package com.example.basket.entity;

import java.io.Serializable;

public class Equipo implements Serializable {
    private String uno;
    private String dos;
    private Resultado resultado;

    public Equipo(String uno, String dos, Resultado resultado) {
        this.uno = uno;
        this.dos = dos;
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }
}
