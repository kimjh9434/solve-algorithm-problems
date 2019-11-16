import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q3 10989 수 정렬하기 3
		// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

		// CF. Arrays.sort 이용 - 이야 되네! 역시 기존 레퍼런스 짱짱맨!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int i;
		
		for (i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		for (i = 0; i < N; i++) {
			bw.write((arr[i]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
