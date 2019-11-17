import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-13-월
		
		// 8	11051	이항 계수 2
		// 문제
		// 자연수 N과 정수 K가 주어졌을 때 이항 계수 (N / K)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
		
		// 입력
		// 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)
		
		// 출력
		// (N / K)를 10,007로 나눈 나머지를 출력한다.
		
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K = s.nextInt();
		
		System.out.println(nCr(N, K)%10007);
	}
	
	static long[][] nCr = new long[1001][1001];
	public static long nCr(int n, int r){
		if(nCr[n][r] > 0){
			return nCr[n][r];
		}
		
		if(r==0 || n==r){
			nCr[n][r] = 1;
			return nCr[n][r];
		}
		
		nCr[n][r] = (nCr(n-1, r-1) + nCr(n-1, r)) % 10007;
		return nCr[n][r];
	}
}