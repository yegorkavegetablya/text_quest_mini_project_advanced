package com.example.text_quest_mini_project_advanced;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class Game {
    public Situation current_choice;
    public Situation current_situation;

    private ArrayList<Situation> situations;

    private void fillSituation(int situation_number, int first_option_number, int second_option_number, int third_option_number) {
        System.out.println("!!! " + situation_number + " ***\n");
        ((NormalSituation)situations.get(situation_number - 1)).first_option = situations.get(first_option_number - 1);
        ((NormalSituation)situations.get(situation_number - 1)).second_option = situations.get(second_option_number - 1);
        ((NormalSituation)situations.get(situation_number - 1)).third_option = situations.get(third_option_number - 1);
    }

    public Game(Context context) {
        situations = new ArrayList<Situation>();
        NormalSituationWriter situationWriter = new NormalSituationWriter(context, 0);

        for (int current_situation_number = 1; current_situation_number <= 19; current_situation_number++) {
            situations.add(SituationWriter.createSituationWriter(context, current_situation_number).createSituation());
        }

        fillSituation(1, 2, 3, 17);
        fillSituation(2, 5, 6, 7);
        fillSituation(7, 8, 9, 10);
        fillSituation(3, 11, 12, 13);
        fillSituation(11, 14, 15, 16);
        fillSituation(17, 2, 3, 18);
        fillSituation(18, 2, 3, 19);

        current_situation = situations.get(0);
        current_choice = current_situation;
    }

    public void chosen(int number) {
        if (number == 1) {
            current_choice = ((NormalSituation)current_situation).first_option;
        }
        else if (number == 2) {
            current_choice = ((NormalSituation)current_situation).second_option;
        }
        else if (number == 3) {
            current_choice = ((NormalSituation)current_situation).third_option;
        }
        else {
            // Да не произойдёт такое))
        }
    }
}
