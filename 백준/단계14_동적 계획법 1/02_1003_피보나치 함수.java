import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-13-월
		
		// 2	1003	피보나치 함수
		// 문제
		// N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
		
		// 입력
		// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		// 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
		
		// 출력
		// 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
		
		Scanner s = new Scanner(System.in);
		int T;
		int N;
		int i,j;
		int f0_1, f0_2;
		int f1_1, f1_2;
		int temp0, temp1;
		
		T = s.nextInt();
		for(i=0;i<T;i++){
			N = s.nextInt();
			f0_1 = 1;
			f1_1 = 0;
			
			if(N>=1){
				f0_2 = 0;
				f1_2 = 1;
			}else{
				f0_2 = 1;
				f1_2 = 0;
			}
			
			for(j=2;j<=N;j++){
				temp0 = f0_1;
				f0_1 = f0_2;
				f0_2 = (temp0 + f0_2);
				
				temp1 = f1_1;
				f1_1 = f1_2;
				f1_2 = (temp1 + f1_2);
			}
			
			System.out.println(f0_2 + " "+f1_2);
		}
	}
}