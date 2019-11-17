import java.util.Scanner;
    
public class Main {

	public static void main(String[] args) {
		// 2018-08-22-수 ~ 2018-08-23-목

		// 10 2156 포도주 시식

		// 문제
		// 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을
		// 작성하시오.

		// 규칙
		// 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
		// 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.

		// 입력
		// 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1≤n≤10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는
		// 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.

		// 출력
		// 첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.

		// 대략적인 생각.
		// Q4의 계단 오르기 문제와 똑같내... 라고 생각했지만, 작은 차이가 있었다. => 계속 차이가 보인다...

		// 1. 계단문제는 에초에 최종 계단을 꼭 밟아야 하지만, 이 경우는 꼭 밟을 필요는 없다.
		// => 그렇다면, N번째 포도주를 마지막으로 마실수도 있고, N-1번째 포도주를 마실수도 있으므로,
		// 총 4가지 경우 중에서 가장 큰 값이 가장 많이 마시는 경우이다.

		// 틀렸다... 반례를 보며 든 생각은,
		// 2. 적어도 계단 오르기에서는 0의 값이 존재하지 않았지만 여기서는 존재한다는 점이 결정적인 차이였다.
		// 0이면 아예 고려 할 필요도 없이 넘어가야 했다.

		// 3. 또다른 결정적인 차이가 존재했는데, 전에는 1,2 칸만 이동할 수 있었으나,
		// 이번에는 굳이 그런 제약이 없어졌다는 거다. 가령 3 3 1 0 0 0 1 3 3 의 경우, 정답은 12가 나와야 한다.
		// 10 3 0 0 3 8 1 1 3 2 0 같은 경우는, 3,3,8,3,2 를 택해서 19가 나와야 한다.
		// 중간의 1, 1의 값이 있지만 선택하면 안되었다.

		// 단순하면 바로 풀려고 했는데... 다음날로 미뤄야겠다.

		// 다음날인 2018-08-23-목 에 하는 생각.
		// 음... 그냥 단순하게 1칸, 2칸 건너띄기 말고도 3칸 건너뛰는 경우도 만들으면 안되나?
		// 대충 테스트 해본 결과 4칸 뛰어야 할 상황까진 필요 없는듯...

		/*
		 * 11 1 3 3 1 0 0 0 1 3 3 1
		 * 
		 * 8 7 7 0 5 7 7 0 3 10 3 0 0 3 8 1 1 3 2 0 11 3 0 0 3 8 1 1 1 3 2 0 11
		 * 3 0 0 3 8 1 0 1 3 2 0
		 */

		Scanner sc = new Scanner(System.in);
		int N;
		int[] wine; // 계단
		int[][] sum; // 합
		int i;
		int M1, M2, M3;
		int Max;
		int zeroCount;

		// init
		N = sc.nextInt();
		wine = new int[N];
		sum = new int[N][3];

		for (i = 0; i < N; i++) {
			wine[i] = sc.nextInt();
		}

		// solve
		sum[0][0] = wine[0]; // 1칸 뛰기
		if (N >= 2) {
			sum[1][0] = wine[0] + wine[1];
			sum[1][1] = wine[1]; // 2칸 뛰기
		}
		if (N >= 3) {
			sum[2][0] = wine[0] + wine[2];
			sum[2][1] = wine[1] + wine[2];
			sum[2][2] = wine[2]; // 3칸 뛰기
		}
		
		zeroCount = 0;
		for (i = 3; i < N; i++) {
			if(wine[i]!=0){
				M1 = Math.max(sum[i - 3][0], sum[i - 2][0]);
				M2 = Math.max(sum[i - 3][1], sum[i - 2][1]);
				M3 = Math.max(sum[i - 3][2], sum[i - 2][2]);
				
				Max = Math.max(M1, Math.max(M2, M3));
				
				if((i+zeroCount) % 2 == 1){
					sum[i][0] = wine[i] + sum[i - 1][0];
					sum[i][1] = wine[i] + Max;
					sum[i][2] = wine[i] + sum[i - 1][2];
				}else{
					sum[i][0] = wine[i] + Max;
					sum[i][1] = wine[i] + sum[i - 1][1];
					sum[i][2] = wine[i] + Max;
				}
				zeroCount=0;
			}else{
				M1 = Math.max(sum[i - 2][0], sum[i - 1][0]);
				M2 = Math.max(sum[i - 2][1], sum[i - 1][1]);
				M3 = Math.max(sum[i - 2][2], sum[i - 1][2]);
				
				Max = Math.max(M1, Math.max(M2, M3));
				
				sum[i][0] = Max;
				sum[i][1] = Max;
				sum[i][2] = Max;
				
				while(wine[i]!=0){
					sum[i][0] = Max;
					sum[i][1] = Max;
					sum[i][2] = Max;
					zeroCount++;
					i++;
				}
			}
		}

		// 최대값 출력
		if (N == 1) {
			Max = sum[0][0];
		} else if (N == 2) {
			Max = sum[1][0];
		} else {
			M1 = Math.max(sum[N - 2][0], sum[N - 1][0]);
			M2 = Math.max(sum[N - 2][1], sum[N - 1][1]);
			M3 = Math.max(sum[N - 2][2], sum[N - 1][2]);
			// System.out.println(M1);
			// System.out.println(M2);
			// System.out.println(M3);
			Max = Math.max(M1, Math.max(M2, M3));
		}

		System.out.println(Max);

		sc.close();
	}
}