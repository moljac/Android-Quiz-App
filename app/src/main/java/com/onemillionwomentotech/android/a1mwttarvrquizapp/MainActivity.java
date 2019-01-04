package com.onemillionwomentotech.android.a1mwttarvrquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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
    int scoreQ1 = 0;
    int scoreQ2 = 0;
    int scoreQ3 = 0;
    int scoreQ4 = 0;
    int finalScore = 0;

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
         *100 is not evenly divided by 6, so the following exact values are placed
         * in the score table at the bottome and a corresponding toast message:
         * if any 5 are selected: scoreQ1 = 83 & toast "You know a lot... for 5 or 6 checked.
         * if any 4 are selected scoreQ1 66 & toast "You are on the right track,..."
         * if any 3 selected scoreQ1 = 50 & toast "You are on the right track,..."
         * if any 2 selected scoreQ1 = 32 and toast "That's is correct but AR has many more..."
         * if only 1 is selected scoreQ1 = 17 and toast "That's is correct but AR has more..."
         * if none are selected scoreQ1 = 0 and toast "Hint, AR as applications in many..."
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

         // Generate a toast with the corresponding message per the score:
         if (scoreQ1 >= 82) {
         Toast.makeText(this, "You really know a lot about AR! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
         } else if (scoreQ1 >= 49) {
         Toast.makeText(this, "You are on the right track, but there's even more. Try again!", Toast.LENGTH_SHORT).show();
         } else if (scoreQ1 >= 16) {
         Toast.makeText(this, "That's is correct but AR has more applications. Try again!", Toast.LENGTH_SHORT).show();
         } else {
         Toast.makeText(this, "Hint, AR as applications in many areas. Try again!", Toast.LENGTH_SHORT).show();
         }

        //Displays Question 1 score in table at the bottom of the app:
        TextView score1TextView = (TextView) findViewById(R.id.q1_score);
        score1TextView.setText("" + scoreQ1);
    }

    /**
     *This method calculates score for question 1 based on number of checked boxes:
     * All 6 boxes are needed to get a "correct" score of 100%.
     * @return gradeQ1
     */

     public int scoreQuestion1(boolean Architecture, boolean Hospitality,
     boolean Sports, boolean Arts, boolean Teaching, boolean Medicine) {

         int gradeQ1 = 0;

         if (Architecture) {
            gradeQ1 = 17;
         }
         if (Hospitality) {
            gradeQ1 = gradeQ1 + 15;
         }
         if (Sports) {
            gradeQ1 = gradeQ1 + 18;
         }
         if (Arts) {
            gradeQ1 = gradeQ1 + 17;
         }
         if (Teaching) {
            gradeQ1 = gradeQ1 + 15;
         }
         if (Medicine) {
            gradeQ1 = gradeQ1 + 18;
         }
         return gradeQ1;
     }


     /*
      * This method checks quiz question 2 radio buttons and
      * displays the result into android:id="@+id/q2_score
      * along with a toast message to user.
      */
/*
      public void addListenerOnButton() {
          RadioGroup radioQ2Group;
          radioQ2Group = (RadioGroup) findViewById(R.id.radio_q2_cameras);
          gradeQuestion2(radioQ2Group);
      }

     public void gradeQuestion2 (View view) {

         //Checks which radio button was clicked:
         RadioButton answerOneCamera = findViewById(R.id.radioq2one);
         boolean selectedOneCamera = answerOneCamera.isChecked();

         RadioButton answerTwoCameras = findViewById(R.id.radioq2two);
         boolean selectedTwoCameras = answerTwoCameras.isChecked();

         RadioButton answer3orMoreCameras = findViewById(R.id.radioq2more);
         boolean selected3orMoreCameras = answer3orMoreCameras.isChecked();

         scoreQ2 = scoreQuestion2(selectedOneCamera, selectedTwoCameras, selected3orMoreCameras);

         //Displays Question 2 score in table at the bottom of the app:
         TextView score2TextView = (TextView) findViewById(R.id.q2_score);
         score2TextView.setText("" + scoreQ2);
     }

         public int scoreQuestion2(boolean OneCamera, boolean TwoCameras, boolean ThreeOrMoreCameras) {
            int gradeQ2 = 0;
             //This is the correct answer! so award 100pts.
            if (OneCamera){
                gradeQ2 = 100;
                Toast.makeText(this, "You rock! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
            } else if (TwoCameras){
                //answer 2 is incorrect = no points
                gradeQ2 = 0;
                Toast.makeText(this, "Close but not quite. Scroll on down to see more pictures!", Toast.LENGTH_SHORT).show();
            } else if (ThreeOrMoreCameras) {
                //answer 3 is also incorrect, give message to see repo.
                gradeQ2 = 0;
                Toast.makeText(this, "Check out our Toolkitten repo on Github to learn the answers! But first, scroll down to see more pictures!", Toast.LENGTH_SHORT).show();
            }
            return gradeQ2;
         }

*/

      /*
      * * * TO DO: Create gradeQuestion3 method
      * for onClick="gradeQuestion3"
      * This method checks of user selected quiz question 3 as true or false question and
      * displays the result into android:id="@+id/q3_score as 100% or zero
      * along with a toast message.
      */




//Q3
    public void addListenerOnButton() {
        RadioGroup radioQ3Group;
        radioQ3Group = (RadioGroup) findViewById(R.id.radio_q3_cloud_targets);
        gradeQuestion3(radioQ3Group);
    }

    public void gradeQuestion3 (View view) {

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
        int gradeQ3 = 0;
        //This is the correct answer! so award 100pts.
        if (selectedq3AsTrue){
            gradeQ3 = 100;
            Toast.makeText(this, "You rock! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
        } else {
            //answer 2 is incorrect = no points
            gradeQ3 = 0;
            Toast.makeText(this, "Close but not quite. Scroll on down to see more pictures!", Toast.LENGTH_SHORT).show();
        }
        return gradeQ3;
    }
 /*     public void gradeQuestion3 () {
      //* * * TO DO: Grade gradeQuestion3
      //scoreQ3 = 100;
      //return scoreQ3;
      }
*/
      public void qradeQuestion4 () {
      //grades and returns question 4 score
      //scoreQ4 = 100;
      //return scoreQ4;
      }

      /*
       * * * TO DO: Create gradeQuiz method
       * onClick="gradeQuiz"
       * This method checks quiz question 4 text entry
       * displays the result into android:id="@+id/q4_score
       * along with a toast message.
      */

      public void gradeQuiz () {
      //* Calculate final Quiz Score and post to table in app.
     // finalScore = scoreQ1;

      //finalScore = (scoreQ1 + gradeQuestion2() + gradeQuestion3() + qradeQuestion4()) /4 ;

      TextView score1TextView = (TextView) findViewById(R.id.final_score);
      score1TextView.setText("" + finalScore);
      }

      /*
       * * * TO DO: Create emailFeedback method
       * onClick="emailFeedback"
       * This method creates an email intent for user to email us feedback.
       */

       public void emailFeedback (View view){
        //* * * TO DO: Ask for User's Name and email address
        //* * * TO DO: Create email only intent to send message
        //* * * TO DO: send email to 19@1millionwomentotech.com
        }

    }