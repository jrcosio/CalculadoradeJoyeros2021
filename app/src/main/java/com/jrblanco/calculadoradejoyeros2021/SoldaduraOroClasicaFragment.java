package com.jrblanco.calculadoradejoyeros2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jrblanco.calculadoradejoyeros2021.databinding.FragmentSoldaduraOroClasicaBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class SoldaduraOroClasicaFragment extends Fragment {

    private FragmentSoldaduraOroClasicaBinding binding;
    private int tipoDeSoldaduraOro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraOroClasicaBinding.inflate(inflater,container,false);

        tipoDeSoldaduraOro = R.id.rbtnTipoSolClaFloja; //Opción por defecto de inicio
        binding.cvResultPlata.setVisibility(View.VISIBLE);
        binding.cvResultLaton.setVisibility(View.VISIBLE);
        binding.cvResultCobre.setVisibility(View.GONE);
        binding.cvResultCadmio.setVisibility(View.GONE);

        binding.editTextGrOroSolCla.setOnEditorActionListener((v, actionId, event) ->{
            boolean proceso = false;

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.calcula(tipoDeSoldaduraOro);

                InputMethodManager input = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(v.getWindowToken(), 0);
                proceso = true;
            }

            return proceso;
        });

        binding.rbtnGrTipoSolOroCla.setOnCheckedChangeListener((group, checkedId) -> calcula(checkedId));

        return binding.getRoot();
    }

    private void calcula(int tipo){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float resultPlata=0, resultCobre=0, resultLaton=0, resultCadmio=0;
        this.tipoDeSoldaduraOro = tipo;

        float gramosOro;

        try {
            gramosOro = this.getGramosOro();
        } catch (Exception exception) {
            gramosOro = 0;
        }

        switch (tipo) {
            case R.id.rbtnTipoSolClaFloja:
                resultPlata = gramosOro * 0.40f;
                resultLaton = gramosOro * 0.20f;
                binding.textTitleOroSolCla.setText("Oro de 18K (Amarillo, Rosa o Blanco) que deseas usar");
                binding.cvResultPlata.setVisibility(View.VISIBLE);
                binding.cvResultLaton.setVisibility(View.VISIBLE);
                binding.cvResultCobre.setVisibility(View.GONE);
                binding.cvResultCadmio.setVisibility(View.GONE);
                break;
            case R.id.rbtnTipoSolClaFuerte:
                resultPlata = gramosOro * 0.10f;
                resultCobre = gramosOro * 0.10f;
                resultLaton = gramosOro * 0.10f;
                binding.textTitleOroSolCla.setText("Oro de 18K (Amarillo, Rosa o Blanco) que deseas usar");
                binding.cvResultPlata.setVisibility(View.VISIBLE);
                binding.cvResultLaton.setVisibility(View.VISIBLE);
                binding.cvResultCobre.setVisibility(View.VISIBLE);
                binding.cvResultCadmio.setVisibility(View.GONE);
                break;
            case R.id.rbtnTipoSolClaMuyFloja:
                resultPlata = gramosOro * 0.10f;
                resultLaton = gramosOro * 0.16f;
                resultCadmio = gramosOro * 0.18f;
                Toast.makeText(getContext(),"ATENCIÓN: Esta Soldadura es con Oro de 24K",Toast.LENGTH_LONG).show();
                binding.textTitleOroSolCla.setText("Oro de 24K que deseas usar");
                binding.cvResultPlata.setVisibility(View.VISIBLE);
                binding.cvResultLaton.setVisibility(View.VISIBLE);
                binding.cvResultCobre.setVisibility(View.GONE);
                binding.cvResultCadmio.setVisibility(View.VISIBLE);
                break;
            default:
                resultPlata = 0.0f;
                resultCobre = 0.0f;
                resultLaton = 0.0f;
                resultCadmio = 0.0f;
                binding.cvResultPlata.setVisibility(View.GONE);
                binding.cvResultLaton.setVisibility(View.GONE);
                binding.cvResultCobre.setVisibility(View.GONE);
                binding.cvResultCadmio.setVisibility(View.GONE);
        }

        binding.txtResultPlataSolOroCla.setText(df.format(resultPlata));
        binding.txtResultCobreSolOroCla.setText(df.format(resultCobre));
        binding.txtResultLatonSolOroCla.setText(df.format(resultLaton));
        binding.txtResultCadmioSolOroCla.setText(df.format(resultCadmio));

    }

    private float getGramosOro() {
        return Float.parseFloat(binding.editTextGrOroSolCla.getText().toString());
    }
}