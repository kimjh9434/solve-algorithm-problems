import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
		// Q10	10869	사칙연산
		Scanner scan = new Scanner(System.in);
		
		int a,b;
		a = scan.nextInt();
		b = scan.nextInt();
		
		System.out.println(""+(a+b));
		System.out.println(""+(a-b));
		System.out.println(""+(a*b));
		System.out.println(""+(a/b));
		System.out.println(""+(a%b));
	}
}
