package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;


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

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("Calcular Oro");
        setSupportActionBar(toolbar);

       // binding.textView16.setVisibility(View.GONE); //View.VISIBLE

        binding.btnOK.setOnClickListener(v -> this.finish());

        binding.btnAmarillo.setOnClickListener(view -> botonCalcularOro("AMARILLO"));
        binding.btnBlanco.setOnClickListener(view -> botonCalcularOro("BLANCO"));
        binding.btnRosa.setOnClickListener(view -> botonCalcularOro("ROSA"));


    }

    private void botonCalcularOro(String tipo){
        DecimalFormat df = new DecimalFormat("0.00");
       // df.setRoundingMode(RoundingMode.HALF_UP);

        float gramosOro = 0;
        try {
             gramosOro = getGramosOro();

        } catch (Exception e) {
            gramosOro = 0;
        }

        float resultPlata = 0;
        float resultCobre = 0;
        float resultPaladio = 0;
        if (tipo.equals("AMARILLO")) {
            if (binding.rbtn18K.isChecked()) {
                resultPlata = gramosOro * 0.2200f;
                resultCobre = gramosOro * 0.1133f;
                binding.cvResultPaladio.setVisibility(View.GONE);
            }
        } else if (tipo.equals("BLANCO")){
            if (binding.rbtn18K.isChecked()) {
                resultPlata = gramosOro * 0.0540f;
                resultCobre = gramosOro * 0.1318f;
                resultPaladio = gramosOro * 0.1475f;
                binding.cvResultPaladio.setVisibility(View.VISIBLE);
            }
        } else if (tipo.equals("ROSA")) {
            if (binding.rbtn18K.isChecked()) {
                resultPlata = gramosOro * 0.0670f;
                resultCobre = gramosOro * 0.2660f;
                binding.cvResultPaladio.setVisibility(View.GONE);
            }
        }


        binding.txtResultadoPlata.setText(df.format(resultPlata));
        binding.txtResultadoCobre.setText(df.format(resultCobre));
        binding.txtResultadoPaladio.setText(df.format(resultPaladio));
        binding.txtTotalAleacion.setText("Aleación TOTAL: " + df.format(gramosOro + resultPlata + resultCobre +resultPaladio) + "gr");
    }

    private float getGramosOro() {
        return Float.parseFloat(binding.editOroGramos.getText().toString());
    }

}