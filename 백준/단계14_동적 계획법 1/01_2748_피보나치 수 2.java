import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q	2747	피보나치 수   (n<=45)
		// Q	2748	피보나치 수 2 (n<=90)
		
		// 2018-08-11-토
		// n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
		
		// 첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
		// 첫째 줄에 n번째 피보나치 수를 출력한다.
		
		Scanner scan = new Scanner(System.in);
		
		// int[] fibo = new int[45];  // Q1
		long[] fibo = new long[90];   // Q2
		fibo[0] = fibo[1] = 1; // fibo(1) = fibo(2) = 1
		
		for(int i=2;i<fibo.length;i++){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[scan.nextInt()-1]);
	}
}