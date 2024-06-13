package com.mishraaditya.lifeobserver;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    int initialCounter;
    public MainViewModelFactory(int initialCounter){
        this.initialCounter=initialCounter;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(initialCounter);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
