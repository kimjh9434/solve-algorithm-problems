import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q6 1021 회전하는 큐

		// 2018-08-10-금

		// 문제
		// 첫번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이
		// 된다.
		// 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
		// 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.

		// 큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.
		// (이 위치는 가장 처음 큐에서의 위치이다.)
		// 이 때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.
		// N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
		// 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.
		// 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

		// 출력
		// 첫째 줄에 문제의 정답을 출력한다.

		// 간단한 고려.
		// 그냥 Boolean 형 배열을 N+1의 크기로 만든다고 치고, 0번째를 제외한 나머지를 true로 채운다.
		// 0은 그냥 비우고, 1~N 번째 인자를 그대로 숫자로 가정해도 된다.
		// start 인자가 별도로 존재. 맨처음에는 1번째지만, 나중에 바뀔 수 있다.
		// 뽑아내기를 원하는 숫자까지 도달하는데 걸리는 구간중 짧은 것을 택해서 계속 합한다.
		// 이후 해당 start 인덱스에 해당하는 값은 false로 제거.
		// 그 다음 start 인덱스는 그 다음으로 true인 인덱스로 설정.
		// 이후 계속 진행한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Boolean[] numbers;
		int[] q_numbers;

		int N, Q;
		int count;
		int i, j;
		int startIndex;
		int up, down;

		// N, Q 입력받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		// N+1개의 Boolean 배열 및, Q개의 int배열 생성
		numbers = new Boolean[N + 1];
		q_numbers = new int[Q];
		Arrays.fill(numbers, true);
		numbers[0] = false;

		// Q개의 int배열 값 받기
		st = new StringTokenizer(br.readLine());
		i = 0;
		while (st.hasMoreTokens()) {
			q_numbers[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		// Q개의 int배열 값을 순서대로 뽑아내는데 필요한 연산의 개수 세기
		startIndex = 1;
		count = 0;
		for (i = 0; i < Q; i++) {

			// 뽑아내기를 원하는 숫자까지 도달하는데 걸리는 구간중 짧은 것을 택해서 계속 합한다.
			up = down = 0;

			j = startIndex;
			while (j != q_numbers[i]) {
				if (j != N) {
					j++;
				} else {
					j = 1;
				}
				if(numbers[j]){
					up++;
				}
			}

			j = startIndex;
			while (j != q_numbers[i]) {
				if (j != 1) {
					j--;
				} else {
					j = N;
				}
				if(numbers[j]){
					down++;
				}
			}

			if (up < down) {
				count += up;
//				System.out.println(up);
			} else {
				count += down;
//				System.out.println(down);
			}

			// 이후 해당 start 인덱스에 해당하는 값은 false로 제거.
			startIndex = q_numbers[i];
			numbers[startIndex] = false;

			// 그 다음 start 인덱스는 그 다음으로 true인 인덱스로 설정.
			if(i != Q-1){
				while (!numbers[startIndex]) {
					if (startIndex != N) {
						startIndex++;
					} else {
						startIndex = 1;
					}
				}
			}
//			System.out.println(count);
		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();

	}
}