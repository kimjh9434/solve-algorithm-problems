import java.util.Scanner;

public class Main {
	static public void main(String args[]) {
		// Q11	10871	X보다 작은 수
		Scanner scan = new Scanner(System.in);
		int N, X, n;
		
		N = scan.nextInt();
		X = scan.nextInt();
		for(int i=0;i<N;i++){
			n = scan.nextInt();
			if(n < X){
				System.out.print(n + " ");
			}
		}
	}
}