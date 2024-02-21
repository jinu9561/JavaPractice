package com.jjw.jse0530;

import java.io.*;
import java.util.Scanner;

import com.jjw.jse0501.Queue;

//�ʿ��� �޼ҵ带 �߰��Ͽ� �Ʒ� Ŭ������ �ϼ��Ͻÿ�.
public class Graph {

	// �ʿ��� field, method�� �߰��Ͻÿ�.
	
	static int[][] graph;
	static boolean[] visited;
	static int[] queue = new int[100];
	
	// �����ڸ� �ۼ��Ͻÿ�.
	public Graph(int noVertex) {
		graph = new int[noVertex][noVertex];
		visited = new boolean[noVertex + 1];
//		queue = new int[noVertex + 1];
	}
	
	public void isVisited() {
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void addEdge(int i, int j) {
		graph[i][j] = 1;
		graph[j][i] = 1;
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void removeEdge(int i, int j) {
		graph[i][j] = 0;
		graph[j][i] = 0;
	}
	
	// BFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	// vertex���� �����Ѵ�.
	
//=================������=======================================	
	public class ArrayQueue<E> {
		 
		private static final int DEFAULT_CAPACITY = 64;	// �ּ�(�⺻) ���� ũ�� 
		
		private Object[] array;	// ��Ҹ� ���� �迭 
		private int size;	// ��� ���� 
		
		private int front;	// ���� �ε����� ����Ű�� ����(�� �������� ����)
		private int rear;	// ������ ����� �ε����� ����Ű�� ���� 
		
		
		// ������1 (�ʱ� ���� �Ҵ��� ���� ���)  
		public ArrayQueue() {
			this.array = new Object[DEFAULT_CAPACITY];
			this.size = 0;
			this.front = 0;
			this.rear = 0;
		}
		
		// ������2 (�ʱ� ���� �Ҵ��� �� ���) 
		public ArrayQueue(int capacity) {
			this.array = new Object[capacity];
			this.size = 0;
			this.front = 0;
			this.rear = 0;
		}
		
		private void resize(int newCapacity) {
			 
			int arrayCapacity = array.length; // ���� ���� ũ��
		 
			Object[] newArray = new Object[newCapacity]; // ������ ������ �迭
		 
			/*
			 * i = new array index 
			 * j = original array 
			 * index ��� ����(size)��ŭ �� �迭�� �� ����
			 */
			for (int i = 1, j = front + 1; i <= size; i++, j++) {
				newArray[i] = array[j % arrayCapacity];
			}
		 
			this.array = null;
			this.array = newArray; // �� �迭�� ���� array�� �迭�� �����
		 
			front = 0;
			rear = size;
		 
		}
		
		public boolean offer(E item) {
				
			// ������ ���� á�� ��� 
			if((rear + 1) % array.length == front) {
				resize(array.length * 2);	// ������ �� �� �÷��ش�. 
			}
				
			rear = (rear + 1) % array.length;	// rear�� rear�� ���� ��ġ�� ���� 
				
			array[rear] = item;
			size++;	// ������ 1 ���� 
				
			return true;
		}
		public E poll() {
			
			if(size == 0) {	// ������ ��Ұ� ���� ��� null ��ȯ 
				return null;
			}
				
			front = (front + 1) % array.length; // front �� �� ĭ �ű��.
				
			@SuppressWarnings("unchecked")
			E item = (E) array[front];	// ��ȯ�� ������ �ӽ� ���� 
			
			array[front] = null;	// �ش� front�� ������ ����
			size--;	// ������ ���� 
				
				
			// ������ �ּ� ũ��(64)���� ũ�� ��� ������ 1/4 �̸��� ���
			if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
					
				// �ƹ��� �۾Ƶ� �ּҿ��� �̸����� �������� �ʵ��� �Ѵ�. 
				resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
			}
				
			return item;
		}
	 
	}
	
	public void bfs(int vertex) {

		ArrayQueue<Integer> queue = new ArrayQueue<>();
		queue.offer(vertex);
		visited[vertex] = true;
		  
		while(queue != null) {
			int next = queue.poll();
			System.out.print(next + " ");
		    
			for(int i = 0; i < graph.length; i++) {
				if(graph[next][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
					}
				}
			}
		}
//=============================================================
	
	// DFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	// vertex���� �����Ѵ�.
	public void dfs(int vertex) {
		
		visited[vertex] = true;
		
		System.out.print(vertex + " ");
		
		for(int i = graph[0].length-1; i >= 0 ; i--) {
			if(graph[vertex][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	
	// �׷����� ����ϴ� �޼ҵ��̴�.
	public void print() {
		for(int i = 0; i < graph.length; i++) {
			System.out.print(i);
			for(int j = 0; j < graph.length; j++) {
				if(graph[i][j] == 1) {
					System.out.print(" " + j);
				}
			}
			System.out.println();
		}
	}
}

class Main {
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int noVertex = scan.nextInt();
		Graph graph = new Graph(noVertex);

		for(int i = 0; i < noVertex; i++) {
			for(int j = 0; j < noVertex; j++) {
				int vertex = scan.nextInt();
				if (vertex == 1)
					graph.addEdge(i, j);
			}
		}
		
		
		while(scan.hasNext()) {
			String cmd = scan.next();
			if (cmd.equals("P"))
				graph.print();
			else if (cmd.equals("I")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.addEdge(from, to);
			} else if (cmd.equals("D")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.removeEdge(from, to);
			} else if (cmd.equals("DFS")) {
				int vertex = scan.nextInt();
				graph.dfs(vertex);
			} else if (cmd.equals("BFS")) {
				int vertex = scan.nextInt();
				graph.bfs(vertex);
			} else if (cmd.equals("E")) { // �����Ѵ�.
				break;
			}
		}
		
		scan.close();		
	}
}
