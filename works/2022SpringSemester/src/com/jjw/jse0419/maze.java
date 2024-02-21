package com.jjw.jse0419;

import java.util.Scanner;

class Point {
	public int x, y;
}


public class maze {
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int sizeY = scan.nextInt();
		int sizeX = scan.nextInt();
		
		Point start = new Point();
		start.x = scan.nextInt();
		start.y = scan.nextInt();
		
		Point exit = new Point();
		exit.x = scan.nextInt();
		exit.y = scan.nextInt();
		
		String maze[][] = new String[sizeY][sizeX];
		int mark[][] = new int[sizeY][sizeX];

		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				maze[i][j] = scan.next();
		
		scan.close();
		
		// 아래 코드를 작성하시오.
//==========================================================
		int dir = 0;
		
		int stack[][] = new int[sizeX * sizeY][3];
		int move[][] = { {-1,0}, {0,1}, {1,0}, {0,-1} };
//-----------------------------------------------------------		
		
		mark[start.x][start.y] = 1;
		int next_i = start.x;
		int next_j = start.y;
		
		while(next_i == exit.x && next_j == exit.y) {
			int top = 0;
			while(dir < 4) {
				next_i = start.x + move[dir][0];
				next_j = start.y + move[dir][1];
				
				if (maze[next_i][next_j] == "0" && mark[next_i][next_j] == 0) {
					mark[next_i][next_j] = 1;
					
					stack[top][0] = next_i;
					stack[top][1] =	next_j;
					stack[top][2] = dir;
					top++;
					
					start.x = next_i;
					start.y = next_j;
					dir = 0;
				} else {
					dir++;
				}
				
			}
			
			stack[top][0] = 0;
			stack[top][1] = 0;
			stack[top][2] = 0;
	
		}
		
//-----------출력--------------------------------------------		

		
		for(int x = 0; x < 1000; x++) {
			int a = stack[x][0];
			int b = stack[x][1];
			
			maze[a][b] = "*";
		}
		
		
		maze[1][1] = "S";
		maze[exit.x-1][exit.y-1] = "F";
		
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
				
	}
	
}
