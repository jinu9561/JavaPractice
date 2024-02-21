import java.util.Scanner;

public class Practice9 {
	
	public static void displayMatrix(double[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void MatrixAddition(double[][] m1, double[][] m2) {
		
		double[][] m3 = new double[m1.length][m1[0].length];
		
		if((m1.length!=m2.length) || (m1[0].length!=m2[0].length)) {
			System.out.println("  Error!  ");
		}
		else {
			for(int i = 0; i < m1.length; i++) {
				for(int j = 0; j < m1[0].length; j++) {
					m3[i][j] = m1[i][j] + m2[i][j];
				}
			}
		}
		
		displayMatrix(m3);
		
	}


	public static void MatrixSubtraction(double[][] m1, double[][] m2) {
		
		double[][] m3 = new double[m1.length][m1[0].length];
		
		if((m1.length!=m2.length) || (m1[0].length!=m2[0].length)) {
			System.out.println("  Error!  ");
		}
		else {
			for(int i = 0; i < m1.length; i++) {
				for(int j = 0; j < m1[0].length; j++) {
					m3[i][j] = m1[i][j] - m2[i][j];
				}
			}
		}
		
		displayMatrix(m3);
	}
	
	public static void MatrixScalarMultiplication(double scalar, double[][] m1) {
		
		double[][] m2 = new double[m1.length][m1[0].length];

		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				m2[i][j] = scalar * m1[i][j];
			}
		}
		
		displayMatrix(m2);
	}
	
//column = �� row = ��	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cmd;
		
		System.out.printf("\n\n<< Matrix calculator >>\n");
		System.out.printf("1. A + B\n");
		System.out.printf("2. A - B\n");
		System.out.printf("3. n * A\n");
		System.out.printf("3. Exit\n");
		
		do {
			System.out.printf("Enter your choice:");
			cmd = sc.nextInt();
			System.out.printf("%d", cmd);
			
			switch (cmd) {
			case 1: {
				System.out.print("Enter the number of rows of matrix A: ");
				int row1 = sc.nextInt(); 
				
				System.out.print("Enter the number of columns of matrix A: ");
				int column1 = sc.nextInt();
				
				double[][] matrix1 = new double[row1][column1];
				
				System.out.println("Insert values of matrix A");
				for(int i = 0; i < row1; i++) {
					for(int j = 0; j < column1; j++) {
						double value = sc.nextInt();
						matrix1[i][j] = value;
					}
					System.out.println();
				}

		//===============================matrix2===============================================================		
				
				System.out.print("Enter the number of rows of matrix B: ");
				int row2 = sc.nextInt();
				
				System.out.print("Enter the number of columns of matrix B: ");
				int column2 = sc.nextInt();
				
				double[][] matrix2 = new double[row2][column2];
				
				System.out.println("Insert values of matrix B");
				for(int i = 0; i < row2; i++) {
					for(int j = 0; j < column2; j++) {
						double value = sc.nextInt();
						matrix2[i][j] = value;
					}
					System.out.println();
				}	
				
				System.out.println();
				System.out.println("A + B");
				MatrixAddition(matrix1, matrix2);
				System.out.println();
				
				break;
			}
			case 2: {
				System.out.print("Enter the number of rows of matrix A: ");
				int row1 = sc.nextInt(); 
				
				System.out.print("Enter the number of columns of matrix A: ");
				int column1 = sc.nextInt();
				
				double[][] matrix1 = new double[row1][column1];
				
				System.out.println("Insert values of matrix A");
				for(int i = 0; i < row1; i++) {
					for(int j = 0; j < column1; j++) {
						double value = sc.nextInt();
						matrix1[i][j] = value;
					}
					System.out.println();
					
					
				}

		//===============================matrix2===============================================================		
				
				System.out.print("Enter the number of rows of matrix B: ");
				int row2 = sc.nextInt();
				
				System.out.print("Enter the number of columns of matrix B: ");
				int column2 = sc.nextInt();
				
				double[][] matrix2 = new double[row2][column2];
				
				System.out.println("Insert values of matrix B");
				for(int i = 0; i < row2; i++) {
					for(int j = 0; j < column2; j++) {
						double value = sc.nextInt();
						matrix2[i][j] = value;
					}
					System.out.println();
				}	
				
				System.out.println("A - B");
				MatrixSubtraction(matrix1, matrix2);
				System.out.println();
				break;
			}
			case 3: {
				
				System.out.print("Enter a scalar n that you want to multiply with matrix A: ");
				int scalar = sc.nextInt();
				
				System.out.print("Enter the number of rows of matrix A: ");
				int row1 = sc.nextInt(); 
				
				System.out.print("Enter the number of columns of matrix A: ");
				int column1 = sc.nextInt();
				
				double[][] matrix1 = new double[row1][column1];
				
				System.out.println("Insert values of matrix A");
				for(int i = 0; i < row1; i++) {
					for(int j = 0; j < column1; j++) {
						double value = sc.nextInt();
						matrix1[i][j] = value;
					}
					System.out.println();
				}
				
				System.out.println("n * A");
				MatrixScalarMultiplication(scalar, matrix1);
				break;
			}
			default:
				System.out.printf("Invalid choice \n");
				break;
			}
		} while (cmd != 4);
		

//		
		sc.close();
		
	}

}
