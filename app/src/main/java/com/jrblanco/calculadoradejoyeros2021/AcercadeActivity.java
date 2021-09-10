package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityAcercadeBinding;
import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityMainBinding;

public class AcercadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAcercadeBinding binding = ActivityAcercadeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOk.setOnClickListener(v -> this.finish());

    }
}