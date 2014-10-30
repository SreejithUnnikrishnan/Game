//Created by Sreejith Unnikrishnan
// Java code for checking and showing question
package com.sree.gam.pkg;

import java.sql.SQLException;

public class Quiz {
	private String qst;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String table;
	private String[] qstFetch = new String[6];
	private int amount[] = {1000,2000,3000,5000,10000,20000,40000,80000,160000,320000,625000,1250000,2500000,5000000,10000000};
	private int userProgress = 1;
	private String selected;
	private int amountWon = 0;
	private int savedamount = 0;
	private String message;
	
	
	
	
	public String getQst() {
		return qst;
	}


	public void setQst(String qst) {
		this.qst = qst;
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


	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}


	public String getSelected() {
		return selected;
	}


	public void setSelected(String selected) {
		this.selected = selected;
	}


	public void showQuestion() throws SQLException{
		FetchQuestion qst = new FetchQuestion();
		if(userProgress <= 5){
			table = "simple_question";
			qstFetch = qst.questionFetch(table).clone();
			//userProgress++;
			this.qst = qstFetch[0];
			this.option1 = qstFetch[1];
			this.option2 = qstFetch[2];
			this.option3 = qstFetch[3];
			this.option4 = qstFetch[4];
			this.answer = qstFetch[5];
			//return qstFetch;
		}
		else if(userProgress >5 && userProgress <= 10){
			table = "medium_question";
			qstFetch = qst.questionFetch(table).clone();
			//userProgress++;
			this.qst = qstFetch[0];
			this.option1 = qstFetch[1];
			this.option2 = qstFetch[2];
			this.option3 = qstFetch[3];
			this.option4 = qstFetch[4];
			this.answer = qstFetch[5];
			//return qstFetch;
		}
		else{
			table = "difficult_question";
			qstFetch = qst.questionFetch(table).clone();
			//userProgress++;
			this.qst = qstFetch[0];
			this.option1 = qstFetch[1];
			this.option2 = qstFetch[2];
			this.option3 = qstFetch[3];
			this.option4 = qstFetch[4];
			this.answer = qstFetch[5];
			//return qstFetch;
		}
		
	}
	
	public boolean checkAnswer(String select){
		//this.selected = select;
		if(select.equalsIgnoreCase(answer)){
			return true;
		}
		else{
			return false;
		}
	}
	public void quiz() throws SQLException{
		do{
			showQuestion();
			if(checkAnswer(this.selected)){
				amountWon = amount[userProgress-1];
				if(amountWon == 10000 || amountWon == 320000 || amountWon == 10000000){
					savedamount = amountWon;
				}
				message = "You have selected the correct answer!!! Congrats you Won $"+amountWon;
				userProgress++;
			}
			else{
				message = "You have selected the Worng answer!!!";
			}
			
		}while(checkAnswer(selected) && userProgress <= 15);
		if(savedamount == 10000000){
			message = "User have Won $"+savedamount+"\nCongrats You have completed the game!!!";
		}
		else if(savedamount > 0){
			message = "User have Won $"+savedamount+" Congrats!!!";
		}
		else{
			message = "Please Try Again!!!";
		}
	}
}	
		
	
	
	


