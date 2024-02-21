package com.jjw.jse0607;

import java.util.Scanner;
import java.util.ArrayList;

class Graph {
	int noVertex;	// ������ ����
	int[][] m;	// ���� ���
	public static final int NONE = 999; // ��� ����
	
	/**
	 * �׷��� �����͸� �о����.
	 */
	public void loadData(Scanner scan) {
		int noVertex = scan.nextInt();	// ������ ����

		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];
		
		// ������ ���� �׷��� ����
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				m[i][j] = scan.nextInt();	// ����ġ
	}// �ʿ��� �޼ҵ峪 �ʵ带 �߰��Ͻÿ�.
	
	
	
	
	/**
	 * ���� p.393 ����
	 * startVertex���� ����Ͽ� ��� ���������� �ּ� ����� ���Ѵ�.
	 * @param startVertex ����ϴ� ���� (p.384���� ���� 0�� �ش�)
	 * @return ����������� �ٸ� ��� ���������� �ּ� ��� (p.394�� ��������� �ش�)
	 */
	public ArrayList<Integer> shortestPath(int startVertex, int finalVertex) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<Integer> pathReverse = new ArrayList<Integer>();
		
		int[] dist = new int[noVertex];
		int[] route = new int[noVertex];
		boolean[] visited = new boolean[noVertex];
		
		// �ڵ带 �ۼ��Ͻÿ�.
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
	 * ��� path�� ��� ����ġ�� ���� ���Ѵ�.
	 * @param shortestPath �޼ҵ忡�� ���� ��η� ����ġ�� ���� ����ϱ� ���� ���̴�.
	 * @return path�� ��� ���� ��ȯ�Ѵ�.
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
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// �׷��� ����
		g.loadData(scan);	// �׷��� ������ ����
		
		int startVertex = scan.nextInt();	// ��� ���� 
		int finalVertex = scan.nextInt(); // ���� ����
			
		ArrayList<Integer> path = g.shortestPath(startVertex, finalVertex); // �ִ� ��ο� ���� ����� ����
		for(int vertex : path)
			System.out.print(vertex + " ");	// ��� ���
		System.out.println();
		System.out.println(g.getCost(path)); // ��� ���
	}
}

