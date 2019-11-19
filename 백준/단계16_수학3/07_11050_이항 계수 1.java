import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-13-월
		
		// 7	11050	이항 계수 1
		// 문제
		// 자연수 N과 정수 K가 주어졌을 때 이항 계수 (N / K)를 구하는 프로그램을 작성하시오.
		
		// 입력
		// 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
		// 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
		
		// 출력
		// (N / K)를 출력한다.
		
		
		// 기본적으로, n개의 공 중에서,r개의 공을 뽑는 경우의 수는 조합문제로,
		// 어떤 특정 공 X가 있다고 할때, 그 공을 뽑는 경우와 안뽑는 경우로 나눌수가 있다.
		// 뽑는 경우는, 그 공을 미리 뽑았다고 가정하고, 남은 n-1개의 공 중에서 r-1개의 공을 뽑는 경우와 같으며,
		// 안뽑은 경우는, 남은 n-1개의 공 중에서 r개의 공을 뽑는 경우와 같다.
		// 따라서   nCr = (n-1)C(r-1) + (n-1)Cr 이다. 
		
		// 이를 메모이제이션 방법으로 구현하면 다음과 같다.
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K = s.nextInt();
		
		System.out.println(nCr(N, K));
	}
	
	static long[][] nCr = new long[11][11];
	public static long nCr(int n, int r){
		if(nCr[n][r] > 0){
			return nCr[n][r];
		}
		
		if(r==0 || n==r){
			nCr[n][r] = 1;
			return nCr[n][r];
		}
		
		nCr[n][r] = nCr(n-1, r-1) + nCr(n-1, r);
		return nCr[n][r];
	}
}