package com.jjw.jse0328;
import java.util.Scanner;
import java.io.*;

class FibbonchiDynamic {

//=========================================================
	// 피보나치 수열을 계산하는 아래 fib 메소드를 작성하시오.
	// 이때 동적 프로그래밍 기법을 이용하여 코드를 작성하시오.
	// 필요하다고 판단되는 필드나 메소드가 있다면 추가하여도 됩니다.
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
		int n = scan.nextInt();			// 데이터의 갯수 입력
		
		System.out.println(fib(n));
	}

}
