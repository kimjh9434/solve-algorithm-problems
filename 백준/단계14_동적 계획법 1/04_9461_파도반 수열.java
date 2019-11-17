import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-08-27-월

		// 04 9461 파도반 수열

		// 문제
		// 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
		// P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

		// N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

		// 출력
		// 각 테스트 케이스마다 P(N)을 출력한다.

		// 느낌상,P(N) = P(N-1) + P(N-5) 같다???

		Scanner sc = new Scanner(System.in);

		long[] num = new long[101];
		int T;
		int i;

		num[1] = num[2] = num[3] = 1;
		num[4] = num[5] = 2;

		for (i = 6; i <= 100; i++) {
			num[i] = num[i - 1] + num[i - 5];
		}
		
//		for (i = 0; i <= 100; i++) {
//			System.out.println(num[i]);
//		}

		T = sc.nextInt();

		for (i = 0; i < T; i++) {
			System.out.println(num[sc.nextInt()]);
		}

		sc.close();
	}
}