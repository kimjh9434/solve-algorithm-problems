import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 2018-08-21-화
		// 9 10844 쉬운 계단 수
		// N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

		// 입력
		// 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

		// 출력
		// 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

		Scanner sc = new Scanner(System.in);

		int N;
		long[][] numbers;
		int i, j;
		long sum;

		N = sc.nextInt();
		numbers = new long[N][10];

		for (j = 1; j < 10; j++) {
			numbers[0][j] = 1;
		}
		for (i = 1; i < N; i++) {
			numbers[i][0] = numbers[i - 1][1];
			for (j = 1; j <= 8; j++) {
				numbers[i][j] = (numbers[i - 1][j - 1] + numbers[i - 1][j + 1]) % 1000000000;
			}
			numbers[i][9] = numbers[i - 1][8];
		}
		sum = 0;
		for (j = 0; j < 10; j++) {
			sum = ( sum + numbers[N - 1][j] ) % 1000000000;
		}
		System.out.println(sum);

		sc.close();
	}
}