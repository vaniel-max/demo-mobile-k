package com.example.demomobilv4.ui.formulario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormularioViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public FormularioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el fragment Formulario de Parametro");
    }

    public LiveData<String> getText() {
        return mText;
    }
}