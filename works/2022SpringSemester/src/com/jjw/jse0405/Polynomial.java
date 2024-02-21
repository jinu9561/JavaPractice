package com.jjw.jse0405;

import java.io.*;
import java.util.Scanner;

public class Polynomial {
	private int[][] term;
	private int curNoTerm = 0;

	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}

	public Polynomial() {
		this(20);  // default로 최대 20개의 항을 저장함
	}

	/**
	 * @param coef 계수
   * @param exp 지수
	 */
	public void addTerm(int coef, int exp) {
		term[curNoTerm][0] = exp;      //
		term[curNoTerm][1] = coef;
		curNoTerm++;
	}
	
	// @param exp
	
//============================================================
	
		// 작성하시오
	public void delTerm(int exp) {
		
		for(int i = 0; i < curNoTerm; i++) {
			if(term[i][1] == 0) {
				term[i][0] = 0;
			}
		}
						
	}
		
//=============================================================

		/**
		 * 출력할 때 사용
		 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
		 * 작성하시오.
		 */
		public String toString() {	
			
			String[] polyList = new String[curNoTerm];
			String res = "";
			
			if(term[0][1] != 0) {
				if(term[0][0] > 1) {
					res = String.valueOf(term[0][1] + "x^" + term[0][0]);
				} else if(term[0][0] == 1) {
					res = String.valueOf(term[0][1] + "x");
				} else {
					res = String.valueOf(term[0][1]);
				}
			}


			for(int i = 1; i < curNoTerm; i++) {
					
				if(term[i][1] != 1) {	
					if(term[i][0] > 1) {
						polyList[i] = String.valueOf(term[i][1] + "x^" + term[i][0]);
					} else if(term[i][0] == 1) {
						polyList[i] = String.valueOf(term[i][1] + "x");
					} else {
						polyList[i] = String.valueOf(term[i][1]);
					}
				} else {
					if(term[i][0] > 1) {
						polyList[i] = String.valueOf("x^" + term[i][0]);
					} else if(term[i][0] == 1) {
						polyList[i] = String.valueOf("x");
					} else {
						polyList[i] = "1";
					}
				}
				
			} 
						
			for(int x = 1; x < curNoTerm; x++) {
				if(res != "" && term[x][1] != 0) {
					res += "+";
					res += polyList[x];
				} else if(res == "" && term[x][1] != 0) {
					res += polyList[x];
				}
			}
			
			if(res == "") {
				res = "0";
			}
			
			return res;
		}
		


	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {

		
		Polynomial p3 = new Polynomial();
		
		int i = 0, j = 0, k = 0;	
		p3.curNoTerm = 19;
		
		if(p2.curNoTerm >= p1.curNoTerm) {
			while(i <= p1.curNoTerm && j <= p2.curNoTerm) {
				if(p1.term[i][0] == p2.term[j][0]) {
					p3.term[k][1] = p1.term[i][1] + p2.term[j][1];
					p3.term[k][0] = p1.term[i][1];
					i++;
					j++;
					k++;
				} else if(p1.term[i][0] > p2.term[j][0]) {
					p3.term[k][0] = p1.term[i][0];
					p3.term[k][1] = p1.term[i][1];
					i++;
					k++;
				} else {
					p3.term[k][0] = p2.term[j][0];
					p3.term[k][1] = p2.term[j][1];
					j++;
					k++;
				}
			}
		} else if(p1.curNoTerm >= p2.curNoTerm) {
			while(i <= p2.curNoTerm && j <= p1.curNoTerm) {
				if(p2.term[i][0] == p1.term[j][0]) {
					p3.term[k][1] = p2.term[i][1] + p1.term[j][1];
					p3.term[k][0] = p2.term[i][1];
					i++;
					j++;
					k++;
				} else if(p2.term[i][0] > p1.term[j][0]) {
					p3.term[k][0] = p2.term[i][0];
					p3.term[k][1] = p2.term[i][1];
					i++;
					k++;
				} else {
					p3.term[k][0] = p1.term[j][0];
					p3.term[k][1] = p1.term[j][1];
					j++;
					k++;
				}
			}
		}
		
		
		return p3;
	}
}	

//==============================================================

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 첫번째 다항식 입력
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p1.addTerm(coef, exp);
		}

//------------------------------------------------------------------
		Polynomial p2 = new Polynomial();
//=======================================================
		int no2 = scan.nextInt();
		for(int i = 0; i < no2; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p2.addTerm(coef, exp);
		}
		
		scan.close();
//========================================================
		
		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // 이것은 System.out.print(p3.toString())과 동일
	}

}
