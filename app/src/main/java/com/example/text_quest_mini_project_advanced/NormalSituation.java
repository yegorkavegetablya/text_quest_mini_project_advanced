package com.example.text_quest_mini_project_advanced;

public class NormalSituation extends Situation {
    public String name;
    public String description;

    public String first_option_text;
    public String second_option_text;
    public String third_option_text;

    public Situation first_option;
    public Situation second_option;
    public Situation third_option;

    public NormalSituation(String new_name, String new_description, String new_prologue, String new_first_option_text, String new_second_option_text, String new_third_option_text) {
        super(new_prologue);

        name = new_name;
        description = new_description;
        first_option_text = new_first_option_text;
        second_option_text = new_second_option_text;
        third_option_text = new_third_option_text;
    }
}
