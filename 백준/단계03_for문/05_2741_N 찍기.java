import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
		// Q5	2741	N 찍기
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		for(int i=0;i<N;i++){
			System.out.println(""+(i+1));
		}
	}
}
