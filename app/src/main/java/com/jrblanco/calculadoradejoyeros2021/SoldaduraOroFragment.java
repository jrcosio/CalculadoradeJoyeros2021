package com.jrblanco.calculadoradejoyeros2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jrblanco.calculadoradejoyeros2021.databinding.FragmentSoldaduraOroBinding;



public class SoldaduraOroFragment extends Fragment {
    FragmentSoldaduraOroBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraOroBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

//        View view = inflater.inflate(R.layout.fragment_soldadura_oro, container, false);
//
//        TextView text = view.findViewById(R.id.textPrueba);
//        Button boton = view.findViewById(R.id.btnPrueba);
//
//        boton.setOnClickListener(v -> {
//            text.setText("Hola mundo");
//
//        });
        binding.btnPrueba.setOnClickListener(v -> {
            binding.textPrueba.setText("Hola mundo");
        });
        return view;
    }
}