import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
        // Q11	10430	나머지
		Scanner scan = new Scanner(System.in);

		int A, B, C;
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();

		System.out.println("" + ( (A+B)%C ) );
		System.out.println("" + ( (A%C + B%C)%C ) );
		System.out.println("" + ( (A*B)%C ) );
		System.out.println("" + ( ((A%C) * (B%C))%C ) );
    }
}