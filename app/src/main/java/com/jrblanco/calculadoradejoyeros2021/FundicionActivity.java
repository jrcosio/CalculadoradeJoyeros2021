package com.jrblanco.calculadoradejoyeros2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jrblanco.calculadoradejoyeros2021.databinding.ActivityFundicionBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FundicionActivity extends AppCompatActivity {

    private ActivityFundicionBinding binding;
    private int metalSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFundicionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.getRoot().setSubtitle("Fundición");
        setSupportActionBar(binding.toolbar.getRoot());

        this.metalSeleccionado = R.id.rbtnOro18K;
        this.calcularMetal(metalSeleccionado);

        binding.btnOKMetal.setOnClickListener(view -> this.finish());

        binding.rGrupoBtn.setOnCheckedChangeListener((group, checkedId) -> this.calcularMetal(checkedId));

        binding.editTextPesoTotal.setOnEditorActionListener((v, actionId, event) -> {
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcularMetal(metalSeleccionado);

                // Ocultar teclado virtual
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }
            return proceso;
        });

        binding.editTextPesoGoma.setOnEditorActionListener((v, actionId, event) -> {
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcularMetal(metalSeleccionado);

                // Ocultar teclado virtual
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }
            return proceso;
        });

        binding.editTextAlturaCilindro.setOnEditorActionListener((v, actionId, event) -> {
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calculaRevestimiento();
                this.calcularMetal(metalSeleccionado);
                // Ocultar teclado virtual
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }
            return proceso;

        });
    }
    private void calculaRevestimiento() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float resultRevestimiento = 0;
        float altura = this.getAlturaCilindro();
        if (altura != 0) {
            resultRevestimiento = (((altura / 2) + 10) * 100) / 39;
        }

        binding.txtResultRevestimiento.setText(df.format(resultRevestimiento));
    }

    private void calcularMetal(int metal){
        //Pesos especificos de los metales que usamos
        final float PEORO18 = 15.34f; // Oro 24k PE = 19.26f
        final float PEPLATA = 10.5f;
        final float PEBRONCE = 10.0f;
        final float PEPLATINO = 21.15f;
        float resultado, pesoTotal, pesoGoma;

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        this.metalSeleccionado = metal;

        pesoTotal = this.getPesoTotal();
        pesoGoma = this.getPesoGoma();

        if (pesoGoma > pesoTotal) {
            Toast.makeText(this, "La Goma no puede pesar más que el peso total", Toast.LENGTH_LONG).show();
            resultado = 0;
        }else {
            switch (metal){
                case R.id.rbtnOro18K:
                    if ((pesoTotal != 0) && (pesoGoma!=0)) {
                        resultado = ((pesoTotal - pesoGoma)*PEORO18)+20;
                    } else resultado = 0;
                    break;
                case R.id.rbtnPlata:
                    if ((pesoTotal != 0) && (pesoGoma!=0)) {
                        resultado = ((pesoTotal - pesoGoma)*PEPLATA)+35;
                    } else resultado = 0;
                    break;
                case R.id.rbtnBronce:
                    if ((pesoTotal != 0) && (pesoGoma!=0)) {
                        resultado = ((pesoTotal - pesoGoma)*PEBRONCE)+20;
                    } else resultado = 0;
                    break;
                case R.id.rbtnPlatino:
                    if ((pesoTotal != 0) && (pesoGoma!=0)) {
                        resultado = ((pesoTotal - pesoGoma)*PEPLATINO)+25;
                    } else resultado = 0;
                    break;
                default:
                    resultado = 0;
            }
        }
        binding.txtResultMetal.setText(df.format(resultado));

    }

    private float getPesoTotal(){
        float result;
        try {
            result = Float.parseFloat(binding.editTextPesoTotal.getText().toString());
        }catch (Exception ex) {
            result = 0;
        }
        return result;
    }
    private float getPesoGoma(){
        float result;
        try {
            result = Float.parseFloat(binding.editTextPesoGoma.getText().toString());
        } catch (Exception ex) {
            result = 0;
        }
        return result;
    }
    private  float getAlturaCilindro(){
        float result;
        try {
            result = Float.parseFloat(binding.editTextAlturaCilindro.getText().toString());
        } catch (Exception ex) {
            result = 0;
        }
        return result;
    }
}