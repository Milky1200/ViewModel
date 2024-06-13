package com.mishraaditya.lifeobserver;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    TextView txtCounter;
    Button btnCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Observer-Owner Design Pattern
        getLifecycle().addObserver(new MyLifecycleObserver());
        Log.d("NoOne", "Owner: onCreate");


        //Model View Design Pattern
        btnCounter=findViewById(R.id.btnCounter);
        txtCounter=findViewById(R.id.txtCounter);

        MainViewModelFactory factory=new MainViewModelFactory(6);
        myViewModel=new ViewModelProvider(this, factory).get(MyViewModel.class);
       // myViewModel=new ViewModelProvider(this).get(MyViewModel.class);

        txtCounter.setText(String.valueOf(myViewModel.counter));
    }

    public void increment(View view){
        myViewModel.increment();
        txtCounter.setText(String.valueOf(myViewModel.counter));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NoOne", "Owner: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("NoOne", "Owner: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("NoOne", "Owner: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("NoOne", "Owner: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("NoOne", "Owner: onDestroy");
    }
}