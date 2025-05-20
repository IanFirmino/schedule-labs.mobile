package com.example.fmuschedulelabs.ui.labs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LabsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LabsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Visualizacao dos laboratorios disponiveis");
    }

    public LiveData<String> getText() {
        return mText;
    }
}