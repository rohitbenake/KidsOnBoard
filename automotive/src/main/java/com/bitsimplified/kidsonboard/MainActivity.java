package com.bitsimplified.kidsonboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startLBLModeBtn;
    Button stopLBLModeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startLBLModeBtn = findViewById(R.id.startLBLMode);
        stopLBLModeBtn = findViewById(R.id.stopLBLMode);
        startLBLModeBtn.setOnTouchListener(new PressAndHoldTouchListener(startLBLClickListener));
        stopLBLModeBtn.setOnTouchListener(new PressAndHoldTouchListener(stopLBLClickListener));

       // StartLBLService();
    }

    private final View.OnClickListener startLBLClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            StartLBLService();
        }
    };

    private final View.OnClickListener stopLBLClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            StopLBLService();
        }
    };

    public void StartLBLService() {
        Intent serviceIntent = new Intent(this,LBLService.class);
        //serviceIntent.putExtra() currently not sending any extra info
        startService(serviceIntent);
    }

    public void StopLBLService() {
        Intent serviceIntent = new Intent(this,LBLService.class);
        stopService(serviceIntent);
    }
}