import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-14-화
		// 10	1676	팩토리얼 0의 개수
		
		// 문제 : N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
		// 입력 : 첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
		// 출력 : 첫째 줄에 구한 0의 개수를 출력한다.

		// 대충 생각. N! 자체를 다 구하는 방법은 미친 방법이다.
		
		// 아이디어는 1~N까지의 숫자 중, 곱해지는 수들에서 2와5가 곱해지는 갯수를 세서, 
        // 2의 갯수와 5의 갯수 중 적은 것을 출력하는 것이다.
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int cnt2=0, cnt5=0;
		int min;
		int i,j;
		
		if(N>0){
			for(i=2;i<=N;i++){
				j = i;
				while (j % 2 == 0)
				{
					j /= 2;
					cnt2++;
				}
				while (j % 5 == 0)
				{
					j /= 5;
					cnt5++;
				}
			}
		}
//		System.out.println(cnt2 + " " + cnt5);
		if(cnt2 < cnt5){
			min = cnt2;
		}else{
			min = cnt5;
		}
		System.out.println(min);
	}
}