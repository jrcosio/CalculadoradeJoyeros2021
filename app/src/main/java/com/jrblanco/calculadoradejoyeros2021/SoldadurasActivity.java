package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivitySoldadurasBinding;

public class SoldadurasActivity extends AppCompatActivity {

    private ActivitySoldadurasBinding binding;
    private byte queFragmentEstaIniciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.queFragmentEstaIniciado = 0;
        binding = ActivitySoldadurasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.getRoot().setSubtitle("Soldaduras de Oro y Plata");
        setSupportActionBar(binding.toolbar.getRoot());

        binding.btnSoldaduraOro.setOnClickListener( view -> {
            if (this.queFragmentEstaIniciado != 1) {
                this.queFragmentEstaIniciado = 1;
                this.mostrarFragmentSoldaduras(new SoldaduraOroFragment());
            }
        });
        binding.btnSoldaduraOroClasica.setOnClickListener( view -> {
            if (this.queFragmentEstaIniciado != 2) {
                this.queFragmentEstaIniciado = 2;
                this.mostrarFragmentSoldaduras(new SoldaduraOroClasicaFragment());
            }
        });
        binding.btnSoldaduraPlata.setOnClickListener( view -> {
            if (this.queFragmentEstaIniciado != 3) {
                this.queFragmentEstaIniciado = 3;
                this.mostrarFragmentSoldaduras(new SoldaduraPlataFragment());
            }
        });

        binding.btnOkSoldaduras.setOnClickListener(v -> this.finish());

    }

    private void mostrarFragmentSoldaduras(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContenedorSoldaduras, fragment)
                .commit();
    }
}