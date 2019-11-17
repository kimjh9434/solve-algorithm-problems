import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-08-28-화

		// 4	2609	최대공약수와 최소공배수

		// 문제 : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

		// 입력 : 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
		
		// 출력 : 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

		// 풀이 방법 : 유클리드 호제법을 통해서 A, B의 최대공약수를 구한 후,
		// 이를 통해서 최대공약수도 구한다.

		Scanner sc = new Scanner(System.in);

		long A, B;
		long gcd, lcd;
		
		A = sc.nextLong();
		B = sc.nextLong();

		gcd = gcd(A, B);

		lcd = gcd * (A / gcd) * (B / gcd);
		
		System.out.println(gcd);
		System.out.println(lcd);

		sc.close();
	}

	public static long gcd(long p, long q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}
}