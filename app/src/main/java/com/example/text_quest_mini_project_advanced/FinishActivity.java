package com.example.text_quest_mini_project_advanced;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Bundle arguments = getIntent().getExtras();
        String text = arguments.get("text").toString();

        TextView main_text = (TextView)findViewById(R.id.final_text_view);
        main_text.setText(text);
    }

    public void get_back_to_menu(View view) {
        this.finish();
    }
}
