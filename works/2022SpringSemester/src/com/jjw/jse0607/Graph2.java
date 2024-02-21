package com.jjw.jse0607;

import java.util.Scanner;
import java.util.ArrayList;

class Graph {
	int noVertex;	// 정점의 갯수
	int[][] m;	// 인접 행렬
	public static final int NONE = 999; // 경로 없음
	
	/**
	 * 그래프 데이터를 읽어들임.
	 */
	public void loadData(Scanner scan) {
		int noVertex = scan.nextInt();	// 정점의 갯수

		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];
		
		// 간선이 없는 그래프 생성
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				m[i][j] = scan.nextInt();	// 가중치
	}// 필요한 메소드나 필드를 추가하시오.
	
	
	
	
	/**
	 * 교재 p.393 참조
	 * startVertex에서 출발하여 모든 정점으로의 최소 비용을 구한다.
	 * @param startVertex 출발하는 정점 (p.384에서 정점 0에 해당)
	 * @return 출발정점에서 다른 모든 정점으로의 최소 비용 (p.394의 최종결과에 해당)
	 */
	public ArrayList<Integer> shortestPath(int startVertex, int finalVertex) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<Integer> pathReverse = new ArrayList<Integer>();
		
		int[] dist = new int[noVertex];
		int[] route = new int[noVertex];
		boolean[] visited = new boolean[noVertex];
		
		// 코드를 작성하시오.
		int next = 0;
		int min = 0;

		for(int i = 0; i < noVertex; i++) {
			dist[i] = NONE;
			visited[i] = false;
			route[i] = -1;
		}
		
		dist[startVertex] = 0;
		
//==========================================================================		


		
		for(int i = 0; i < noVertex; i++) {
			
			min = NONE;
			
			for(int j = 0; j < noVertex; j++) {
				if(visited[j] == false && dist[j] < min) {
					min = dist[j];
					next = j;
				}
			}
			
			visited[next] = true;
			
			for(int j = 0; j < noVertex; j++) {

				if(dist[j] > dist[next] + m[next][j]) {
					dist[j] = dist[next] + m[next][j];
					route[j] = next;
				}
				
			}
		}
//======================================================================		
			
		while(true) {
			if(route[finalVertex] != -1 && startVertex != finalVertex) {
				pathReverse.add(finalVertex);
				finalVertex = route[finalVertex];
			} else {
				pathReverse.add(startVertex);
				break;
			}
		}
		
		for(int i = pathReverse.size()-1; i >= 0; i--) {
			int a = pathReverse.get(i);
			path.add(a);
		}
		
		return path;
	}

	/**
	 * 경로 path의 모든 가중치의 합을 구한다.
	 * @param shortestPath 메소드에서 구한 경로로 가중치의 합을 계산하기 위한 것이다.
	 * @return path의 비용 합을 반환한다.
	 */
	public int getCost(ArrayList<Integer> path) {
		int res = 0;
		
		for(int i = 0; i < path.size()-1; i++) {
			int idx1 = path.get(i);
			int idx2 = path.get(i+1);
			res += m[idx1][idx2];
		}
		
		return res;
	}
}
class Main2 {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// 그래프 생성
		g.loadData(scan);	// 그래프 데이터 읽음
		
		int startVertex = scan.nextInt();	// 출발 정점 
		int finalVertex = scan.nextInt(); // 도착 정점
			
		ArrayList<Integer> path = g.shortestPath(startVertex, finalVertex); // 최단 경로에 따른 비용을 구함
		for(int vertex : path)
			System.out.print(vertex + " ");	// 경로 출력
		System.out.println();
		System.out.println(g.getCost(path)); // 비용 출력
	}
}

