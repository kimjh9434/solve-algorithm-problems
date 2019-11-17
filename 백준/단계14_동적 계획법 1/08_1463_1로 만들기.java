import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		// 2018-08-12-일
		// 1463	1로 만들기
		
		// https://www.acmicpc.net/problem/1463
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int[] minCount = new int[N+3];
		int[] num = new int[4];
		
		minCount[0]=0;
		minCount[1]=0;
		minCount[2]=1;
		minCount[3]=1;
		
		for(int i=4;i<=N;i++){
			Arrays.fill(num, N);
			if(i%2==0){
				num[0] = minCount[i/2]+1;
			}
			if(i%3==0){
				num[1] = minCount[i/3]+1;
			}
			num[2] = minCount[i-1]+1;
			num[3] = minCount[i-2]+2;
			
//			System.out.println("i="+i);
//			System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3]);
			Arrays.sort(num);
//			System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3]);
//			System.out.println("========");
			
			minCount[i]=num[0];
		}
		System.out.println(minCount[N]);
	}
}