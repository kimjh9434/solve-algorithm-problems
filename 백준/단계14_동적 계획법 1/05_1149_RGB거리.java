import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
        // 2018-08-16-목

		// 5 1149 RGB거리
        Scanner sc = new Scanner(System.in);
		int N;
		int[][] house;
		int[][] sum;
		int i, j, max;
		int M;
		
		
		// init
		N = sc.nextInt();
		house = new int[N][3];
		sum = new int[N][3];
		
		for (i = 0; i < N; i++) {
			for (j = 0; j < 3; j++)
				house[i][j] = sc.nextInt();
		}
		
		// solve
		for (i = 0; i < 3; i++) {
			sum[0][i] = house[0][i];
		}

		for (i = 1; i < N; i++) {
			for (j = 0; j < 3; j++) {
				if (j == 0)
					M = Math.min(sum[i - 1][1], sum[i - 1][2]);
				else if (j == 1)
					M = Math.min(sum[i - 1][0], sum[i - 1][2]);
				else
					M = Math.min(sum[i - 1][0], sum[i - 1][1]);
				sum[i][j] = M + house[i][j];
			}
		}	

		M = sum[N - 1][0];
		for (j = 0; j < 3; j++) {
			if (M > sum[N - 1][j])
				M = sum[N - 1][j];
		}
		System.out.println(M);
	}
}