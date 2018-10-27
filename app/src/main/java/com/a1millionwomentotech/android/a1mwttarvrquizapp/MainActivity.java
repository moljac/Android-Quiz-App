package com.a1millionwomentotech.android.a1mwttarvrquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.onemillionwomentotech.android.omwttarvrquizapp.R;

/**
 * This quiz app demos AR and VR creations made during weeks 10 and 11 of
 * the 2018 Summer of Code program by 1MWTT:
 * https://1millionwomentotech.com/summerofcode1/
 */

public class MainActivity extends AppCompatActivity {
    int scoreQ1 = 0;
    int scoreQ2 = 0;
    int scoreQ3 = 0;
    int scoreQ4 = 0;
    int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * onClick="gradeQuestion1"
     * This method checks quiz question 1 checkboxes and
     * displays the result into android:id="@+id/q1_score
     * along with a toast message.
     */
    public void gradeQuestion1(View view) {
        displayScore(2);
    }

    private void displayScore(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
}


    /**
     * onClick="grade_question_2
     * This method checks quiz question 2 radio buttons and
     * displays the result into android:id="@+id/q2_score
     * along with a toast message.
     */

    /**
     * onClick="grade_question_3"
     * This method check quiz question 3 true or false question and
     * displays the result into android:id="@+id/q3_score
     * along with a toast message.
     */

    /**
     * onClick="grade_quiz"
     * This method checks quiz question 4 text entry
     * displays the result into android:id="@+id/q4_score
     * along with a toast message.
     */

    /**
     * onClick="email_us_feedback"
     * This method creates an email intent for user to email us feedback.
     * /
}
