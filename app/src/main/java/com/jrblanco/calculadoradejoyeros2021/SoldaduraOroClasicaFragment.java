package com.jrblanco.calculadoradejoyeros2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jrblanco.calculadoradejoyeros2021.databinding.FragmentSoldaduraOroClasicaBinding;


public class SoldaduraOroClasicaFragment extends Fragment {

    FragmentSoldaduraOroClasicaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraOroClasicaBinding.inflate(inflater,container,false);

        
        return binding.getRoot();
    }
}