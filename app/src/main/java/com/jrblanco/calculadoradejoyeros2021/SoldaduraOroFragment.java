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

    private FragmentSoldaduraOroBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSoldaduraOroBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }
}