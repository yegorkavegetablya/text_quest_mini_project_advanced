package com.example.text_quest_mini_project_advanced;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void start_game(View view) {
        Intent intent = new Intent(this, ChoiceActivity.class);
        startActivity(intent);
    }

    public void give_info(View view) {
        Intent intent = new Intent(this, InformationActivity.class);
        startActivity(intent);
    }

    public void exit_application(View view) {
        this.finish();
    }
}