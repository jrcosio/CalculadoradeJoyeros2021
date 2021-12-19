package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivitySoldadurasBinding;

public class SoldadurasActivity extends AppCompatActivity {

    private ActivitySoldadurasBinding binding;
    private int queFragmentEstaIniciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.queFragmentEstaIniciado = 0;
        binding = ActivitySoldadurasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //binding.toolbar.getRoot().setSubtitle("Soldaduras de Oro y Plata");
       // setSupportActionBar(binding.toolbar.getRoot());

        binding.btnSoldaduraOro.setOnClickListener( view -> {
                this.mostrarFragmentSoldaduras(new SoldaduraOroFragment(),1);
        });
        binding.btnSoldaduraOroClasica.setOnClickListener( view -> {
                this.mostrarFragmentSoldaduras(new SoldaduraOroClasicaFragment(),2);
        });
        binding.btnSoldaduraPlata.setOnClickListener( view -> {
                this.mostrarFragmentSoldaduras(new SoldaduraPlataFragment(),3);
        });

        binding.btnOkSoldaduras.setOnClickListener(v -> this.finish());

    }

    private void mostrarFragmentSoldaduras(Fragment fragment, int valor){
        if (this.queFragmentEstaIniciado != valor) {
            this.queFragmentEstaIniciado = valor;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContenedorSoldaduras, fragment)
                    .commit();
        }

    }
}