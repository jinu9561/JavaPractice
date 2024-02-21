import java.util.Scanner;

public class Practice6 {
	
	public static int getPentagonalNumber(int n) {
		return  n*(3*n-1) / 2;

	}
	
	public static int sumDigits(long n) {
		int res = 0;
		while(true) {
			res += n%10;
			n = n/10;
			if(n == 0) break;
		}
		return res;
	}
	
	public static int reverse(int number) {
		int res = 0;
		while(true) {
			if(number == 0) break;
			res = res*10;
			res += number%10;
			number = number/10;
		}
		return res;
	}
	
	public static boolean isPalindrome(int number) {
		if(number == reverse(number)) return true;
		else return false;
	}
	
	public static void displaySortedNumbers(double num1, double num2, double num3) {
		double first; double second; double third;
		if(num1 <= num2 && num1 <= num3) {
			first = num1;
			if(num2 <= num3) { second = num2; third = num3;}
			else { second = num3; third = num2; }
		}
		else if(num2 < num1 && num2 <= num3) {
			first = num2;
			if(num1 <= num3) { second = num1; third = num3;}
			else { second = num3; third = num1; }
		}
		else {
			first = num3;
			if(num1 <= num2) { second = num1; third = num2;}
			else { second = num2; third = num1; }
		}
		System.out.print(first + " " + second + " " + third);
	}
	
	public static double celsiusToFahrenheit(double celsius) {
		return (9.0 / 5) * celsius + 32;
	}
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (5.0 / 9) * (fahrenheit - 32);
	}
	
	public static boolean isPrime(int num) {
		if(num == 2) return true; 
		
		int i = 2;
		while(true) {
			if(num%i == 0) return false;
			i++;
			if(i == num) return true;
		}
	}
	
	public static int countLetters(String s) {
		int cnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static int count(String str, char a) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) 
			if(str.charAt(i) == a) cnt++;
		return cnt;
	}
	
	public static boolean isPalindromicprime(int num) {
		if(isPrime(num) == true && isPalindrome(num) == true) return true;
		else return false;

////-------------먼저 만들어둔 함수 쓰지 않고 만들어 보기--------------
//		
//		if(num == 2) return true; 
//		
//		int i = 2;
//		while(true) {
//			if(num%i == 0) return false;
//			i++;
//			if(i == num)
//				if(num == reverse(num)) return true;
//		}
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Q 6.1");
		for(int i = 1; i < 10; i++) 
			System.out.println(getPentagonalNumber(i));
		System.out.println();
//===========================================
		System.out.println("Q 6.2");
		System.out.println(sumDigits(234));
		System.out.println();
//===========================================
		System.out.println("Q 6.3");
		System.out.println(reverse(456));
		System.out.println(isPalindrome(454));
		System.out.println();
//===========================================
		System.out.println("Q 6.5");
		displaySortedNumbers(3,6,2);
		System.out.println();
//===========================================
		System.out.println("Q 6.8");
		System.out.println(celsiusToFahrenheit(40.0));
		System.out.println( fahrenheitToCelsius(120.0));
		System.out.println();
//===========================================
		System.out.println("Q 6.10");
		int cnt = 0;
		for(int i = 1; i <= 10000; i++) {
			if(isPrime(i) == true) cnt++;
		}
		System.out.println(cnt);
		
		System.out.println();
//===========================================
		System.out.println("Q 6.20");
		System.out.print("Enter a String: ");
		String s = sc.next();
		System.out.println(countLetters(s));
		System.out.println();
//===========================================
		System.out.println("Q 6.23");
		System.out.println(count("Welcome", 'e'));
		System.out.println();
//===========================================
		System.out.println("Q 6.26");
		
		int j = 2;
		int cnt2 = 0;
		while(true) {
			if(isPalindromicprime(j) == true) {
				System.out.print(j + " ");
				cnt2++;
				if(cnt2%10 == 0) System.out.println();
			}
			j++; 
			
			if(cnt2 == 100) break; 
		}
		
		sc.close();
		
	}
	
}
