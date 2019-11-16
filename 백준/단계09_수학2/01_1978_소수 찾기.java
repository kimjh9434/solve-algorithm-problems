import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-07-25-수
		
		// Q1	1978	소수 찾기
		// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
		
		// 입력
		// 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

		// 출력
		// 주어진 수들 중 소수의 개수를 출력한다.

		
		// 알고리즘 구상
		// 1. 자연수 N을 입력받는다.
		// 2. N번 반복한다.
		//  2.1. N번째 수 num을 입력받는다. 
		//  2.2. 입력받은 수 num이 소수인지 판단한다.
		//    2.2.1. (num-2)번 반복한다.
		//     2.2.1.1. num은 num을 2부터 num-1까지의 수로 각각 나누었을때 나머지가 있다면 소수가 아니다.  
		//  2.3. 입력반은 수 num이 소수이면 소수의 개수를 증가시킨다.
		// 3. 입력받은 N개의 수 중, 소수의 개수를 출력한다.

		Scanner scan = new Scanner(System.in);
		int N;
		int num;
		int i,j;
		boolean isPrimeNumber;
		int primeNumberCount=0;

		// 1. N을 입력받는다.
		N = scan.nextInt();
		
		// 2. N번 반복한다.
		for(i=0;i<N;i++){
			// 2.1. N번째 수 num을 입력받는다. 
			num = scan.nextInt();
			isPrimeNumber = true;
			
			// 2.2. 입력받은 수 num이 소수인지 판단한다.
			// 2.2.1. (num-2)번 반복한다.
			if(num == 1) isPrimeNumber = false; // num == 1인 경우는 예외처리해준다.
			
			for(j=2;j<=num-1;j++){
				
				// 2.2.1.1. num은 num을 2부터 num-1까지의 수로 각각 나누었을때 나머지가 있다면 소수가 아니다.  
				if( num % j == 0){
					isPrimeNumber = false;
					break;
				}			
			}
			
			// 2.3. 입력반은 수 num이 소수이면 소수의 개수를 증가시킨다.
			if(isPrimeNumber){
				primeNumberCount++;
			}
		}
		
		// 3. 입력받은 N개의 수 중, 소수의 개수를 출력한다.
		System.out.println(primeNumberCount);
		
		scan.close();
	}
}