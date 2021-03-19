package com.example.text_quest_mini_project_advanced;

import android.content.Context;

import java.util.ArrayList;

public abstract class SituationWriter {

    class SituationPack {
        boolean is_normal;

        public String name;
        public String description;
        public String prologue;

        public String first_option;
        public String second_option;
        public String third_option;

        boolean is_win;

        public SituationPack(int name_id, int description_id, int prologue_id, int first_option_id, int second_option_id, int third_option_id, boolean win) {
            is_normal = name_id != 0;

            name = ((is_normal) ? (currentContext.getString(name_id)) : (""));
            description = ((is_normal) ? (currentContext.getString(description_id)) : (""));
            prologue = currentContext.getString(prologue_id);

            first_option = ((is_normal) ? (currentContext.getString(first_option_id)) : (""));
            second_option = ((is_normal) ? (currentContext.getString(second_option_id)) : (""));
            third_option = ((is_normal) ? (currentContext.getString(third_option_id)) : (""));

            is_win = win;
        }
    }

    private void fillSituationPackList() {
        if (situationPacks != null) {
            return;
        }

        situationPacks = new ArrayList<SituationPack>();

        situationPacks.add(new SituationPack(R.string.situation_name_1, R.string.situation_description_1, R.string.situation_prologue_1, R.string.situation_first_option_text_1, R.string.situation_second_option_text_1, R.string.situation_third_option_text_1, false));
        situationPacks.add(new SituationPack(R.string.situation_name_2, R.string.situation_description_2, R.string.situation_prologue_2, R.string.situation_first_option_text_2, R.string.situation_second_option_text_2, R.string.situation_third_option_text_2, false));
        situationPacks.add(new SituationPack(R.string.situation_name_3, R.string.situation_description_3, R.string.situation_prologue_3, R.string.situation_first_option_text_3, R.string.situation_second_option_text_3, R.string.situation_third_option_text_3, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_4, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_5, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_6, 0, 0, 0, false));
        situationPacks.add(new SituationPack(R.string.situation_name_7, R.string.situation_description_7, R.string.situation_prologue_7, R.string.situation_first_option_text_7, R.string.situation_second_option_text_7, R.string.situation_third_option_text_7, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_8, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_9, 0, 0, 0, true));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_10, 0, 0, 0, false));
        situationPacks.add(new SituationPack(R.string.situation_name_11, R.string.situation_description_11, R.string.situation_prologue_11, R.string.situation_first_option_text_11, R.string.situation_second_option_text_11, R.string.situation_third_option_text_11, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_12, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_13, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_14, 0, 0, 0, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_15, 0, 0, 0, true));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_16, 0, 0, 0, false));
        situationPacks.add(new SituationPack(R.string.situation_name_17, R.string.situation_description_17, R.string.situation_prologue_17, R.string.situation_first_option_text_17, R.string.situation_second_option_text_17, R.string.situation_third_option_text_17, false));
        situationPacks.add(new SituationPack(R.string.situation_name_18, R.string.situation_description_18, R.string.situation_prologue_18, R.string.situation_first_option_text_18, R.string.situation_second_option_text_18, R.string.situation_third_option_text_18, false));
        situationPacks.add(new SituationPack(0, 0, R.string.situation_prologue_19, 0, 0, 0, false));
    }

    private Context currentContext;
    int currentSituationNumber;
    static ArrayList<SituationPack> situationPacks;

    static public SituationWriter createSituationWriter(Context context, int situation_number) {
        situation_number--;

        if (situationPacks.get(situation_number).is_normal) {
            return new NormalSituationWriter(context, situation_number);
        }
        else {
            return new FinishSituationWriter(context, situation_number);
        }
    }

    SituationWriter(Context context, int situation_number) {
        currentContext = context;
        currentSituationNumber = situation_number;

        fillSituationPackList();
    }

    public abstract Situation createSituation();
}
