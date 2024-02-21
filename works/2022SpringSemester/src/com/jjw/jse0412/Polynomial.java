package com.jjw.jse0412;

import java.util.Scanner;

public class Polynomial {

	/**
	 * Ŭ���� ���ο� Ŭ������ ����� ��츦 ���� �� ���̴�.
	 * �̷��� �� ��� Ŭ���� Term�� Polynomial Ŭ���� ��������
	 * �ǹ̰� �ִٴ� ���� �� �� �ִ�.
	 */
	class Term {
		int coef;
		int exp;
		Term link;
	}

	private Term head;  // ù��° ���� ����Ű�� ���۷��� ����
	private Term tail;  // ������ ���� ����Ű�� ���۷��� ����

	public Polynomial() {
		head = tail = null; // ���� ��ü�� �ν��Ͻ� �ʵ�� null�� �ʱ�ȭ������ ���ظ� ���� �ʱ�ȭ��
	}

	/**
	 * @param coef ���
	 * @param exp ����
	 */
	public void addTerm(int coef, int exp) {
		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;
	
		if (head == null) {  // ó������ ���� �߰��Ǵ� ���
			head = tail = term;
		} else {
			tail.link = term;
			tail = term;  // �������� ����Ű�� ���� ������
		}
	}
	
//================================================================
	
	/**
	 * ����� �� ���
	 * @return ��ü�� ���ڿ��� ��ȯ (��: 3x^15+2x^3+4x^2+x+5 )
	 * �޼ҵ带 �ϼ��Ͻÿ�.
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
	 * �� ���� ���׽��� ���Ѵ�.
	 * @param p1 ù��° ���׽�
	 * @param p2 �ι�° ���׽�
	 * @return �� ���� ���׽��� ���� ���
	 * �޼ҵ带 �ϼ��Ͻÿ�. 
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
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// ù��° ���׽� �Է�
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

		// �ΰ��� ���׽� ����
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3);  // �̰��� System.out.print(p3.toString())�� ����
	}
}
