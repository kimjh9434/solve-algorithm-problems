import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q3 10989 수 정렬하기 3
		// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

		// 4차 시도. Counting Sort 이용 + BufferedReader, BufferedWriter 이용

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int N = Integer.parseInt( br.readLine() );
		int[] arr = new int[10000];
		int i, j;

		for (i = 0; i < N; i++) {
			arr[Integer.parseInt( br.readLine() ) - 1]++;
		}
		
		for (i = 0; i < 10000; i++) {
			if (arr[i] != 0) {
				for (j = 0; j < arr[i]; j++) {
					bw.write((i + 1) + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}