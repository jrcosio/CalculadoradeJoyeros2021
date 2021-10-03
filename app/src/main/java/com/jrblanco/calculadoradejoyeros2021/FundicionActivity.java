package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityFundicionBinding;

public class FundicionActivity extends AppCompatActivity {

    private ActivityFundicionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFundicionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar.getRoot());

        
    }
}