package com.jjw.jse0607;

import java.util.Scanner;

class Graph1 {
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
	}
	
	// �ʿ��� �޼ҵ峪 �ʵ带 �߰��Ͻÿ�.
	
	
	
	/**
	 * ���� p.393 ����
	 * startVertex���� ����Ͽ� ��� ���������� �ּ� ����� ���Ѵ�.
	 * @param startVertex ����ϴ� ���� (p.384���� ���� 0�� �ش�)
	 * @return ����������� �ٸ� ��� ���������� �ּ� ��� (p.394�� ��������� �ش�)
	 */
	
	public int[] shortestPath(int startVertex) {
		int[] dist = new int[noVertex];
		boolean[] visited = new boolean[noVertex];
		
		for(int i = 0; i < noVertex; i++) {
			dist[i] = m[startVertex][i];
			visited[i] = false;
		}
		// �ڵ带 �ۼ��Ͻÿ�.
		
		dist[startVertex] = 0;
		visited[startVertex] = true;
		
		for(int i = 0; i < noVertex; i++) {
			int min = NONE;
			int next = 0;
			for(int j = 0; j < noVertex; j++) {
				if(visited[j] == false && dist[j] < min) {
					min = dist[j];
					next = j;
				}
			}
			
			visited[next] = true;
			
			for(int k = 0; k < noVertex; k++) {
				if(visited[k] == false &&
						dist[k] > (dist[next] + m[next][k])) {
					dist[k] = dist[next] + m[next][k];
				}
			}
			
		}
		
		return dist;
	}
}

class Main {
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph1 g = new Graph1();	// �׷��� ����
		g.loadData(scan);	// �׷��� ������ ����
		
		int startVertex = scan.nextInt();	// ��� ���� 
		
		int[] dist = g.shortestPath(startVertex); // �ִ� ��ο� ���� ����� ����
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");	// ��� ���
	}
}