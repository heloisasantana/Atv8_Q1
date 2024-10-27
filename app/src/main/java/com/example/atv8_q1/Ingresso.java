package com.example.atv8_q1;

public class Ingresso {
    private String codigoIdentificador;
    private float valor;

    public Ingresso(String codigoIdentificador, float valor) {
        this.codigoIdentificador = codigoIdentificador;
        this.valor = valor;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public float getValor() {
        return valor;
    }

    public float valorFinal(float taxaConveniencia) {
        return valor + taxaConveniencia;
    }
}

