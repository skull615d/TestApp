package com.ldev.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ldev.testapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int delayMillisecond = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Thread(() -> {
            try {
                Thread.sleep(delayMillisecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            binding.progressBar.post(() -> binding.progressBar.setVisibility(View.GONE));
        }).start();
    }
}