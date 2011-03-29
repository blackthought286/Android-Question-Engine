package com.hiphopjunkie;

import java.util.HashMap;
import java.util.Map;

public class Questions {
	
	private int answer_key;
	
	//Write questions that are going to be loaded into the text
	private String first_question = "Hello this is my first question";
	private String second_question = "Hello this is my second question";
	private String third_question = "Hello this is my third question";
	private String fourth_question = "Hello this is my fourth question";
	private String fifth_question = "Hello this is my fifth question";
	
	
	//These are the answers to the questions
	private String first_answer = "first answer";
	private String second_answer = "second answer";
	private String third_answer = "third answer";
	private String fourth_answer = "fourth answer";
	private String fifth_answer = "fifth answer";
	
	
	//These are fake answers to the questions
	private String fake_first_answer = "fake_first answer";
	private String fake_second_answer = "fake_second answer";
	private String fake_third_answer = "fake_third answer";
	private String fake_fourth_answer = "fake_fourth answer";
	private String fake_fifth_answer = "fake_fifth answer";
	
	
	
	public String loadQuestionsFromQueue(int select_key){
		String question;
		Map questionMap = new HashMap();
		
		questionMap.put(0, first_question);
		questionMap.put(1, second_question);
		questionMap.put(2, third_question);
		questionMap.put(3, fourth_question);
		questionMap.put(4, fifth_question);
		
		
		
		try{
			answer_key = select_key;
			question = (String)questionMap.get(select_key);
			return question;
		}catch(NumberFormatException nFE){
			return "Not a number";
		}
	}
	
	public String grabAnswer(int n){
		return findAnswer(n);
	}
	
	private String findAnswer(int num){
		String answer;
		
		Map answerMap = new HashMap();
		answerMap.put(0, first_answer);
		answerMap.put(1, second_answer);
		answerMap.put(2, third_answer);
		answerMap.put(3, fourth_answer);
		answerMap.put(4, fifth_answer);
		
		if(num < answerMap.size()){
			answer = (String)answerMap.get(num);		
			return answer;
		}else {
			answer = (String)answerMap.get(0);
			return answer;
		}
	}
	
	public String findFakeAnswer(int num){
		
		
		String answer;
		
		Map answerMap = new HashMap();
		answerMap.put(0, fake_first_answer);
		answerMap.put(1, fake_second_answer);
		answerMap.put(2, fake_third_answer);
		answerMap.put(3, fake_fourth_answer);
		answerMap.put(4, fake_fifth_answer);
		
		if(num < answerMap.size()){
			answer = (String)answerMap.get(num);		
			return answer;
		}else {
			answer = (String)answerMap.get(0);
			return answer;
		}
	}

}
