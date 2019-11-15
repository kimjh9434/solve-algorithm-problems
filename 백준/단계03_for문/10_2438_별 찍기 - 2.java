import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 10 2439 별찍기 - 2
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder[] str = new StringBuilder[N];

		int i, j;
		for (i = 0; i < N; i++) {
			str[i] = new StringBuilder();
			for (j = N-i; j > 1; j--) {
				str[i].append(" ");
			}
			for (j = 0; j <= i; j++) {
				str[i].append("*");
			}
		}
		for (i = 0; i < N; i++) {
			System.out.println(str[i]);
		}
		scan.close();
    }
}