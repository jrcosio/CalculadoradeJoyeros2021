package com.jrblanco.calculadoradejoyeros2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        binding.cvOro.setOnClickListener(view -> this.calcularOro());
        binding.cvPlata.setOnClickListener(view -> this.calcularPlata());
        binding.cvSoldaduras.setOnClickListener(view -> this.calcularSoldadura());
        binding.cvFundicion.setOnClickListener(view -> this.calcularFundicion());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.MenuOro) {
            this.calcularOro();
        } else if(id == R.id.MenuPlata) {
            this.calcularPlata();
        } else if(id == R.id.MenuSoldadura) {
            this.calcularSoldadura();
        } else if(id == R.id.MenuAcercade) {
            this.acercade();
        } else if(id == R.id.MenuMicrofusion) {
            this.calcularFundicion();
        }
        return true;
    }

    private void calcularOro() {
        startActivity(new Intent(this, CalcularOroActivity.class));
    }

    private void calcularPlata() {
        startActivity(new Intent(this,CalcularPlataActivity.class));
    }

    private void calcularSoldadura() { startActivity((new Intent(this,SoldadurasActivity.class))); }

    private void calcularFundicion() {
        Toast.makeText(MainActivity.this,"Fundición",Toast.LENGTH_SHORT).show();
    }

    private void acercade() {
        startActivity(new Intent(this,AcercadeActivity.class));
    }
}