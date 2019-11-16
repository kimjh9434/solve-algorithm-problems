import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		// 3 1929 소수 구하기
		// 문제
		// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1000000)

		// 출력
		// 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
        

		// 훨~씬 더 빠른 소수 구하는 방법 [2018-08-07-화]
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Max; 
		int MaxSize = 1000000; 
		Boolean[] primeNumbers = new Boolean[MaxSize+1];// 1 ~ MaxSize사이의 수에 대한 소수 판별
		Arrays.fill(primeNumbers, true); // 모두 true로 초기화한다.
		int i,j;
		int M, N;
		
		M = scan.nextInt();
		N = scan.nextInt();
		
		Max = (int) Math.sqrt(N);
		
		primeNumbers[0] = primeNumbers[1] = false;
		
		for (i = 2; i <= Max; i++) {
			for (j = i * i; j <= MaxSize; j = j + i)
				primeNumbers[j] = false;
		}
		
		
		for (i = 2; i <= MaxSize; i++){
			if (primeNumbers[i] && (M <= i && i <= N)){
				bw.write(i + "\n");
			}
		}

		scan.close();
		bw.flush();
		bw.close();
	}
}