package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }


    /*
     ** checks answers and show result in toast
     */
    public void checkAnswers(View v) {
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();


        Toast toast = Toast.makeText(this, resultMessage(), Toast.LENGTH_SHORT);
        toast.show();
        reset();
    }

    public String resultMessage(){
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String result = "";
        if(score <= 100 && score >=75){
            return("Excellent, " + nameEditText.getText() + "! You have scored " + Integer.toString(score) + "% correct");

        }if(score < 75 && score >=50) {
            return("Good, " + nameEditText.getText() + "! You have scored " + Integer.toString(score) + "% correct");
        }else{
            return("You have failed, " + nameEditText.getText() + "! You have scored " + Integer.toString(score) + "% correct");
        }
    }

    public void reset(){
        score = 0;
    }


    /*
     ** checks the first question and updates score
     */
    public void checkQuestion1() {
        RadioButton radioAnswerQ1 = (RadioButton) findViewById(R.id.q1_answer_radio);
        if (radioAnswerQ1.isChecked()) {
            score += 20;
        }
    }

    /*
     ** checks the second question and updates score
     */
    public void checkQuestion2() {
        CheckBox checkAnswerQ2A1 = findViewById(R.id.q2_answer_check1);
        CheckBox checkAnswerQ2A2 = findViewById(R.id.q2_answer_check2);
        CheckBox checkAnswerQ2A3 = findViewById(R.id.q2_answer_check3);
        CheckBox checkAnswerQ2A4 = findViewById(R.id.q2_answer_check4);

        if (checkAnswerQ2A1.isChecked() && checkAnswerQ2A3.isChecked() &&
                !checkAnswerQ2A2.isChecked() && !checkAnswerQ2A4.isChecked()) {
            score += 20;
        }
    }

    /*
     ** checks the third question and updates score
     */
    public void checkQuestion3() {
        EditText editAnswerQ3 = (EditText) findViewById(R.id.q3_answer_edit);
        String input = editAnswerQ3.getText().toString();
        input = input.trim();
        input = input.toLowerCase();
        if (input.equals(getString(R.string.albert))) {
            score += 20;
        }
    }

        /*
         ** checks the fourth question and updates score
         */
        public void checkQuestion4() {
            RadioButton radioAnswerQ4 = (RadioButton) findViewById(R.id.q4_answer_radio);
            if (radioAnswerQ4.isChecked()) {
                score += 20;
            }
        }

        /*
         ** checks the fifth question and updates score
         */
        public void checkQuestion5() {
            RadioButton radioAnswerQ5 = (RadioButton) findViewById(R.id.q5_answer_radio);
            if (radioAnswerQ5.isChecked()) {
                score += 20;
            }
        }
    }
