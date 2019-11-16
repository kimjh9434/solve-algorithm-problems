import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Step8 - 수학1
		// Q9_6064_카잉달력
		// 2018-07-22-일

		// 4차 도전 - 2018-07-23-월
		// 2차 도전에서 실마리를 얻었다.
		// MM[j]=j*M + x, NN[k]=k*N + y을 구한 뒤 교집합을 구하는 것이 아니라,
		// j*M + x 를 구한 뒤 N으로 나눈 나머지가 y인 경우가 있냐 없냐로 따지면 되는 것이었다.
		// 근데, y로 딱 떨어지는 경우가 있었고, 중간에 N으로 나눈 나머지가 0으로 되는 경우가 있었다...
		// 이 둘을 구분하기 위해서, 1을 빼고 더했다.
		
		// 이경우 최대 40000번만 반복하면 된다 !!!

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int M, N, x, y, tmp;
		int MM, NN;
		int year;

		int i, j, k;

		for (i = 0; i < T; i++) {
			M = scan.nextInt();
			N = scan.nextInt();
			x = scan.nextInt();
			y = scan.nextInt();

			MM = NN = 0;
			year = -1;

			for (j = 0; j <= 40000; j++) {
				MM = j * M + x;
				NN = (MM - 1) % N + 1;

				if (NN == y) {
					year = MM;
					break;
				}
			}

			System.out.println(year);

		}
		scan.close();
	}
}