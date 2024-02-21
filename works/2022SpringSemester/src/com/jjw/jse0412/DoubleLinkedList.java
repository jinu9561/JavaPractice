package com.jjw.jse0412;

import java.util.Arrays;
import java.util.Scanner;

class ListNode {
	String data;
	ListNode rlink;
	ListNode llink;
}

//-----------------------------------------------------------

class DoubleLinkedList {
	private ListNode head; // ����Ʈ�� ù��° ��带 ����Ŵ
	private ListNode tail; // ����Ʈ�� ������ ��带 ����Ŵ

	public DoubleLinkedList() {
		head = tail = null; // ����Ʈ�� ������� ���� ��� null �̴�.
	}
	
//============================================================	
	
	/**
	 * ����Ʈ�� �̸������� ���ĵǹǷ� ���ĵ� ������ ��ġ�� �����Ѵ�.
	 * @param str �����ϰ��� �ϴ� ������
	 * �ۼ��Ͽ��� �Ѵ�.
	 */
	
	public static int size = 0;
	
	public void insert(String str) {
		
		ListNode newNode = new ListNode();
//---------------------------------------------------
		ListNode x = head;
		int index;
		
//--------------------------------------------------
		
				
		newNode.data = str;
		
		if(size == 0) {
			head = tail = newNode;
			size++;
		} else {
			
			while(newNode.data.compareTo(tail.data) < 0) {
				head.llink = newNode;
				newNode.rlink = head;
				head = newNode;
			}
			
			tail.rlink = newNode;
			newNode.llink = tail;
			tail = newNode;
			size++;
		}
		
				
		
		
		
//-------------------------------------------------		

//		for(int i = 0; i < size; i++) {
//			arr[i] = str;
//		}
////		Arrays.sort(arr); // �ȵǸ� �ٸ��ɷ� �غ���
//		
//		// ������ ����Ʈ�� �ְ� ������ �� node2�� �ֱ�
//		if(size != 0) {
//			for(int i = 0; i < size; i++) {
//				node2.data = arr[i];
//				tail.rlink = node2;
//				node2.llink = tail;
//				tail = node2;
//			}
//			
//		}
		
	}

	/**
	 * ���ڷ� �Է¹��� �����͸� �����Ѵ�.
	 * @param str �����ϰ��� �ϴ� ������
	 * �ۼ��Ͽ��� �Ѵ�.
	 */
	public void delete(String str) {

		ListNode h = head;
		ListNode t = tail;
		
		int index = 0;
		
		while(h.data != str) {
			index++;
		}
		
		if(index > 0) {
			if(index == 1) {
				h = h.rlink;
				h.llink = null;
			} else if(index == size) {
				t = t.llink;
				t.rlink = null;
			} else {
				for(int i = 1; i < index; i++) {
					h = h.rlink;
				}
				h.rlink.llink = h.llink;
				h.llink.rlink = h.rlink;
			}
			size--;
		}
		
	}
//============================================================	
	// ����� ��� �����͸� ����Ѵ�.
	public void print() {
		if (head == null) {
			System.out.println("EMPTY");
			return;
		}
		
		for(ListNode p = head; p != null; p = p.rlink)
			System.out.print(p.data + " ");
			System.out.println();
		}
	
}

//------------------------------------------------------------

class Main {
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
	
		while (true) {
			String cmd = scan.next();
			if (cmd.equals("E"))
				break;

			if (cmd.equals("I")) {
				list.insert(scan.next());
			} else if (cmd.equals("D")) {
				list.delete(scan.next());
			} else if (cmd.equals("P")) {
				list.print();
			} else {
				System.out.println("ERROR");
			}
		}
	}
}