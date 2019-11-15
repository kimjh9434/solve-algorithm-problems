import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    // Q3	8393	합 : n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
		// 방법2. 간단 공식 적용
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int sum = N*(N+1)/2;
		System.out.println(sum);
    }
}
