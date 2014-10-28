//Created by Sreejith Unnikrishnan
// Java code for generating question
package com.sree.gam.pkg;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class FetchQuestion {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String[] qstToask = new String[6];
	private String[] qstasked = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
	private int count = 0;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String[] questionFetch(String table) throws SQLException{
		int num;
		String questionNum;
		Random rng = new Random();
		num = rng.nextInt(50);
		while(Arrays.binarySearch(qstasked, num) == -1){
			num = rng.nextInt(50);			
		}
		count = count + 1;
		questionNum = Integer.toString(num);
		qstasked[count-1] = questionNum;
		try{
		DatabaseFetch data = new DatabaseFetch();
		return qstToask = data.question(table, questionNum).clone();
		}
		catch(Exception ex)
		{
			System.out.println("Error in connection: "+ex.getMessage());
		}
		return qstToask;
	}
	
	

}
