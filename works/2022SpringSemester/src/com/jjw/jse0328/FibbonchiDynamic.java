package com.jjw.jse0328;
import java.util.Scanner;
import java.io.*;

class FibbonchiDynamic {

//=========================================================
	// �Ǻ���ġ ������ ����ϴ� �Ʒ� fib �޼ҵ带 �ۼ��Ͻÿ�.
	// �̶� ���� ���α׷��� ����� �̿��Ͽ� �ڵ带 �ۼ��Ͻÿ�.
	// �ʿ��ϴٰ� �ǴܵǴ� �ʵ峪 �޼ҵ尡 �ִٸ� �߰��Ͽ��� �˴ϴ�.
	public static long fib(int n) {
		
		long[] arr = new long[n+1];
		
    	arr[0] = 0;
    	arr[1] = 1;
		
        if(n<=1) {
        	return arr[n];
        }  
        
        else {
        	for (int i = 2; i < n+1; i++) { arr[i] = arr[i-1] + arr[i-2];}
		
        	return arr[n];
        }
            
	}
	
//==========================================================
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();			// �������� ���� �Է�
		
		System.out.println(fib(n));
	}

}
