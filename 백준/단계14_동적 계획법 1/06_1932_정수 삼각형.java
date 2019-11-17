import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-08-17-금

		// 6 1932 정수 삼각형

		// 문제
		// 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는
		// 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것
		// 중에서만 선택할 수 있다.
		
		// 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

		// 입력
		// 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

		// 출력
		// 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.

		Scanner sc = new Scanner(System.in);
		int N;
		int[][] trialgle;
		int[][] sum;
		int i, j;
		int Max;

		// init
		N = sc.nextInt();
		trialgle = new int[N][N];
		sum = new int[N][N];

		for (i = 0; i < N; i++) {
			for (j = 0; j <= i; j++)
				trialgle[i][j] = sc.nextInt();
		}

		// solve
		sum[0][0] = trialgle[0][0];

		for (i = 1; i < N; i++) {
			sum[i][0] = sum[i-1][0] + trialgle[i][0];
			for (j = 1; j < i; j++) {
				Max = Math.max(sum[i - 1][j-1], sum[i - 1][j]);
				sum[i][j] = Max + trialgle[i][j];
			}
			sum[i][i] = sum[i-1][i-1] + trialgle[i][i];
		}

		// 최대값 출력
		Max = sum[N - 1][0];
		for (j = 0; j < N; j++) {
			if (Max < sum[N - 1][j])
				Max = sum[N - 1][j];
		}
		System.out.println(Max);
	}
}