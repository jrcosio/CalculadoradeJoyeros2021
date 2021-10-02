package com.jrblanco.calculadoradejoyeros2021;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.jrblanco.calculadoradejoyeros2021.databinding.FragmentSoldaduraBaseDialogBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SoldaduraBaseDialogFragment extends DialogFragment {

    FragmentSoldaduraBaseDialogBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraBaseDialogBinding.inflate(inflater, container,false);

        binding.edittxtOroSolBase.setOnEditorActionListener((v, actionId, event) -> {
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcularMetales();

                InputMethodManager input = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }

            return proceso;
        });

        binding.btnOKSolBase.setOnClickListener( view -> this.dismiss());
        calcularMetales();
        return binding.getRoot();
    }


    private void calcularMetales() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float grOro,resultPlata,resultCobre, resultCadmio, resultZinc;

        try {
            grOro = getGramosOro();
        } catch (Exception e) {
            grOro = 0;
        }

        resultPlata = grOro * 0.054f;
        resultCobre = grOro * 0.080f;
        resultCadmio = grOro * 0.092f;
        resultZinc = grOro * 0.1f;

        binding.txtResultPlataSolBase.setText(df.format(resultPlata));
        binding.txtResultCobreSolBase.setText(df.format(resultCobre));
        binding.txtResultCadmioSolBase.setText(df.format(resultCadmio));
        binding.txtResultZincSolBase.setText(df.format(resultZinc));
    }

    private float getGramosOro(){
        return Float.parseFloat(binding.edittxtOroSolBase.getText().toString());
    }
}