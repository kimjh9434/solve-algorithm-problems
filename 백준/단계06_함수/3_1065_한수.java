import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-09-17-월

		// 3 1065 한수

		// 문제
		// 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
		// 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
		// N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

		// 출력
		// 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

		// 풀이 방법 - Step05_함수의 2번째 문제의 코드를 가져왔다.
		// 이후 살~짝만 수정함.

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count_oneNumber = 0;
		// 기본 개념. '한수' 라는 것이 각 자리수가 등차수열을 이루는 것이라고 했는데
		// 등차수열이라는 개념 자체가 3개 이상의 수가 있어야 가능하다.
		// 따라서 99이하의 수는 한수의 개수가 N 그 자체이며, 100 이상부터 한수의 개수를 추가로 파악해야 한다.

		int i;
		
		// N이 99이하인 경우,
		if (N < 100) { 
			count_oneNumber = N; // 그때까지 한수의 개수는 N개이다.
		}
		
		// N이 100이상인 경우,
		else if (N >= 100) { 
			count_oneNumber = 99; // 한수의 개수는 99개 이상.
			for (i = 111; i <= N; i++) {
				// i번째 수가 한수이면,
				if (isOneNumber(i)) {
					count_oneNumber++;// 한수의 개수를 증가시킨다.
				}
			}
		}
		
		// 최종적으로 구해진 1~N사이 한수의 개수를 출력한다.
		System.out.println(count_oneNumber);

		sc.close();
	}

	// 입력 받은 어떤 수가 한수가 맞는지 아닌지 판단하는 함수
	public static boolean isOneNumber(int number) {
		boolean isOneNumber = false;

		// 입력받은 number가 한수인지 아닌지 확인하기 위해서는
		// number의 각 자리 숫자를 구한 뒤,
		int num_100 = number / 100;// 100의 자리 숫자
		number = number - (num_100 * 100);
		int num_10 = number / 10; // 10의 자리 숫자
		number = number - (num_10 * 10);
		int num_1 = number; // 1의 자리 숫자

		// 100의 자리와 10의 자리, 10의 자리와 1의 자리의 차이값이 같은 경우.
		if ((num_100 - num_10 == num_10 - num_1)) {
			isOneNumber = true;// 한수가 맞음.
		}
		return isOneNumber;
	}
}