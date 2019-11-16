import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        // Q4 1193 분수찾기
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int max_N = 0;
		int min_N = 0;
		int line = 0;

		// 1. 일단 이 N이 몇번째 line 인지 구한다.
		while (true) {
			max_N = max_N + line;

			if (min_N <= N && N <= max_N) {
				break;
			}
			min_N = max_N + 1;
			line++;
		}
//		System.out.println(line);

		// 2. 구한 line이 홀수이면, 대각선 위로 올라가고, 짝수이면 대각선 아래로 내려간다.
		int sum = line + 1; // i와 j의 합
		int i, j;
//		System.out.println("sum : " + sum);
//		System.out.println("max_N : " + max_N);
//		System.out.println("min_N : " + min_N);
		if (line % 2 == 1) {
//			System.out.println("홀수열");
			// 2.1 line이 홀수이면, 대각선 위로 올라가므로
			// i는 min과 N과의 차이값 +1 이된다.
			i = N - min_N + 1;// 14-11+1=4
			j = sum - i;
		} else {
//			System.out.println("짝수열");
			// 2.2 line이 짝수이면, 대각선 아래로 내려가므로
			// j는 min과 N과의 차이값 +1 이된다.
			i = max_N - N + 1;
			j = sum - i;
		}
		// i = 행. j = 열.
		System.out.println(j + "/" + i);
		scan.close();
	}
}