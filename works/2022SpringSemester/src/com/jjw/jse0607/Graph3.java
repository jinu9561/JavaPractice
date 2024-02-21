package com.jjw.jse0607;

import java.io.*;
import java.util.Scanner;

class Graph3 {
	int noVertex;	// ������ ����
	int[][] m;	// ���� ���
	
	public Graph3(int noVertex) {
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
	}
	
	// �ʿ��� �޼ҵ峪 �ʵ带 �߰��Ͻÿ�.
	
	
	
	public int[][] getTransitiveClosure() { // ������ ���
		int[][] closure = new int[noVertex][noVertex];
		boolean[] visited = new boolean[noVertex];
		int[] prevList = new int[noVertex]; // 
		
//===========================================================================		
		
		for(int i = 0; i < noVertex; i++) {
			
			for(int j = 0; j < noVertex; j++) {
				
				for(int k = 0; k < prevList.length; k++) {
					prevList[k] = 0;
				}
				
				int start = i;
				int fin = j;
				
				int next = start;
				
				// visited �ʱ�ȭ
				for(int k = 0; k < noVertex; k++) {
					visited[k] = false;
				}  
				
				visited[start] = true; // ������ �湮 üũ
				visited[fin] = false; // ������ �̹湮 üũ
				
//-----------------------------------------------------------------------------------				
				
				if(m[start][fin] == 1) {
					closure[start][fin] = 1;
				} // m[start][fin]�� ��Ұ� 1�̸� �ѹ��� start���� fin���� ���� ���� ����
				else 
				{
					int k = 0;
					int prevListidx = 0;
					
					while (true) {
						
						if(m[next][k] == 1 && visited[k] == false) {
							prevListidx++;
							prevList[prevListidx] = next;
							
							next = k;
							visited[next] = true;
							
							if(next == fin) {
								closure[start][fin] = 1;
								break;
								} 
							k = -1;
						}
						
						
						k++; // ���� �����ϸ� k�� 0(-1 + 1)�� �ǰ� �������ϸ� 1�� ����
						
						// k�� ���� ����� ���� ������ �ٽ� Ž���ϱ�
						if(k == noVertex && prevListidx >= 1) {
							k = 0;
							next = prevList[prevListidx];
							prevListidx--;
						} else if (k == noVertex && prevListidx < 1) {
							break;
						} // ��� ���� �� �������� ���������� ���� ������ ���� Ż��

					
					}
				}
				
				
				
			}
			
			
		}
		
		return closure;
	}

}

class Main3{
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int noVertex = scan.nextInt();	// ������ ����
		
		Graph3 g = new Graph3(noVertex);	// �׷��� ����
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				g.m[i][j] = scan.nextInt();
		
		int[][] mat = g.getTransitiveClosure();
		for(int[] m : mat) {
			for(int exist : m)
				System.out.print(exist + " ");
			System.out.println();
		}
	}
}
