package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityCalcularPlataBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalcularPlataActivity extends AppCompatActivity {
    private ActivityCalcularPlataBinding binding;
    private int milesimasSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalcularPlataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle("Calcular Plata");
        setSupportActionBar(toolbar);

        milesimasSeleccionada = R.id.rbtn925; //rButton por defecto.

        binding.bntOKPlata.setOnClickListener(v -> this.finish());

        binding.editPlataGramos.setOnEditorActionListener((v, actionId, event) -> { //Evento que salta cuando se da en el teclado virtual el OK
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcula(this.milesimasSeleccionada);

                // Ocultar teclado virtual
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }
            return proceso;

        });

        binding.rGrupoBtn.setOnCheckedChangeListener((group, checkedId) -> {
            this.calcula(checkedId);
        });
    }
    private void calcula(int rbtnSeleccionado) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float resultado = 0;
        this.milesimasSeleccionada = rbtnSeleccionado;

        switch (rbtnSeleccionado) {

            case R.id.rbtn950:
                resultado = this.getGramosPlata() * 0.0516f;
                break;
            case R.id.rbtn925:
                resultado = this.getGramosPlata() * 0.0800f;
                break;
            case R.id.rbtn900:
                resultado = this.getGramosPlata() * 0.1100f;
                break;
            case R.id.rbtn800:
                resultado = this.getGramosPlata() * 0.2487f;
                break;
            default:
                resultado=0;
        }
        binding.txtResultadoCobre.setText(df.format(resultado));
    }

    private float getGramosPlata(){
        return Float.parseFloat(binding.editPlataGramos.getText().toString());
    }
}