package com.jjw.jse0322;

public class LeapYear {

	/**
	 * 아래 메소드 getNumberOfDays를 완성하시오.
	 * 윤년이면 366를 그렇지 않으면 365를 반환한다. 
	 * @param year 계산할 연도
	 * @returns 입력받은 연도의 날짜수를 계산하여 반환한다.
	 */
	public static int getNumberOfDays(int year) {


		if (year%4 == 0) {
			
			if (year%400 == 0) {return 366;}
			else if (year%100 == 0) {return 365;}
			else {return 366;}
			
		}
		else {
			return 365;
		}
		
	}
	
}
