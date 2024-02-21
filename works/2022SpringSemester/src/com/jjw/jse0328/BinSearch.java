package com.jjw.jse0328;

import java.util.Scanner;

public class BinSearch {
	
	public static int binsearch(int[] a, int key, int left, int right) {
		
		int mid = (right - left) / 2;

		while(left <= right) {
			
			if(a[mid] == key) {
				return mid;
			}
			
			if(a[mid] > key) {
				right = mid - 1;
			} else if(a[mid] < key) {
				left = mid + 1;
			}
			
			mid = (left + right) / 2;
		}
		return -1;		
	}
	
	
//====================================================
	
	
	 public static void main(String[] args) {
		 


	    }

}
