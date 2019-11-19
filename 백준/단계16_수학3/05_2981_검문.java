import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// 2018-08-28-화

		// 5 2981 검문

		// 문제 : 먼저 근처에 보이는 숫자 N개를 종이에 적는다.
		// 그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두 찾으려고 한다.
		// M은 1보다 커야 한다. N개의 수가 주어졌을 때, 가능한 M을 모두 찾는 프로그램을 작성하시오.

		// 입력 : 첫째 줄에 종이에 적은 수의 개수 N이 주어진다. (2 ≤ N ≤ 100)

		// 다음 줄부터 N개 줄에는 종이에 적은 수가 하나씩 주어진다.
		// 이 수는 모두 1보다 크거나 같고, 1,000,000,000보다 작거나 같은 자연수이다.
		// 같은 수가 두 번 이상 주어지지 않는다.

		// 항상 M이 하나 이상 존재하는 경우만 입력으로 주어진다.

		// 출력 : 첫째 줄에 가능한 M을 공백으로 구분하여 모두 출력한다. 이 때, M은 증가하는 순서이어야 한다.

		// 이건 질문 게시판에 있던 코드이다.
		// https://www.acmicpc.net/board/view/11630
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		int[] array;
		int[] numbers;
		int mod;
		int i;
		
		// n size 입력
		N = Integer.parseInt(reader.readLine());

		// 배열에 입력 후 정렬
		array = new int[N];
		for (i = 0; i < N; i++)
			array[i] = Integer.parseInt(reader.readLine());
		Arrays.sort(array);

		// 가장 큰값에서 가장 작은 값을 뺀 값의, 1을 제외한 모든 약수를 구함
		numbers = dividers(array[array.length - 1] - array[0]);

		// System.out.println("numbers:");
		// for(int a : numbers)System.out.print(String.valueOf(a) + " ");
		// System.out.println("\n");

		// 약수로 나누어서 나머지가 같은 경우 찾기
		for (int num : numbers) {
			boolean add = true;
			mod = array[0] % num;
			for (i = 1; i < array.length; i++) {
				if (array[i] % num != mod) {
					// System.out.println(String.valueOf(array[i]) + " % " +
					// String.valueOf(mod) + " = " + String.valueOf(array[i] %
					// mod));
					add = false;
					break;
				}
			}
			if (add) {
//				System.out.print(num + " ");
				writer.write(String.valueOf(num) + " ");
			}
		}
		writer.flush();
		writer.close();
	}

	private static int[] dividers(int num) {
		List<Integer> list = new LinkedList<>();
		list.add(num);
		int i;
		for (i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				list.add(i);
				list.add(num / i);
			}
		}
		if (i == Math.sqrt(num) && num % i == 0)
			list.add(i);
		Collections.sort(list);

		int[] result = new int[list.size()];
		for (i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		return result;
	}
}