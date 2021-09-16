package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityCalcularPlataBinding;

public class CalcularPlataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCalcularPlataBinding binding = ActivityCalcularPlataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("Calcular Plata");
        setSupportActionBar(toolbar);
        
    }
}