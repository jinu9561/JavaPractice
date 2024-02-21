package com.jjw.jse0607;

import java.io.*;
import java.util.Scanner;

class Graph3 {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬
	
	public Graph3(int noVertex) {
		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];		
	}
	
	// 필요한 메소드나 필드를 추가하시오.
	
	
	
	public int[][] getTransitiveClosure() { // 이행적 폐쇄
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
				
				// visited 초기화
				for(int k = 0; k < noVertex; k++) {
					visited[k] = false;
				}  
				
				visited[start] = true; // 시작점 방문 체크
				visited[fin] = false; // 도착점 미방문 체크
				
//-----------------------------------------------------------------------------------				
				
				if(m[start][fin] == 1) {
					closure[start][fin] = 1;
				} // m[start][fin]의 요소가 1이면 한번에 start에서 fin으로 가는 길이 있음
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
						
						
						k++; // 조건 만족하면 k는 0(-1 + 1)이 되고 만족안하면 1씩 증가
						
						// k가 범위 벗어나면 이전 헹으로 다시 탐사하기
						if(k == noVertex && prevListidx >= 1) {
							k = 0;
							next = prevList[prevListidx];
							prevListidx--;
						} else if (k == noVertex && prevListidx < 1) {
							break;
						} // 모든 행을 다 가봤지만 도착점으로 가지 않을때 루프 탈출

					
					}
				}
				
				
				
			}
			
			
		}
		
		return closure;
	}

}

class Main3{
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int noVertex = scan.nextInt();	// 정점의 갯수
		
		Graph3 g = new Graph3(noVertex);	// 그래프 생성
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
