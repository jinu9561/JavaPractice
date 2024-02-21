package com.jjw.jse0419;

import java.util.Scanner;

public class Stack2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] stack = new char[20];
		int top=-1;
		String[] str = scan.nextLine().split(" ");
		
		
		
		for(int i=0; i<str.length; i++) {
			char c = str[i].charAt(0);
			
			switch (c) {
			
			case '(': {
				stack[++top]=c;
				break;
			}
			case ')': {
				while(top > -1 && stack[top] != '(') {
					System.out.print(stack[top] + " ");
					top--;
				}
				if(stack[top]=='(') {
				
					top--;
				
				}
				break;
			}
	
//---------------------------------------------------------		
			case '*': {
				while(top > -1 && (stack[top] == '*')) {
					System.out.print(stack[top] + " ");
					top--;
				}
				stack[++top]=c;
				break;
			}
			case '/': {
				while(top > -1 && (stack[top] == '/')) {
					System.out.print(stack[top] + " ");
					top--;
				}
				stack[++top]=c;
				break;
			}
			
			
			case '+': {
				while(top>-1 && (stack[top] == '*' 
						|| stack[top] == '/' || stack[top] == '+')) {
					System.out.print(stack[top] + " ");
					top--;
				}
				stack[++top]=c;
				break;			
			}
			case '-': {
				while(top>-1 && (stack[top] == '*' 
						|| stack[top] == '/' || stack[top] == '-')) {
					System.out.print(stack[top] + " ");
					top--;
				}
				stack[++top]=c;
				break;	
			}
			
			case '$': {
				break;	
			}
			
			default:
				System.out.print(str[i]+" ");
				break;
			}
		}
		
		while(top > -1) {
			System.out.print(stack[top--] + " ");
		}
			
	}
}

