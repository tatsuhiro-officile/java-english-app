package model;

import java.util.ArrayList;


public class Making_onsei_Logic {

	public Onsei[] making_onsei(ArrayList<Problem> getword){
		Onsei [] onseilist = new Onsei[20];



		for(int i=0;i<20;i++) {
			StringBuilder onsei = new StringBuilder();
			int word = getword.get(i).getWord();
			String problem1 = getword.get(i).getNo1();

			String problem2 = getword.get(i).getNo2();
			String problem3 = getword.get(i).getNo3();
			String problem4 = getword.get(i).getNo4();
			String problem5 = getword.get(i).getNo5();
			String problem6 = getword.get(i).getNo6();
			String problem7 = getword.get(i).getNo7();
			String problem8 = getword.get(i).getNo8();
			String problem9 = getword.get(i).getNo9();
			String problem10 = getword.get(i).getNo10();
			String problem11 = getword.get(i).getNo11();
			String problem12 = getword.get(i).getNo12();
			String problem13 = getword.get(i).getNo13();
			String problem14 = getword.get(i).getNo14();
			String problem15 = getword.get(i).getNo15();
			int  quations = getword.get(i).getQuations();

			onsei.append(" ");

			onsei.append(problem1);
			onsei.append(" ");
			onsei.append(problem2);
			onsei.append(" ");
			onsei.append(problem3);
			onsei.append(" ");
			if(word>3) {
				onsei.append(problem4);
				onsei.append("");
			}
			if(word>4) {
				onsei.append(problem5);
				onsei.append(" ");
			}
			if(word>5) {
				onsei.append(problem6);
				onsei.append(" ");
			}
			if(word>6) {
				onsei.append(problem7);
				onsei.append(" ");
			}
			if(word>7) {
				onsei.append(problem8);
				onsei.append(" ");
			}
			if(word>8) {
				onsei.append(problem9);
				onsei.append(" ");
			}
			if(word>9) {
				onsei.append(problem10);
				onsei.append(" ");
			}
			if(word>10) {
				onsei.append(problem11);
				onsei.append(" ");
			}
			if(word>11) {
				onsei.append(problem12);
				onsei.append(" ");
			}
			if(word>12) {
				onsei.append(problem13);
				onsei.append(" ");
			}
			if(word>13) {
				onsei.append(problem14);
				onsei.append(" ");
			}
			if(word>14) {
				onsei.append(problem15);
				onsei.append(" ");
			}
			if(quations==0) {
				onsei.append(".");

			}else {
				onsei.append("?");

			}

			String returnonsei = onsei.toString();
			Onsei onseiinstance = new Onsei(returnonsei);
			onseilist[i]= onseiinstance;
		}

			return onseilist;

	}
}
