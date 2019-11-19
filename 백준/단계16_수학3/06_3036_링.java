import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-08-28-화

		// 6 3036 링

		// 문제 : 링의 반지름이 주어진다.
		// 이 때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.

		// 입력 : 첫째 줄에 링의 개수 N이 주어진다. (3 ≤ N ≤ 100)
		// 다음 줄에는 링의 반지름이 상근이가 바닥에 놓은 순서대로 주어진다. 반지름은 1과 1000를 포함하는 사이의 자연수이다.

		// 출력 : 출력은 총 N-1줄을 해야 한다. 
		// 첫 번째 링을 제외한 각각의 링에 대해서, 첫 번째 링을 한 바퀴 돌리면 그 링은 몇 바퀴 도는지 기약 분수 형태 A/B로 출력한다.

		
		// 풀이 구상
		// 음... 그냥 나누면 되는거 아닌가?...
		// 그냥 첫번째 링과 i번째 링의 최소공배수를 구하고 각각 나눠줘서 출력하면 되는것 같다.
		
		Scanner sc = new Scanner(System.in);
		
		int N;
		long[] ring;
		long gcd;
		int i;
		
		N = sc.nextInt();
		ring = new long[N];
		
		for(i=0;i<N;i++){
			ring[i] = sc.nextLong();
		}
		
		
		for(i=1;i<N;i++){
			gcd = gcd(ring[0], ring[i]);
			System.out.println(String.format("%d/%d", (ring[0]/gcd),(ring[i]/gcd)));
		}
		
		sc.close();
	}

	public static long gcd(long p, long q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}
}