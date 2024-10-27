package com.example.atv8_q1;

public class IngressoVIP extends Ingresso {
    private String funcaoComprador;

    public IngressoVIP(String codigoIdentificador, float valor, String funcaoComprador) {
        super(codigoIdentificador, valor);
        this.funcaoComprador = funcaoComprador;
    }

    public String getFuncaoComprador() {
        return funcaoComprador;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        float valorBase = super.valorFinal(taxaConveniencia);
        return valorBase * 1.18f;
    }
}
