import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// 2018-07-26-목

		// Q4 4948 베르트랑 공준
		// 문제
		// 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고
		// 있다.
		// n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

		// 입력
		// 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤
		// 123456)
		// 입력의 마지막에는 0이 주어진다.

		// 출력c
		// 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.

		// 알고리즘 구상 - 전에 풀었던 문제인 Q3_소수구하기의 '에라토스테네스의 체' 방법을 이용한다.
		// 이번에도 그냥 쌩 배열로 만들고, O(1)로 접근해야겠다.

		// 여기서는 n ≤ 123456 이라고 하므로, 2n ≤ 246912 이므로
		// 그렇다면 크기를 그냥 boolean형 배열 246912짜리로 만들어버라고
		// 소수인지 여부를 true, false로 판단해나가도 된다.

		// 1. 1~246912의 수 중에서 소수인 수들을 찾는다.
		// 1.2. 인덱스가 246913의 제곱근보다 작은거나 같은 동안 반복한다.
		// 1.2.1. 배열에서 가장 작은 값을 소수로 얻는다.
		// 1.2.2. 얻은 소수는 소수인 배열에 추가한다.
		// 1.2.3. 소수가 아닌 수의 배열에서 소수의 배수인 수를 지운다.
		// 1.3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		// 2. 입력받는 수가 0이 아닌동안 반복한다.
		// 2.1. 자연수 N을 입력받는다. (n ≤ 123456)
		// 2.2. 소수인 배열에서 N < ~ <= 2N 인 소수의 개수를 센다.
		// 2.3. 소수인 배열에서 N < ~ <= 2N 인 개수를 출력시킨다.

		// 변수 선언
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = -1;
		Boolean[] notPrimeNumbers = new Boolean[246913];// 1~246912 사이의 수에 대한 소수
														// 판별
		Arrays.fill(notPrimeNumbers, true); // 모두 true로 초기화한다.
		int[] primeNumbers = new int[246912];
		int primeNum = 2;
		int npnIndex = 1, pnIndex = 0, tmpIndex;
		int num, lastNum;
		int Max;

		int count;

		// 알고리즘 수행
		// 1. 1~246912의 수 중에서 소수인 수들을 찾는다.
		// 1.2. 인덱스가 246913의 제곱근보다 작은거나 같은 동안 반복한다.
		Max = (int) Math.sqrt(246913);

		while (npnIndex <= Max) {
			// 1.2.1. 배열에서 가장 작은 값을 소수로 얻는다.
			while (!notPrimeNumbers[npnIndex]) {
				npnIndex++;
			}
			primeNum = npnIndex + 1;
			npnIndex++;

			// 1.2.2. 얻은 소수는 소수인 배열에 추가한다.
			primeNumbers[pnIndex] = primeNum;
			pnIndex++;

			// 1.2.3. 소수가 아닌 수의 배열에서 소수의 배수인 수를 지운다.
			tmpIndex = 246912 - 1;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex--;
			}
			lastNum = tmpIndex + 1;

			tmpIndex = npnIndex;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex++;
			}
			num = tmpIndex + 1;

			while (num <= 246912) {
				if (num % primeNum == 0) {
					notPrimeNumbers[tmpIndex] = false;
					// System.out.println(num+"은 " + primeNum+"으로 나누어 떨어지므로 소수가
					// 아니다.");
				} else {
					// System.out.println(num+"은 " + primeNum+"으로 나누어 떨어지 않으므로
					// 소수일 수도 있다.");
				}
				// System.out.println("tmpIndex : " + tmpIndex);
				// System.out.println("notPrimeNumbers[tmpIndex] : " +
				// notPrimeNumbers[tmpIndex]);
				tmpIndex++;
				while (!notPrimeNumbers[tmpIndex]) {
					tmpIndex++;
				}
				num = tmpIndex + 1;
				// System.out.println("num : " + num);
			}
		}

		// 1.3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		while (npnIndex != 246913) {
			while (!notPrimeNumbers[npnIndex]) {
				npnIndex++;
			}
			primeNumbers[pnIndex] = npnIndex + 1;
			pnIndex++;
			npnIndex++;
		}

		// 2. 입력받는 수가 0이 아닌동안 반복한다.
		while (true) {
			// 2.1. 자연수 N을 입력받는다. (n ≤ 123456)
			N = scan.nextInt();
			if (N == 0)
				break;
			count = 0;

			// 2.2. 소수인 배열에서 N < ~ <= 2N 인 소수의 개수를 센다.
			pnIndex = 0;
			for (int i = 0; primeNumbers[i] != 0; i++) {
				num = primeNumbers[i];

				if (N < num && num <= 2 * N) {
					// bw.write((num) + "\n");
					count++;
				} else if (N < num) {
					break;
				}
			}
			// 2.3. 소수인 배열에서 N < ~ <= 2N 인 소수의 개수를 출력시킨다.
			bw.write(count + "\n");
			bw.flush();
		}

		scan.close();
		bw.close();
	}
}