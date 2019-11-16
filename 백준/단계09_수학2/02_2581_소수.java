import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-07-25-수

		// 2 2581 소수
		// 문제
		// 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라
		// 이들 소수의 합과 최소값을 찾는 프로그램을 작성하시오.
		// 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83,
		// 89, 97
		// 총 8개가 있으므로, 이들 소수의 합은 620이고, 최소값은 61이 된다.

		// 입력
		// 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
		// M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

		// 출력
		// M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최소값을 출력한다.
		// 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.

		// 알고리즘 구상
		// 1. 자연수 M, N을 입력받는다. (M <= N)
		// 2. (N-M)번 반복한다.
		//  2.1. M으로부터 i번째 수 num이 소수인지 판단한다.
		//   2.1.1. (num-2)번 반복한다.
		//    2.1.1.1. num은 num을 2부터 num-1까지의 수로 각각 나누었을때 나머지가 있다면 소수가 아니다.
		//  2.2. num이 소수이면,
		//   2.2.1. 소수의 총합을 증가시킨다.
		//   2.2.2. 기존 소수의 최소값과의 비교를 통해서 갱신할지 말지를 결정한다.
		// 3. M~N 사이의 수 중, 소수의 합과 최소값를 출력한다. [소수가 없었다면 -1만 출력한다]
		
		
		// 변수 선언
		int M, N;
		int num;
		int i;
		boolean isPrimeNumber;
		int primeNumberSum=0;
		int primeNumberMin=10001;
		
		
		Scanner scan = new Scanner(System.in);
		
		// 알고리즘 수행
		// 1. 자연수 M, N을 입력받는다. (M <= N)
		M = scan.nextInt();
		N = scan.nextInt();
		
		// 2. (N-M)번 반복한다.
		for(num=M;num<=N;num++){
			// 2.1. M으로부터 i번째 수 num이 소수인지 판단한다.
			isPrimeNumber = true;
			
			// 2.1.1. (num-2)번 반복한다.
			if(num == 1) isPrimeNumber = false; // num == 1인 경우는 예외처리해준다.
			
			for(i=2;i<=num-1;i++){
				
				// 2.1.1.1. num은 num을 2부터 num-1까지의 수로 각각 나누었을때 나머지가 있다면 소수가 아니다.  
				if( num % i == 0){
					isPrimeNumber = false;
					break;
				}			
			}
			
			// 2.2. M으로부터 i번째 수 num이 소수이면,
			if(isPrimeNumber){
				// 2.2.1. 소수의 총합을 증가시킨다.
				primeNumberSum += num;
				
				// 2.2.2. 기존 소수의 최소값과의 비교를 통해서 갱신할지 말지를 결정한다.
				if(num < primeNumberMin){
					primeNumberMin =  num;
				}
			}
		}

		// 3. M~N 사이의 수 중, 소수의 합과 최소값를 출력한다. [소수가 없었다면 -1만 출력한다]
		if(primeNumberSum != 0){
			System.out.println(primeNumberSum);
			System.out.println(primeNumberMin);
		}else{
			System.out.println(-1);
		}
		
		scan.close();
	}
}