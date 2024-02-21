package com.jjw.jse0505;

import java.io.*;
import java.util.Scanner;

//필요한 클래스는 추가하시오.

public class BinaryTreeArray {

	String[] array;
	public static final int INIT_SIZE = 10;
	public static final int ROOT = 1;
    
	public BinaryTreeArray() {
		array = new String[INIT_SIZE];
	}
	
	public void set(int index, String data) {
		if (index >= array.length) {
			String[] newArray = new String[index + 10];
			for(int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		array[index] = data;
	}
	
	// 배열에서 원소를 얻는 메소드
	public String get(int index) {
		if (index >= array.length)
			return null;
		
		return array[index];
	}
	
	public void inorder() {
		inorder(ROOT);
	}
	
	public void preorder() {
		preorder(ROOT);
	}
	
	public void postorder() {
		postorder(ROOT);
	}
	
	public void levelorder() {
		levelorder(ROOT);
	}
	
	/*************************************
	 * 작성해야 하는 함수
	 *************************************/

	private void inorder(int idx) { // 중위
		
		if(idx >= array.length){
			return;
		}
		inorder(2*idx);
		
		if(array[idx] != null) {
			System.out.print(array[idx] + " ");
		}
		
		inorder(2*idx+1);
		
	}
	
	private void preorder(int idx) { // 전위
		
		if(idx >= array.length){
			return;
		}
		
		if(array[idx] != null) {
			System.out.print(array[idx] + " ");
		}
		
		preorder(2*idx);
		preorder(2*idx+1);
		
	}
	
	private void postorder(int idx) { // 후위
		
		if(idx >= array.length){
			return;
		}
		postorder(2*idx);		
		postorder(2*idx+1);
				
		if(array[idx] != null) {
			System.out.print(array[idx] + " ");
		}
		
	}
	
	private void levelorder(int idx) { // 레벨순회
		
		if(idx >= array.length){
			return;
		}
		
		if(array[idx] != null) {
			System.out.print(array[idx] + " ");
		}
		
		levelorder(idx+1);
	}
}


class Main2 {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		BinaryTreeArray tree = new BinaryTreeArray();
		
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int index = scan.nextInt();
			String data = scan.next();
			
			tree.set(index, data);
		}
		
		scan.close();
		
		tree.inorder();
		System.out.println();
		
		tree.preorder();
		System.out.println();
		
		tree.postorder();
		System.out.println();
		
		tree.levelorder();
	}
}


