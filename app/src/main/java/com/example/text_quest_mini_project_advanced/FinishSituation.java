package com.example.text_quest_mini_project_advanced;

public class FinishSituation extends Situation {
    boolean is_win;

    public FinishSituation(String new_prologue, boolean is_it_win) {
        super(new_prologue);

        is_win = is_it_win;
    }
}
