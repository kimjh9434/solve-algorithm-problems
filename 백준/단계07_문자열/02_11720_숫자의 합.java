import java.util.Scanner;

public class Main {

	static public void main(String args[]) {	
		// Q2	11720	숫자의 합
		Scanner scan = new Scanner(System.in);
		String N_ = scan.nextLine();//사실 자바에서는 의미 없음
		String N_Str = scan.nextLine();
		int sum = 0;
		// N이 0이 아닌동안 반복한다.
		
		for(int i=0;i<N_Str.length();i++){
			sum += N_Str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
