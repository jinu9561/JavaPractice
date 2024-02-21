package com.jjw.jse0322;

public class LeapYear {

	/**
	 * �Ʒ� �޼ҵ� getNumberOfDays�� �ϼ��Ͻÿ�.
	 * �����̸� 366�� �׷��� ������ 365�� ��ȯ�Ѵ�. 
	 * @param year ����� ����
	 * @returns �Է¹��� ������ ��¥���� ����Ͽ� ��ȯ�Ѵ�.
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
