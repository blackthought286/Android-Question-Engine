package com.hiphopjunkie;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FirstQuestionActivity extends Activity {

	private TextView addText;
	private RadioButton rdQuestionOne;
	private RadioButton rdQuestionTwo;
	private RadioButton rdQuestionThree;
    private RadioGroup rdGroup;
	private TextView answerBox;
    private TextView scoreBox;
	
	private Boolean check1 = false;
	private Boolean check2 = false;
	private Boolean check3 = false;


    //The variable that holds the score of the user
    //we are also converting the int to a string before we
    //place it in the current TextView
    int score = 0;
    String myScore;
	
	private Object[] ans;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_question);
		
		final Button nextButton = (Button)findViewById(R.id.next_question);
		Button answerButton = (Button)findViewById(R.id.answerQuestions);
		
		addText = (TextView)findViewById(R.id.first_question);
		answerBox = (TextView)findViewById(R.id.correctAnswer);
        scoreBox = (TextView)findViewById(R.id.score);

        //Create Radio Button Objects
		rdQuestionOne = (RadioButton)findViewById(R.id.option1);
		rdQuestionTwo = (RadioButton)findViewById(R.id.option2);
		rdQuestionThree = (RadioButton)findViewById(R.id.option3);

        rdGroup = (RadioGroup)findViewById(R.id.AnswersGroup);

        //Fill the button text
        rdQuestionOne.setText("If you are ready to play");
        rdQuestionTwo.setText("Hit the next button");
        rdQuestionThree.setText("Good Luck");




		

		nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

                //Make sure the Radio Buttons are not filled out when you go to next question
               /* if(rdQuestionOne.isChecked()){
                    rdQuestionOne.setChecked(false);
                }

                if(rdQuestionTwo.isChecked()){
                    rdQuestionTwo.setChecked(false);
                }

                if(rdQuestionThree.isChecked()){
                    rdQuestionThree.setChecked(false);
                }*/

                rdGroup.clearCheck();

				int x = QuestionNumber();
				addText.setText(GrabQuestionFromQueue(x));
				setButtonAnswers(x);

                //converting int to String so it can be shown as the score
                myScore = Integer.toString(score);
                scoreBox.setText(myScore);
				
			}

		});
		
		answerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


                if(check1 == true){
                    if(rdQuestionOne.isChecked() == true){
                        answerBox.setText("Correct");
                        score = increaseScore(score);

                    }else{
                        answerBox.setText("Wrong");
                        score = decreaseScore(score);
                    }
                }else if(check2 == true){
                    if(rdQuestionTwo.isChecked() == true){
                        answerBox.setText("Correct");
                        score = increaseScore(score);
                    }else{
                        answerBox.setText("Wrong");
                        score = decreaseScore(score);
                    }
                }else if(check3 == true){
                    if(rdQuestionThree.isChecked() == true){
                        answerBox.setText("Correct");
                        score = increaseScore(score);
                    }else{
                        answerBox.setText("Wrong");
                        score = decreaseScore(score);
                    }
                }
				
			}
		});
		
	}
	
	private String GrabQuestionFromQueue(int n){
		
		Questions question_feed = new Questions();
		return question_feed.loadQuestionsFromQueue(n);

	}
	
	private String GrabAnswer(int n){
		Questions answer_feed = new Questions();
		return answer_feed.grabAnswer(n);

	}
	
	private int QuestionNumber(){
		Random randGen = new Random();
		int n = 5;
		
		return randGen.nextInt(n);
	}

    private int increaseScore(int score){
        return score = score + 10;
    }

    private int decreaseScore(int score){
        if(score > 10){
           return score = score - 10;
        }else{
            return score = 0;
        }
    }
	
	private void setButtonAnswers(int n){
		Questions quest = new Questions();
		Random rand = new Random();
		int num = 3;
		int x = rand.nextInt(num);
		 if(x == 0){
			 rdQuestionOne.setText(GrabAnswer(n));
			 rdQuestionTwo.setText(quest.findFakeAnswer(n));
			 rdQuestionThree.setText(quest.findFakeAnswer(n + 1));
			 
			 
			 check1 = true;
			 check2 = false;
			 check3 = false;
			 
		 }else if(x == 1){
			 rdQuestionTwo.setText(GrabAnswer(n));
			 rdQuestionThree.setText(quest.findFakeAnswer(n));
			 rdQuestionOne.setText(quest.findFakeAnswer(n + 1));
			 
			 check1 = false;
			 check2 = true;
			 check3 = false;
			 
		 }else if(x == 2){
			 rdQuestionThree.setText(GrabAnswer(n));
			 rdQuestionOne.setText(quest.findFakeAnswer(n));
			 rdQuestionTwo.setText(quest.findFakeAnswer(n + 1));
			 
			 check1 = false;
			 check2 = false;
			 check3 = true;
		 }
		
	}
	
	

}
