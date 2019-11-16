import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		// 2018-07-25-수

		// 3 1929 소수 구하기
		// 문제
		// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1000000)

		// 출력
		// 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
        

		// 알고리즘 구상 - 3차 시도. '에라토스테네스의 체'
		// ArrayList던 LinkedList던간에 이거 때문에 오래걸리는것 같다.
		// 그냥 쌩 배열로 만들고, O(1)로 접근해야겠다.
		// 그렇다면 크기를 그냥 boolean형 배열 1000000짜리로 만들어버라고
		// 소수인지 여부를 true, false로 판단해나가야겠다.

		// 1. 자연수 M, N을 입력받는다. (M <= N)
		// 2. 소수가 N의 제곱근보다 작은거나 같은 동안 반복한다.
		// 2.1. 배열에서 가장 작은 값을 소수로 얻는다.
		// 2.2. 얻은 소수는 소수인 배열에 추가한다.
		// 2.3. ArrayList에서 소수의 배수인 수를 지운다.
		// 3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		// 4. 소수인 배열에서 M~N사이의 수를 출력시킨다.

		// 변수 선언
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M, N;
		Boolean[] notPrimeNumbers = new Boolean[1000001];// 1~1000000사이의 수에 대한 소수 판별
		Arrays.fill(notPrimeNumbers, true); // 모두 true로 초기화한다.
		int[] primeNumbers = new int[1000000];
		int primeNum = 2;
		int npnIndex = 1, pnIndex = 0, tmpIndex;
		int num, lastNum;
		int Max;
		
//		int count;
		
		// 알고리즘 수행
		// 1. 자연수 M, N을 입력받는다. (M <= N)
		M = scan.nextInt();
		N = scan.nextInt();

		// 2. 소수가 N의 제곱근보다 작은거나 같은 동안 반복한다.
		Max = (int) Math.sqrt(N);
		
		while (npnIndex <= Max) {
			// 2.1. 배열에서 가장 작은 값을 소수로 얻는다.
			while (!notPrimeNumbers[npnIndex]) {
				npnIndex++;
			}
			primeNum = npnIndex + 1;
			npnIndex++;

			// 2.2. 얻은 소수는 소수인 배열에 추가한다.
			primeNumbers[pnIndex] = primeNum;
			pnIndex++;

			// 2.3. 소수가 아닌 수의 배열에서 소수의 배수인 수를 지운다.
			tmpIndex = N-1;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex--;
			}
			lastNum = tmpIndex + 1;

			tmpIndex = npnIndex;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex++;
			}
			num = tmpIndex + 1;

			while (num <= N) {
				if (num % primeNum == 0) {
					notPrimeNumbers[tmpIndex] = false;
//					System.out.println(num+"은 " + primeNum+"으로 나누어 떨어지므로 소수가 아니다.");
				}else{
//					System.out.println(num+"은 " + primeNum+"으로 나누어 떨어지 않으므로 소수일 수도 있다.");
				}
				//System.out.println("tmpIndex : " + tmpIndex);
				//System.out.println("notPrimeNumbers[tmpIndex] : " + notPrimeNumbers[tmpIndex]);
				tmpIndex++;
				while (!notPrimeNumbers[tmpIndex]) {
					tmpIndex++;
				}
				num = tmpIndex + 1;
				//System.out.println("num : " + num);
			}
		}
		
		// 3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		while (npnIndex != 1000001) {
//			System.out.println(npnIndex);
			while (!notPrimeNumbers[npnIndex]) {
				npnIndex++;
			}
			primeNumbers[pnIndex] = npnIndex + 1;
			pnIndex++;
			npnIndex++;
		}
		
//		count=0;
		// 4. 소수인 배열에서 M~N사이의 수를 출력시킨다.
		pnIndex = 0;
		for (int i = 0; primeNumbers[i] != 0 ; i++) {
			num = primeNumbers[i];
			
			if (M <= num && num <= N) {
				bw.write((num) + "\n");
//				count++;
			} else if (N < num) {
				break;
			}
		}
//		bw.write(count + "\n");
		
		scan.close();
		bw.flush();
		bw.close();
	}
}