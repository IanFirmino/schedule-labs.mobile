package com.example.fmuschedulelabs.ui.scheduled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScheduledViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ScheduledViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Visualizacao dos laboratorios agendados");
    }

    public LiveData<String> getText() {
        return mText;
    }
}