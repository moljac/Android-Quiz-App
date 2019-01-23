package com.onemillionwomentotech.android.a1mwttarvrquizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.onemillionwomentotech.android.omwttarvrquizapp.R;

/**
 * This quiz app demos AR and VR creations made during weeks 10 and 11 of
 * the 2018 Summer of Code program by 1MWTT:
 * https://1millionwomentotech.com/summerofcode1/
 */

public class MainActivity extends AppCompatActivity {
    private static int scoreQ1 = 0;
    private static int scoreQ2 = 0;
    private static int scoreQ3 = 0;
    private static int scoreQ4 = 0;
    private static int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    /**
     * This method is called when the button_grade_question1 button is clicked.
     * It passes an integer value to display on line 550 (id/q1_score).
     * This method checks how many of the 6 quiz question 1 checkboxes are checked and
     * 1. displays the result as a percentage in android:id="@+id/q1_score and
     * 2. displays a corresponding message in the toast.
     */
    public void gradeQuestion1(View view) {
        /*
         * CORRECT ANSWER: All 6 checkboxes should be checked to get 100%.
         * if less than all six are selected scoreQ1 = 0
         * and toast "You are on the right track, but there's even more. Try again!"
         */

        CheckBox q1Cb1Architecture = (CheckBox) findViewById(R.id.q1_ckbox1);
        boolean selectedArchitecture = q1Cb1Architecture.isChecked();

        CheckBox q1Cb2Hospitality = (CheckBox) findViewById(R.id.q1_ckbox2);
        boolean selectedHospitality = q1Cb2Hospitality.isChecked();

        CheckBox q1Cb3Sports = (CheckBox) findViewById(R.id.q1_ckbox3);
        boolean selectedSports = q1Cb3Sports.isChecked();

        CheckBox q1Cb4Arts = (CheckBox) findViewById(R.id.q1_ckbox4);
        boolean selectedArts = q1Cb4Arts.isChecked();

        CheckBox q1Cb5Teaching = (CheckBox) findViewById(R.id.q1_ckbox5);
        boolean selectedTeaching = q1Cb5Teaching.isChecked();

        CheckBox q1Cb6Medicine = (CheckBox) findViewById(R.id.q1_ckbox6);
        boolean selectedMedicine = q1Cb6Medicine.isChecked();

        scoreQ1 = scoreQuestion1(selectedArchitecture, selectedHospitality,
                selectedSports, selectedArts,
                selectedTeaching, selectedMedicine);

        //Displays Question 1 score in table at the bottom of the app:
        TextView score1TextView = (TextView) findViewById(R.id.q1_score);
        score1TextView.setText("" + scoreQ1);
    }

