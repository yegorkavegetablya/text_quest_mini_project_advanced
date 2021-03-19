package com.example.text_quest_mini_project_advanced;

import android.content.Context;

public class FinishSituationWriter extends SituationWriter {
    FinishSituationWriter(Context context, int situation_number) {
        super(context, situation_number);
    }

    @Override
    public Situation createSituation() {
        return new FinishSituation(
                situationPacks.get(currentSituationNumber).prologue,
                situationPacks.get(currentSituationNumber).is_win
        );
    }
}
