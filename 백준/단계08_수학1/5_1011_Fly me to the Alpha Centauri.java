import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Step8 - 수학1
		// Q5 1011 Fly me to the Alpha Centauri
		// 2018-03-27-화

		Scanner scan = new Scanner(System.in);
		long testcastN = scan.nextInt();
		long i, j;
		long location_x, location_y;
		long distance, distance2;
		long Max_N;
		long min_N;
		long N;
		long min_warp_N=0;  
		for (i = 0; i < testcastN; i++) {
			// 입력을 받고 거리를 구한다.
			location_x = scan.nextInt();
			location_y = scan.nextInt();
			distance = location_y - location_x;
			
			// 거리가 몇 제곱 사이에 있는지 확인한다.
			Max_N = 1;
			N = 1;
			while (true) {
//				Max_N = (N+1)*(N+1);
//				min_N = N*N;
				min_N = Max_N;
				Max_N = Max_N + 2*N + 1;
				
//				System.out.println("Max_N : " + Max_N);
//				System.out.println("min_N : " + min_N);

				if (min_N <= distance && distance < Max_N) {
					break;
				}
				N++;
			}
			distance2 = distance - N*N;
			
			if(distance2 == 0){
				min_warp_N = 2*N - 1;
			}else if(distance2 <= N){
				min_warp_N = 2*N;
			}else{
				min_warp_N = 2*N + 1;
			}
//			System.out.println("거리     : " + distance);
//			System.out.println("N    : " + N);
//			System.out.println("거리2 : " + distance2);
			
			System.out.println(min_warp_N);
		}

		scan.close();
	}
}