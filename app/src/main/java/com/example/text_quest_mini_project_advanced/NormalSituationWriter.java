package com.example.text_quest_mini_project_advanced;

import android.content.Context;

import java.util.List;

public class NormalSituationWriter extends SituationWriter {
    NormalSituationWriter(Context context, int situation_number) {
        super(context, situation_number);
    }

    @Override
    public Situation createSituation() {
        return new NormalSituation(
                situationPacks.get(currentSituationNumber).name,
                situationPacks.get(currentSituationNumber).description,
                situationPacks.get(currentSituationNumber).prologue,

                situationPacks.get(currentSituationNumber).first_option,
                situationPacks.get(currentSituationNumber).second_option,
                situationPacks.get(currentSituationNumber).third_option
        );
    }
}
