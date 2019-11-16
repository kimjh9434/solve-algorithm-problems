import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// 2018-07-27-금

		// Q5 9020 골드바흐의 추측
        
		// 문제
		// 골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.
		// 이러한 숫자를 골드바흐 숫자라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 숫자의 골드바흐 파티션이라고 한다.
		// 예를들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7,
		// 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

		// 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐
		// 파티션이 여러가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

		// 입력
		// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다. 
		// (4 ≤ n ≤ 10,000)

		// 출력
		// 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 
		// 공백으로 구분한다.

		// 알고리즘 구상 - 전에 풀었던 문제인 Q3_소수구하기의 '에라토스테네스의 체' 방법을 이용한다.
		// 이번에도 그냥 쌩 배열로 만들고, O(1)로 접근해야겠다.

		// 여기서는 n ≤ 10000 이라고 하므로,
		// 그렇다면 크기를 그냥 boolean형 배열 10000짜리로 만들어버라고
		// 소수인지 여부를 true, false로 판단해나가도 된다.

		// 1. 1~10000의 수 중에서 소수인 수들을 찾는다.
		// 1.2. 인덱스가10000의 제곱근보다 작은거나 같은 동안 반복한다.
		// 1.2.1. 배열에서 가장 작은 값을 소수로 얻는다.
		// 1.2.2. 얻은 소수는 소수인 배열에 추가한다.
		// 1.2.3. 소수가 아닌 수의 배열에서 소수의 배수인 수를 지운다.
		// 1.3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		// 2. 테스트 케이스의 개수 T를 입력받는다.
		// 3. T번 반복한다.
		// 3.1. 자연수 N을 입력받는다. (n ≤ 10000)
		// 3.2. 소수인 배열에서 N보다 작은 소수의 개수를 센다.
		// 3.3. 소수인 배열에서 N보다 작은 소수의 개수만큼 반복한다.
		// 3.3.1. (N-i번째 소수)의 값이 소수인 배열에 존재하면, 그것이 주어진 n의 골드바흐 파티션이다.
		// 3.4. 주어진 n의 골드바흐 파티션을 출력한다.

		// 변수 선언
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T, N = -1;
		Boolean[] notPrimeNumbers = new Boolean[10001];// 1~10000 사이의 수에 대한 소수판별
		Arrays.fill(notPrimeNumbers, true); // 모두 true로 초기화한다.
		int[] primeNumbers = new int[10000];
		int primeNum = 2;
		int npnIndex = 1, pnIndex = 0, tmpIndex;
		int num, lastNum;
		int Max;

		int count;
		int gap;
		int goldNum1, goldNum2;
		boolean isExist;
		int i, j, k;

		// 알고리즘 수행
		// 1. 1~10000의 수 중에서 소수인 수들을 찾는다.
		// 1.2. 인덱스가 10000의 제곱근보다 작은거나 같은 동안 반복한다.
		Max = (int) Math.sqrt(10000);

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
			tmpIndex = 10000 - 1;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex--;
			}
			lastNum = tmpIndex + 1;

			tmpIndex = npnIndex;
			while (!notPrimeNumbers[tmpIndex]) {
				tmpIndex++;
			}
			num = tmpIndex + 1;

			while (num <= 10000) {
				if (num % primeNum == 0) {
					notPrimeNumbers[tmpIndex] = false;
				} else {
				}
				tmpIndex++;
				while (!notPrimeNumbers[tmpIndex]) {
					tmpIndex++;
				}
				num = tmpIndex + 1;
			}
		}

		// 1.3. 소수가 아닌 수에서 남은 수들은 모두 소수이므로 소수인 배열에 추가시킨다.
		while (npnIndex != 10001) {
			while (!notPrimeNumbers[npnIndex]) {
				npnIndex++;
			}
			primeNumbers[pnIndex] = npnIndex + 1;
			pnIndex++;
			npnIndex++;
		}

		// 2. 테스트 케이스의 개수 T를 입력받는다.
		T = scan.nextInt();

		

		// 3. T번 반복한다.
		for(i=0;i<T;i++) {
			// 3.1. 자연수 N을 입력받는다. (n ≤ 10000)
			N = scan.nextInt();
			count = 0;

			// 3.2. 소수인 배열에서 N보다 작은 소수의 개수를 센다.
			pnIndex = 0;
			for (j = 0; primeNumbers[j] != 0; j++) {
				num = primeNumbers[j];

				if (num < N) {
					count++;
				} else {
					break;
				}
			}
			
			// 3.3. 소수인 배열에서 N보다 작은 소수의 개수만큼 반복한다.
			gap = 10000;
			goldNum1 = 0;
			goldNum2 = 0;
			for(j=0;j<count;j++){
				// 3.3.1. (N-i번째 소수)의 값이 소수인 배열에 존재하면, 그것이 주어진 n의 골드바흐 파티션이다.
				num = N-primeNumbers[j];
				
//				System.out.println(primeNumbers[j] +","+num);
				isExist = false;
				for(k=0;k<count;k++){
					if(num == primeNumbers[k]){
//						System.out.println(primeNumbers[k]);
						isExist = true;
						break;
					}
				}
//				System.out.println(num +","+primeNumbers[j]);
				if(isExist && 0 <= (num - primeNumbers[j]) && (num - primeNumbers[j]) < gap){
					goldNum1 = primeNumbers[j];
					goldNum2 = num;
					gap = goldNum2 - goldNum1;
//					System.out.println(gap+","+ goldNum1 + " " + goldNum2);
				}
				
			}
			// 3.4. 주어진 n의 골드바흐 파티션을 출력한다.
			//bw.write("==============\n");
			bw.write(goldNum1 + " " + goldNum2 +"\n");
			bw.flush();
		}
		

		scan.close();
		bw.close();
	}
}