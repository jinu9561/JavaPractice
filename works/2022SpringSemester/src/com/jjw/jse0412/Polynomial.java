package com.jjw.jse0412;

import java.util.Scanner;

public class Polynomial {

	/**
	 * 클래스 내부에 클래스를 만드는 경우를 예로 든 것이다.
	 * 이렇게 할 경우 클래스 Term은 Polynomial 클래스 내에서만
	 * 의미가 있다는 것을 알 수 있다.
	 */
	class Term {
		int coef;
		int exp;
		Term link;
	}

	private Term head;  // 첫번째 항을 가리키는 레퍼런스 변수
	private Term tail;  // 마지막 항을 가리키는 레퍼런스 변수

	public Polynomial() {
		head = tail = null; // 원래 객체의 인스턴스 필드는 null로 초기화되지만 이해를 위해 초기화함
	}

	/**
	 * @param coef 계수
	 * @param exp 지수
	 */
	public void addTerm(int coef, int exp) {
		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;
	
		if (head == null) {  // 처음으로 항이 추가되는 경우
			head = tail = term;
		} else {
			tail.link = term;
			tail = term;  // 마지막을 가리키는 항을 재지정
		}
	}
	
//================================================================
	
	/**
	 * 출력할 때 사용
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
	 * 메소드를 완성하시오.
	 */
	
	
	public String toString() {
		
		if(head == null) {
			return "0";
		}
		
		Term t = this.head;
		
		String str = "";
		
		while(t.link != null) {
			if(t.exp > 1) {
				if(t.coef != 1) {
					str += t.coef + "x^" + t.exp + "+";
					t = t.link;
				} else {
					str += "x^" + t.exp + "+";
					t = t.link;
				}
			} else if(t.exp == 1) {
				if(t.coef != 1) {
					str += t.coef + "x" + "+";
					t = t.link;
				} else {
					str += "x" + "+";
					t = t.link;
				}
			} else {
				if(t.coef != 1) {
					str += t.coef + "+";
					t = t.link;
				} else {
					str += 1 + "+";
					t = t.link;
				}
			}
		}
		
		if(t.exp > 1) {
			if(t.coef != 1) {
				str += t.coef + "x^" + t.exp;
			} else {
				str += "x^" + t.exp;
			}
		} else if(t.exp == 1) {
			if(t.coef != 1) {
				str += t.coef + "x";
			} else {
				str += "x";
			}
		} else {
			if(t.coef != 1) {
				str += t.coef;
			} else {
				str += 1;
			}
		}
		
		return str;

	}

	/**
	 * 두 개의 다항식을 더한다.
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 * 메소드를 완성하시오. 
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {

		Polynomial p3 = new Polynomial();
		
		Term a = p1.head;
		Term b = p2.head;		
		
		while(a != null && b != null) {
			
			if(a.exp > b.exp) {
				
				p3.addTerm(a.coef, a.exp);
				a = a.link;
				
			} else if(a.exp < b.exp) {
				
				p3.addTerm(b.coef, b.exp);
				b = b.link;
				
			} else {
				
				int sum = a.coef + b.coef;
				if(sum != 0) {
					p3.addTerm(sum, a.exp);
					a = a.link;
					b = b.link;
				} else {
					a = a.link;
					b = b.link;
				}
				
			}
			
		}
		
		while(a != null) {
			p3.addTerm(a.coef, a.exp);
			a = a.link;
		}
		
		while(b != null) {
			p3.addTerm(b.coef, b.exp);
			b = b.link;
		}
		
		return p3;
		
	}
}

//===================================================================

class Main2 {
	
	// main 메소드는 수정하지 마시오.
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
//--------------------------------------------------------------------	
		Polynomial p2 = new Polynomial();
//============================================================		
		int no2 = scan.nextInt();
		for(int i = 0; i < no2; i++) {
			int coef = scan.nextInt();
			int exp  = scan.nextInt();
			p2.addTerm(coef, exp);
		}
		
		scan.close();
//============================================================

		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // 이것은 System.out.print(p3.toString())과 동일
	}
}
