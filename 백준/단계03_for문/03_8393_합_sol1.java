import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    // Q3	8393	합 : n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int sum=0;
		
		// 방법1. 걍 더한다.
		for(int i=1;i<=N;i++){
			sum+=i;
		}
		
		System.out.println(sum);
    }
}