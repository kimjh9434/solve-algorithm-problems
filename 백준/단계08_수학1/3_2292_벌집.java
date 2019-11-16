import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q3 2292 벌집
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int max_N = 1;
		int min_N = 0;
		boolean isGoing = true;
		int i = 0;
		while (true) {
			max_N = max_N + 6 * i;
			min_N = min_N + 1;
			
			if(min_N <= N && N <= max_N){
				break;
			}
			i++;
		}
		System.out.println(i+1);
		scan.close();
	}
}