    /**
     * This method calculates score for question 1 based on number of checked boxes:
     * All 6 boxes are needed to get a "correct" score of 100%.
     *
     * @return gradeQ1
     */
    public int scoreQuestion1(boolean Architecture, boolean Hospitality,
                              boolean Sports, boolean Arts, boolean Teaching, boolean Medicine) {
        if (Architecture && Hospitality && Sports && Arts && Teaching && Medicine) {
            scoreQ1 = 100;
            Toast.makeText(this, "You really know a lot about AR! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
        } else {
            scoreQ1 = 0;
            Toast.makeText(this, "You are on the right track, but there's more. Try again!", Toast.LENGTH_SHORT).show();
        }
        return scoreQ1;
    }

    /*
     * This method checks quiz question 2 responses and
     * displays the result into android:id="@+id/q2_score
     * along with a toast message to user.
     */
    public void gradeQuestion2(View view) {
        //Checks which radio button was clicked:
        CheckBox answerOneCamera = (CheckBox) findViewById(R.id.q2_ckbox1);
        boolean selectedOneCamera = answerOneCamera.isChecked();

        CheckBox answerTwoCameras = (CheckBox) findViewById(R.id.q2_ckbox2);
        boolean selectedTwoCameras = answerTwoCameras.isChecked();

        CheckBox answer3orMoreCameras = (CheckBox) findViewById(R.id.q2_ckbox3);
        boolean selected3orMoreCameras = answer3orMoreCameras.isChecked();

        scoreQ2 = scoreQuestion2(selectedOneCamera, selectedTwoCameras,
                selected3orMoreCameras);

        //Displays Question 2 score in table at the bottom of the app:
        TextView score2TextView = (TextView) findViewById(R.id.q2_score);
        score2TextView.setText("" + scoreQ2);
    }

    public int scoreQuestion2(boolean OneCamera, boolean TwoCameras,
                              boolean ThreeOrMoreCameras) {
        //Both answers are incorrect:
        if (TwoCameras && ThreeOrMoreCameras) {
            scoreQ2 = 0;
            Toast.makeText(this, "Check out our Toolkitten repo on Github to learn about AR, VR & more! But first, scroll down to see more pictures!", Toast.LENGTH_SHORT).show();
        } else if (TwoCameras || ThreeOrMoreCameras) {
            //answer 2 is incorrect = no points
            scoreQ2 = 0;
            Toast.makeText(this, "Close but not quite. Scroll on down to see more pictures!", Toast.LENGTH_SHORT).show();
        } else if (OneCamera) {
            //OneCamera is correct, so award 100 points and display congrats toast.
            scoreQ2 = 100;
            Toast.makeText(this, "You rock! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
        }
        return scoreQ2;
    }


    /*
     * This method is called when Q3 Submit button is clicked onClick="gradeQuestion3"
     * This method checks of user selected quiz question 3 as true or false question and
     * displays the result into android:id="@+id/q3_score as 100% or zero
     * along with a toast message.
     */

    public void addListenerOnButton() {
        RadioGroup radioQ3Group;
        radioQ3Group = (RadioGroup) findViewById(R.id.radio_q3_cloud_targets);
        gradeQuestion3(radioQ3Group);
    }

    public void gradeQuestion3(View view) {

        //Checks if True radio button was clicked:
        RadioButton q3True = findViewById(R.id.radioq3true);
        boolean selectedq3AsTrue = q3True.isChecked();

        //Checks if False radio button was clicked:
        RadioButton q3False = findViewById(R.id.radioq3false);
        boolean selectedq3AsFalse = q3False.isChecked();

        scoreQ3 = scoreQuestion3(selectedq3AsTrue, selectedq3AsFalse);

        //Displays Question 2 score in table at the bottom of the app:
        TextView score3TextView = (TextView) findViewById(R.id.q3_score);
        score3TextView.setText("" + scoreQ3);
    }

    public int scoreQuestion3(boolean selectedq3AsTrue, boolean selectedq3AsFalse) {
        //This is the correct answer! so award 100pts.
        if (selectedq3AsTrue) {
            scoreQ3 = 100;
            Toast.makeText(this, "You rock! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
        } else if (selectedq3AsFalse){
            scoreQ3 = 0;
            Toast.makeText(this, "Sorry that is not the correct answer. See our Toolkitten repo to learn more.", Toast.LENGTH_SHORT).show();
        } else {
            //answer 2 is incorrect = no points
            scoreQ3 = 0;
            Toast.makeText(this, "Please select an answer and press the Button to see your score.", Toast.LENGTH_SHORT).show();
        }
        return scoreQ3;
    }

    public void qradeQuestion4(View view) {
        //Compares contents of q4_text_answer against correct responses andreturns Question 4 score.

        EditText responseQ4 = (EditText) findViewById(R.id.q4_text_answer);
        String getQ4response = responseQ4.getText().toString();

        scoreQ4 = scoreQuestion4(getQ4response);

        //Displays Question 4 score in table at the bottom of the app:
        TextView score4TextView = (TextView) findViewById(R.id.q4_score);
        score4TextView.setText("" + scoreQ4);
    }

    public int scoreQuestion4(String q4response) {
        /*
         * This method compares quiz question 4 text entry in q4_text_answer to correct answers and
         * displays a question score result into android:id="@+id/q4_score
         * along with a question toast message.
         *
         */
        switch (q4response) {
            case "OnTriggerEnter":
                scoreQ4 = 100;
                Toast.makeText(this, "You totally rock! Scroll down and submit your feedack!", Toast.LENGTH_SHORT).show();
                break;
            case "ontriggerenter":
            case "triggerenter":
            case "ontrigger":
            case "Ontriggerenter":
            case "onTriggerenter":
            case "ontriggerEnter":
            case "OnTriggerenter":
            case "onTriggerEnter":
            case "on trigger enter":
            case "On Trigger Enter":
                scoreQ4 = 50;
                Toast.makeText(this, "Oh so close! Check your capitalization and spacing try again.", Toast.LENGTH_SHORT).show();
                break;
            default:
                scoreQ4 = 0;
                Toast.makeText(this, "See our Toolkitten repo to learn this and more! Try again!", Toast.LENGTH_SHORT).show();
        }
        return scoreQ4;
    }


    public void gradeQuiz(View view) {
        //* Calculate final Quiz Score and print quiz total in a toast.
        finalScore = (scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4) / 4;

        TextView score1TextView = (TextView) findViewById(R.id.final_score);
        score1TextView.setText("" + finalScore);
        Toast.makeText(this, "Your final score is " + finalScore + "!", Toast.LENGTH_SHORT).show();

    }

    /*
     * * * TO DO: Create emailFeedback method
     * onClick="emailFeedback"
     * This method creates an email intent for user to email us feedback.
     */

    public void emailFeedback(View view) {
        //* * * TO DO: Ask for User's Name and email address
        //Creates email only intent requesting feedback IMWTT at 19@1millionwomentotech.com
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:19@1millionwomentotech.com"));

        intent.putExtra(Intent.EXTRA_SUBJECT, "Congratulations! You quiz score was  " + finalScore);
        intent.putExtra(Intent.EXTRA_TEXT, "Please send us feedback about our app and programs!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}