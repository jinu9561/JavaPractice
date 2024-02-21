package com.jjw.jse0530;

import java.io.*;
import java.util.Scanner;

import com.jjw.jse0501.Queue;

//필요한 메소드를 추가하여 아래 클래스를 완성하시오.
public class Graph {

	// 필요한 field, method는 추가하시오.
	
	static int[][] graph;
	static boolean[] visited;
	static int[] queue = new int[100];
	
	// 생성자를 작성하시오.
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
	
	// 간선 (i, j)를 삽입한다.
	public void addEdge(int i, int j) {
		graph[i][j] = 1;
		graph[j][i] = 1;
	}
	
	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
		graph[i][j] = 0;
		graph[j][i] = 0;
	}
	
	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	// vertex에서 시작한다.
	
//=================실패함=======================================	
	public class ArrayQueue<E> {
		 
		private static final int DEFAULT_CAPACITY = 64;	// 최소(기본) 용적 크기 
		
		private Object[] array;	// 요소를 담을 배열 
		private int size;	// 요소 개수 
		
		private int front;	// 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
		private int rear;	// 마지막 요소의 인덱스를 가리키는 변수 
		
		
		// 생성자1 (초기 용적 할당을 안할 경우)  
		public ArrayQueue() {
			this.array = new Object[DEFAULT_CAPACITY];
			this.size = 0;
			this.front = 0;
			this.rear = 0;
		}
		
		// 생성자2 (초기 용적 할당을 할 경우) 
		public ArrayQueue(int capacity) {
			this.array = new Object[capacity];
			this.size = 0;
			this.front = 0;
			this.rear = 0;
		}
		
		private void resize(int newCapacity) {
			 
			int arrayCapacity = array.length; // 현재 용적 크기
		 
			Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열
		 
			/*
			 * i = new array index 
			 * j = original array 
			 * index 요소 개수(size)만큼 새 배열에 값 복사
			 */
			for (int i = 1, j = front + 1; i <= size; i++, j++) {
				newArray[i] = array[j % arrayCapacity];
			}
		 
			this.array = null;
			this.array = newArray; // 새 배열을 기존 array의 배열로 덮어씌움
		 
			front = 0;
			rear = size;
		 
		}
		
		public boolean offer(E item) {
				
			// 용적이 가득 찼을 경우 
			if((rear + 1) % array.length == front) {
				resize(array.length * 2);	// 용적을 두 배 늘려준다. 
			}
				
			rear = (rear + 1) % array.length;	// rear을 rear의 다음 위치로 갱신 
				
			array[rear] = item;
			size++;	// 사이즈 1 증가 
				
			return true;
		}
		public E poll() {
			
			if(size == 0) {	// 삭제할 요소가 없을 경우 null 반환 
				return null;
			}
				
			front = (front + 1) % array.length; // front 를 한 칸 옮긴다.
				
			@SuppressWarnings("unchecked")
			E item = (E) array[front];	// 반환할 데이터 임시 저장 
			
			array[front] = null;	// 해당 front의 데이터 삭제
			size--;	// 사이즈 감소 
				
				
			// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
			if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
					
				// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
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
	
	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	// vertex에서 시작한다.
	public void dfs(int vertex) {
		
		visited[vertex] = true;
		
		System.out.print(vertex + " ");
		
		for(int i = graph[0].length-1; i >= 0 ; i--) {
			if(graph[vertex][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	
	// 그래프를 출력하는 메소드이다.
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
	
	// main 메소드는 수정하지 마시오.
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
			} else if (cmd.equals("E")) { // 종료한다.
				break;
			}
		}
		
		scan.close();		
	}
}
