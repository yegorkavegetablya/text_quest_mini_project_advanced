package com.example.text_quest_mini_project_advanced;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    TextView situation_description;
    TextView situation_name;
    Button first_button;
    Button second_button;
    Button third_button;

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        situation_description = (TextView)findViewById(R.id.situation_description_text_view);
        situation_name = (TextView)findViewById(R.id.name_view);
        first_button = (Button)findViewById(R.id.first_option);
        second_button = (Button)findViewById(R.id.second_option);
        third_button = (Button)findViewById(R.id.third_option);

        game = new Game(this);

        setAllText();
    }

    public void setAllText() {
        situation_description.setText(((NormalSituation)game.current_situation).description);
        situation_name.setText(((NormalSituation)game.current_situation).name);
        first_button.setText(((NormalSituation)game.current_situation).first_option_text);
        second_button.setText(((NormalSituation)game.current_situation).second_option_text);
        third_button.setText(((NormalSituation)game.current_situation).third_option_text);
    }

    public void do_next() {
        Intent intent = new Intent(this, PrologueActivity.class);
        intent.putExtra("text", game.current_choice.prologue);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                if (game.current_choice instanceof FinishSituation) {
                    Intent intent = new Intent(this, FinishActivity.class);
                    if (((FinishSituation)game.current_choice).is_win) {
                        intent.putExtra("text", getString(R.string.win));
                    }
                    else {
                        intent.putExtra("text", getString(R.string.lose));
                    }
                    startActivityForResult(intent, 2);
                }
                else {
                    game.current_situation = game.current_choice;
                    setAllText();
                }
                break;
            case 2:
                this.finish();
        }

    }

    public void do_first_choice(View view) {
        game.chosen(1);
        do_next();
    }

    public void do_second_choice(View view) {
        game.chosen(2);
        do_next();
    }

    public void do_third_choice(View view) {
        game.chosen(3);
        do_next();
    }

    public void exit_to_menu(View view) {
        this.finish();
    }
}
