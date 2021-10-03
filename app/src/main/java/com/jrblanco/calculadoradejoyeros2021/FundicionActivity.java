package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityFundicionBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FundicionActivity extends AppCompatActivity {

    private ActivityFundicionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFundicionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.getRoot().setSubtitle("Fundición");
        setSupportActionBar(binding.toolbar.getRoot());

        binding.btnOKMetal.setOnClickListener(view -> this.finish());



    }

    private void calcularMetal(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        
    }
}