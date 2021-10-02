package com.jrblanco.calculadoradejoyeros2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jrblanco.calculadoradejoyeros2021.databinding.FragmentSoldaduraOroBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class SoldaduraOroFragment extends Fragment {

    private FragmentSoldaduraOroBinding binding;
    private int tipoDeSoldaduraOro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraOroBinding.inflate(inflater,container,false);

        this.tipoDeSoldaduraOro = R.id.rbtnTipoSolOroMuyFloja; //Soldadura seleccionada por defecto

        binding.editTextGrOroSol.setOnEditorActionListener((v, actionId, event) -> {
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcula(tipoDeSoldaduraOro);

                InputMethodManager input = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }

            return proceso;
        });

        binding.rbtnGrupoTipoSoldadurasOro.setOnCheckedChangeListener((group, checkedId) -> calcula(checkedId));

        binding.btnSoldaduraBase.setOnClickListener(view -> {
            SoldaduraBaseDialogFragment soldaduraBaseDialogFragment = new SoldaduraBaseDialogFragment();
            soldaduraBaseDialogFragment.setCancelable(false);
            soldaduraBaseDialogFragment.show(getActivity().getSupportFragmentManager(), "Dialog");
        });

        return binding.getRoot();
    }

    private void calcula(int tipo) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float resultado = 0;
        this.tipoDeSoldaduraOro = tipo;

        float gramosOro;

        try {
            gramosOro = this.getGramosOro();
        } catch (Exception exception) {
            gramosOro = 0;
        }

        switch (tipo) {
            case R.id.rbtnTipoSolOroMuyFloja:
                resultado = gramosOro / 0.3f;
                break;
            case R.id.rbtnTipoSolOroFloja:
                resultado = gramosOro / 0.5f;
                break;
            case R.id.rbtnTipoSolOroMedia:
                resultado = gramosOro / 1.0f;
                break;
            case R.id.rbtnTipoSolOroFuerte:
                resultado = gramosOro / 3.0f;
                break;
            default:
                resultado = 0;
        }

        binding.txtResultSolBase.setText(df.format(resultado));

    }

    private float getGramosOro() {
        return Float.parseFloat(binding.editTextGrOroSol.getText().toString());
    }

}