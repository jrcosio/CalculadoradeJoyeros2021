package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;


import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityCalcularOroBinding;

public class CalcularOroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCalcularOroBinding binding = ActivityCalcularOroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("Calcular Oro");
        setSupportActionBar(toolbar);

    }
}