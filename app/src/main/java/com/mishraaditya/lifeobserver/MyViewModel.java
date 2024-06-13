package com.mishraaditya.lifeobserver;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    int counter=0;

    public MyViewModel(int initialCounter) {
        counter=initialCounter;
    }

    public void increment(){
         counter++;
     }
}
