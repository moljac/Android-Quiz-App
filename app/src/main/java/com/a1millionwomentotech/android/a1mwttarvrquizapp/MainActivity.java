package com.onemillionwomentotech.android.omwttarvrquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    private RadioGroup radioQ2Group;
    private RadioButton bOneCamera, bTwoCameras, bMoreCameras;

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
         * CORRECT ANSWER: All 6 checkboxes should have been checked to get 100%.
         *Since 100 is not evenly divided by 6, the following exact values are used to score
         * and produce the corresponding toast messages:
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

    public void addListenerOnButton() {
        radioQ2Group = (RadioGroup) findViewById(R.id.radio_q2_cameras);

        gradeQuestion2(radioQ2Group);
    }

     public void gradeQuestion2 (View view) {

      //Checks if button was checked at all:
      boolean checked = ((RadioButton) view).isChecked();




      int radioQ2Selection = RadioGroup.getCheckedRadioButtonID();
      View radioQ2 = radioButton

      //Checks which radio button was clicked:
      if (oneCameraSelected) {
        //This is the correct answer! so award 100pts
        scoreQ2 = 100;
        Toast.makeText(this, "You rock! Scroll down and check out the rest of the quiz!", Toast.LENGTH_SHORT).show();
      } else {
        //either of the other wrong answers = no points
        scoreQ2 = 0;
        Toast.makeText(this, "Check out our Toolkitten repo on Github to learn this and more!", Toast.LENGTH_SHORT).show();
      }

      //Displays Question 2 score in table at the bottom of the app:
      TextView score1TextView = (TextView) findViewById(R.id.q2_score);
      score1TextView.setText("" + scoreQ2);

      }

      /*
      * * * TO DO: Create gradeQuestion3 method
      * for onClick="gradeQuestion3"
      * This method checks of user selected quiz question 3 as true or false question and
      * displays the result into android:id="@+id/q3_score as 100% or zero
      * along with a toast message.
      */

      public void gradeQuestion3 () {
      //* * * TO DO: Grade gradeQuestion3
      //scoreQ3 = 100;
      //return scoreQ3;
      }

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
      finalScore = scoreQ1;

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