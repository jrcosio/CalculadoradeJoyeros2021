package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityCalcularOroBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalcularOroActivity extends AppCompatActivity {
    private  ActivityCalcularOroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalcularOroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.getRoot().setSubtitle("Calcular Oro");
        setSupportActionBar(binding.toolbar.getRoot());

       // binding.textView16.setVisibility(View.GONE); //View.VISIBLE

        binding.btnOK.setOnClickListener(v -> this.finish());

        binding.btnAmarillo.setOnClickListener(view -> botonCalcularOro("AMARILLO"));
        binding.btnBlanco.setOnClickListener(view -> botonCalcularOro("BLANCO"));
        binding.btnRosa.setOnClickListener(view -> botonCalcularOro("ROSA"));

    }

    private void botonCalcularOro(String tipo){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float resultPlata = 0;
        float resultCobre = 0;
        float resultPaladio = 0;
        float gramosOro = 0;
        try {
             gramosOro = getGramosOro();

        } catch (Exception e) {
            gramosOro = 0;
        }

        switch (tipo) {
            case "AMARILLO":
                if (binding.rbtn18K.isChecked()) {
                    resultPlata = gramosOro * 0.2200f;
                    resultCobre = gramosOro * 0.1133f;
                } else if (binding.rbtn14K.isChecked()) {
                    resultPlata = gramosOro * 0.4721f;
                    resultCobre = gramosOro * 0.2431f;
                } else if (binding.rbtn12K.isChecked()) {
                    resultPlata = gramosOro * 0.6600f;
                    resultCobre = gramosOro * 0.3399f;
                }
                binding.cvResultPaladio.setVisibility(View.GONE);
                break;
            case "BLANCO":
                if (binding.rbtn18K.isChecked()) {
                    resultPlata = gramosOro * 0.0540f;
                    resultCobre = gramosOro * 0.1318f;
                    resultPaladio = gramosOro * 0.1475f;
                } else if (binding.rbtn14K.isChecked()) {
                    resultPlata = gramosOro * 0.2828f;
                    resultCobre = gramosOro * 0.1159f;
                    resultPaladio = gramosOro * 0.3165f;
                } else if (binding.rbtn12K.isChecked()) {
                    resultPlata = gramosOro * 0.3954f;
                    resultCobre = gramosOro * 0.1620f;
                    resultPaladio = gramosOro * 0.3954f;
                }
                binding.cvResultPaladio.setVisibility(View.VISIBLE);
                break;
            case "ROSA":
                if (binding.rbtn18K.isChecked()) {
                    resultPlata = gramosOro * 0.1133f;
                    resultCobre = gramosOro * 0.2200f;
                } else if (binding.rbtn14K.isChecked()) {
                    resultPlata = gramosOro * 0.2431f;
                    resultCobre = gramosOro * 0.4721f;
                } else if (binding.rbtn12K.isChecked()) {
                    resultPlata = gramosOro * 0.3399f;
                    resultCobre = gramosOro * 0.6600f;
                }
                binding.cvResultPaladio.setVisibility(View.GONE);
                break;
        }


        binding.txtResultadoPlata.setText(df.format(resultPlata));
        binding.txtResultadoCobre.setText(df.format(resultCobre));
        binding.txtResultadoPaladio.setText(df.format(resultPaladio));
        binding.txtTotalAleacion.setText("Total de oro " + tipo +": " + df.format(gramosOro + resultPlata + resultCobre +resultPaladio) + "gr");
    }

    private float getGramosOro() {
        return Float.parseFloat(binding.editOroGramos.getText().toString());
    }

}