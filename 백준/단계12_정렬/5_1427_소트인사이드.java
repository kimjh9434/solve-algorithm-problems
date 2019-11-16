import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		// Q5	1427	소트인사이드 : 2018-07-24-화
		// 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
		
		// 입력 : 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
		// 출력 : 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
		
		// 필요한 단계들
		// 1. N을 문자열로 입력받는다.
		// 2. 문자열의 길이만큼 반복한다.
		//  2.1. 각 자리의 숫자의 개수를 센다.
		// 3. 각 숫자의 개수를 역순으로 출력한다.
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String N;      // 입력받는 숫자 [문자열]
		int[] arr = new int[10]; // 0~9 숫자들의 개수
		int i, j; // 반복제어변수
		
		
		// 1. N을 문자열로 입력받는다.
		N = br.readLine();
		
		//System.out.println(N);

		// 2. 문자열의 길이만큼 반복한다.
		for (i = 0; i < N.length(); i++) {
			//  2.1. 각 자리의 숫자의 개수를 센다.
			//System.out.println(N.charAt(i)-'0');
			arr[N.charAt(i)-'0']++;
		}
		
		// 3. 각 숫자의 개수를 역순으로 출력한다.
		for (i = 9; i >= 0; i--) {
			if (arr[i] != 0) {
				for (j = 0; j < arr[i]; j++) {
					System.out.print(i);
				}
			}
		}
	}
}