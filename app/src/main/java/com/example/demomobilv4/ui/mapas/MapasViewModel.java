package com.example.demomobilv4.ui.mapas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapasViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public MapasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el fragmento Mapas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}