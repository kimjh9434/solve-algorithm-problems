import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		// Q1 2750 수 정렬하기
		// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		// 방법1. 그냥 정렬 함수 쓰기
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			arr.add(scan.nextInt());
		}
		
		Collections.sort(arr);
		
		for(int i=0;i<N;i++){
			System.out.println(arr.get(i));
		}

		scan.close();
	}
}
