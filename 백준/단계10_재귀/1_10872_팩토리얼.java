import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1_10872_팩토리얼
        Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long f=1;
		
		for(int i=2;i<=N;i++){
			f*=i;
		}
		System.out.println(f);
	}
}
