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
	private ListNode head; // 리스트의 첫번째 노드를 가리킴
	private ListNode tail; // 리스트의 마지막 노드를 가리킴

	public DoubleLinkedList() {
		head = tail = null; // 리스트가 비어있을 때는 모두 null 이다.
	}
	
//============================================================	
	
	/**
	 * 리스트는 이름순으로 정렬되므로 정렬된 적절한 위치에 삽입한다.
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
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
////		Arrays.sort(arr); // 안되면 다른걸로 해보기
//		
//		// 꺼내서 리스트에 넣고 정렬한 후 node2에 넣기
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
	 * 인자로 입력받은 데이터를 삭제한다.
	 * @param str 삭제하고자 하는 데이터
	 * 작성하여야 한다.
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
	// 저장된 모든 데이터를 출력한다.
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
	
	// main 메소드는 수정하지 마시오.
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