import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        // 2019-04-10-수. 예전인 2018-08-27-월에는 분명 맞았는데
		// 나중에 보니까 시간초과로 틀려있었다.
		// 2중 for문으로 돌리는 경우는 시간초과가 나게 데이터를 바꾼 모양이다.
		// 일단 이건 질의응답에서 찾아온 알고리즘이다.
		// 알고리즘 출처 : https://www.acmicpc.net/board/view/31672

		Scanner sc = new Scanner(System.in);

		int N;
		int[] num;
		int i;

		N = sc.nextInt();
		num = new int[N];
		for (i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		int value = num[0];
		int max = value;

		for (i = 1; i < N; i++) {
			value = Math.max(num[i], num[i] + value);
			max = Math.max(value, max);
		}
		
		System.out.println(max);

		sc.close();
	}
}