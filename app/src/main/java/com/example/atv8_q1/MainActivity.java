package com.example.atv8_q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextCodigo, editTextValor, editTextTaxaConveniencia, editTextFuncaoComprador;
    private RadioGroup radioGroupTipoIngresso;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextValor = findViewById(R.id.editTextValor);
        editTextTaxaConveniencia = findViewById(R.id.editTextTaxaConveniencia);
        editTextFuncaoComprador = findViewById(R.id.editTextFuncaoComprador);
        radioGroupTipoIngresso = findViewById(R.id.radioGroupTipoIngresso);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        radioGroupTipoIngresso.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioVip) {
                editTextFuncaoComprador.setVisibility(View.VISIBLE);
            } else {
                editTextFuncaoComprador.setVisibility(View.GONE);
            }
        });

        buttonCalcular.setOnClickListener(v -> calcularValorFinal());
    }

    private void calcularValorFinal() {
        String codigo = editTextCodigo.getText().toString();
        float valor = Float.parseFloat(editTextValor.getText().toString());
        float taxaConveniencia = Float.parseFloat(editTextTaxaConveniencia.getText().toString());

        int tipoSelecionado = radioGroupTipoIngresso.getCheckedRadioButtonId();
        String tipoIngresso = ((RadioButton) findViewById(tipoSelecionado)).getText().toString();

        float valorFinal = valor + taxaConveniencia;
        String resultado = getString(R.string.tipo_ingresso) + " " + tipoIngresso + "\n" +
                getString(R.string.codigo) + " " + codigo + "\n" +
                getString(R.string.valor_final) + " " + valorFinal;

        if (tipoSelecionado == R.id.radioVip) {
            valorFinal *= 1.18;
            String funcaoComprador = editTextFuncaoComprador.getText().toString();
            resultado += "\n" + getString(R.string.funcao_comprador) + " " + funcaoComprador;
        }

        resultado = getString(R.string.valor_final) + ": " + valorFinal;

        textViewResultado.setText(resultado);
    }
}
