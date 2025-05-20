package com.example.fmuschedulelabs.ui.scheduling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SchedulingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SchedulingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Formulario de agendamento do laboratorio");
    }

    public LiveData<String> getText() {
        return mText;
    }
}