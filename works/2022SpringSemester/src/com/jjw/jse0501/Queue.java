package com.jjw.jse0501;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Queue {
	private String[] data;
	private static final int QUEUE_SIZE = 5;
	
	private int front = 0;
	private int rear = 0;

	
	public Queue() {
		data = new String[QUEUE_SIZE];
	}

	// �ۼ��Ͻÿ�.
	public void enque(String str) {
		
		 if (((rear + 1) % QUEUE_SIZE) != front) {
			 rear = (++rear) % QUEUE_SIZE;
			 data[rear] = str;
		 }
		
	}

	// �ۼ��Ͻÿ�.	
	public String deque() {
		
		if (((rear + 1) % QUEUE_SIZE) != front) {
			front = (++front) % QUEUE_SIZE;
		}
		return data[front];
		
	}
	
	// �ۼ��Ͻÿ�.
	public void print() {
		
		
	}
}

class Main {
	
	// �Ʒ� main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int no = Integer.parseInt(input);
		
		for(int i = 0; i < no; i++) {
			String cmd = br.readLine();
			
			if (cmd.equals("enque")) {
				String name = br.readLine();
				queue.enque(name);
			} else if (cmd.equals("deque")) {
				System.out.println(queue.deque());
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		queue.print();
		
		br.close();
  }
}