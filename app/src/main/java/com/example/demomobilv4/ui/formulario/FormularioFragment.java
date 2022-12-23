package com.example.demomobilv4.ui.formulario;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomobilv4.CustomAdapter;
import com.example.demomobilv4.MyDatabaseHelper;
import com.example.demomobilv4.NavMain2Activity;
import com.example.demomobilv4.R;
import com.example.demomobilv4.databinding.FragmentFormularioBinding;

import java.util.ArrayList;


public class FormularioFragment extends Fragment {

    private FragmentFormularioBinding binding;
    RecyclerView recyclerCode;
    MyDatabaseHelper myDB;
    ArrayList<String> codigoList, valorList, descripcionList;
    CustomAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.my_row_recycler,container,false);
        recyclerCode = (RecyclerView) vista.findViewById(R.id.recyclerLO);
        myDB = new MyDatabaseHelper(getActivity());
        descripcionList = new ArrayList<>();
        valorList = new ArrayList<>();
        storeDataInArrays();
        customAdapter = new CustomAdapter(getActivity(),
                codigoList,
                descripcionList,
                valorList);
        recyclerCode.setAdapter(customAdapter);
        recyclerCode.setLayoutManager(new LinearLayoutManager(getActivity()));
        return  vista;
        /*FormularioViewModel formularioViewModel = new ViewModelProvider(this).get(FormularioViewModel.class);

        binding = FragmentFormularioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerCode = getActivity().findViewById(R.id.recyclerLO);






        return root;*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getActivity(), "Vacio", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                descripcionList.add(cursor.getString(1));
                valorList.add(cursor.getString(2));
            }
        }
    }
}