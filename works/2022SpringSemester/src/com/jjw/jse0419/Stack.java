package com.jjw.jse0419;

import java.io.*;
import java.util.Scanner;

class Stack {
	
	// �ʿ��� �ʵ峪 �޼ҵ尡 ������ �ۼ��Ͻÿ�.
	

//	public static void main(String[] args) throws Exception {
//		Scanner scan = new Scanner(System.in);
//		
//		// �Ʒ� �ڵ带 �ϼ��Ͻÿ�.
//		String str = scan.next();
//		
//		Double[] stack = new Double[str.length()];
//		int top = -1;
//		
//		while (!str.equals("$")) {
//			
//			Double n1, n2;
//			
//			if (str.equals("+")) {
//				
//				n1 = stack[top--];
//				n2 = stack[top--];
//				stack[top--] = n2 + n1;
//				top--;
//				
//			} else if (str.equals("-")) {
//				
//				n1 = stack[top--];
//				n2 = stack[top--];
//				stack[top--] = n2 - n1;
//				top--;
//				
//			} else if (str.equals("*")) {
//				
//				n1 = stack[top--];
//				n2 = stack[top--];
//				stack[top--] = n2 * n1;
//				top--;
//				
//			} else if (str.equals("/")) {
//				
//				n1 = stack[top--];
//				n2 = stack[top--];
//				stack[top--] = n2 / n1;
//				top--;
//				
//			} else {
//				double operand = Double.parseDouble(str);	
//				stack[top+1] = operand;
//				top++;
//				
//			}
//			
//			
//			
////			str = scan.next();
//		}
//		
//		System.out.println(stack[top]);
//	}
	


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" ");
		Double[] stack = new Double[str.length];
		int top = -1;
		
		for(int i = 0; i<str.length; i++) {
			char c = str[i].charAt(0);
			Double num1, num2;
			
			switch (c) {
			case '+': {
				
				num2 = stack[top--];
				num1 = stack[top--];
				stack[++top] = num1 + num2;
				break;
			}
			
			case '-': {
				
				num2 = stack[top--];
				num1 = stack[top--];
				stack[++top] = num1 - num2;
				break;
			}
			
			case '*': {
				
				num2 = stack[top--];
				num1 = stack[top--];
				stack[++top] = num1 * num2;
				break;
			}
			
			case '/': {
				
				num2 = stack[top--];
				num1 = stack[top--];
				stack[++top] = num1 / num2;
				break;
			}
			
			case '$': {
				System.out.println(stack[top--]);
				break;
			}
			
			default:
				stack[++top] = Double.parseDouble(str[i]);
				break;
			}
			
			
		}
		
	}
}

