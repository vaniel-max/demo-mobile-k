package com.example.demomobilv4.ui.mapas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.demomobilv4.databinding.FragmentMapasBinding;
import com.example.demomobilv4.ui.mapas.MapasViewModel;

public class MapasFragment extends Fragment {

    private FragmentMapasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapasViewModel mapasViewModel =
                new ViewModelProvider(this).get(MapasViewModel.class);

        binding = FragmentMapasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMapas;
        mapasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}