package com.jjw.jse0505;

import java.util.Scanner;

public class BinaryTree {

	String data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(String data) {
		this.data = data;
		left = right = null;
	}
	
	public void setChildren(BinaryTree left, BinaryTree right) {
		this.left = left;
		this.right = right;
	}
}


// Stack Ŭ������ �ʿ��� �ʵ�� �޼ҵ带 �߰��ϰ�, push, pop, isEmpty�� �����Ͽ� �ϼ��Ͻÿ�.
class Stack {
	
	// �ʿ��� �ʵ�� �޼ҵ带 �߰��Ͻÿ�.
	
		BinaryTree root = null;
		
		public void push(BinaryTree item) {
			
			if(item.data == "(") {
				if(root.data == null) {
					root = null;
				} else if(root.left == null) {
					root.left = item;
				} else {
					push(item);
				}
			} 
			
			else if(item.data == ")") {
//				if() {
//					
//				}
			}
			
			else {
				root.data = item.data;
			}
			
		}
	
		public BinaryTree pop() {
			
			
			return null;
		}
	
		public boolean isEmpty() {
			
			boolean flag = false;
			
			if(root.data  == null && root.left == null
					&& root.right == null) {
				flag = true;
			}
			
			return flag;
		}
}

// �߰������� �ʿ��� Ŭ����(���� ��� ť)�� ������ �ۼ��Ͻÿ�.




class Main {
	
	
	/***********************************
	 * �Ʒ� 4���� �޼ҵ带 �ۼ��Ͻÿ�. *
	***********************************/

	public static void inorder(BinaryTree node) {
		
		
	}
	
	public static void preorder(BinaryTree node) {
		
		
	}
	
	public static void postorder(BinaryTree node) {
		
		
	}
	
	public static void levelorder(BinaryTree node) {
		
		
	}
	
	// �Ʒ� main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		
		BinaryTree root = null;
		
		// ���� Ʈ�� ����
		while(scan.hasNext()) {
			String token = scan.next();
			if (token.equals("null")) {
				stack.push(null);
			} else if (token.equals(")")) {
				BinaryTree right = stack.pop();
				if (stack.isEmpty()) {
					root = right;
					break;
				}
				BinaryTree left = stack.pop();
				root = stack.pop();
				root.setChildren(left, right);
				stack.push(root);
			} else if (token.equals("(")) {
				continue;
			} else {
				stack.push(new BinaryTree(token));
			}
		}
		
		scan.close();
		
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		levelorder(root);
	}
}
