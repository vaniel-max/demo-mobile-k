package com.example.demomobilv4.ui.formulario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.demomobilv4.Entity.ResultsDB;
import com.example.demomobilv4.MyDatabaseHelper;
import com.example.demomobilv4.NavMain2Activity;
import com.example.demomobilv4.R;
import com.example.demomobilv4.databinding.FragmentFormularioBinding;

import java.util.ArrayList;


public class FormularioFragment extends Fragment {

    private FragmentFormularioBinding binding;


    ArrayList<ResultsDB> listResultsDBcode;
    RecyclerView recyclerCode;
    MyDatabaseHelper myDB;
    CustomAdapter customAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_formulario, container,false);
        myDB = new MyDatabaseHelper(getContext());
        listResultsDBcode = new ArrayList<>();
        recyclerCode = vista.findViewById(R.id.recyclerLO);
        recyclerCode.setLayoutManager(new LinearLayoutManager(getContext()));
        //storeDataInArrays();
        //customAdapter = new CustomAdapter(listResultsDBcode);
        //recyclerCode.setAdapter(customAdapter);


        /*try {
            recyclerCode.setAdapter(customAdapter);
            recyclerCode.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        catch (Exception e){
            Toast.makeText(getActivity(), "Error" + e.getMessage() , Toast.LENGTH_LONG);
        }*/

        return  vista;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void storeDataInArrays(){


        //ResultsDB valores = new ResultsDB();
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getActivity(), "Vacio", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                ResultsDB obj = new ResultsDB(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                listResultsDBcode.add(obj);
                //valores.setValorResult(cursor.getString(2));
                //listResultsDBcode.add(valores);
                //descripcionList.add(cursor.getString(1));
                //valorList.add(cursor.getString(2));
            }
        }
    }
}