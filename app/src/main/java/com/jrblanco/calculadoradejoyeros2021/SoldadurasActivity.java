package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivitySoldadurasBinding;

public class SoldadurasActivity extends AppCompatActivity {

    private ActivitySoldadurasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySoldadurasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("Soldaduras de Oro y Plata");
        setSupportActionBar(toolbar);

        binding.btnSoldaduraOro.setOnClickListener( view -> this.mostrarFragmentSoldaduras(new SoldaduraOroFragment()));
        binding.btnSoldaduraPlata.setOnClickListener( view -> this.mostrarFragmentSoldaduras(new SoldaduraPlataFragment()));
        binding.btnOkSoldaduras.setOnClickListener(v -> this.finish());

    }

    private void mostrarFragmentSoldaduras(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContenedorSoldaduras, fragment)
                .commit();
    }
}