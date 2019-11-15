import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
		// Q5 10817 세 수
		// 세 정수 A, B, C가 주어진다. 이 때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.

		Scanner scan = new Scanner(System.in);

		// 0. 정수 A, B, C를 입력받는다.
		int int_A = scan.nextInt();
		int int_B = scan.nextInt();
		int int_C = scan.nextInt();

		// 각 수의 크기를 구한다.
//		int first = 0;
		int second = 0;
//		int third = 0;
		if (int_A > int_B) {
			if (int_A > int_C) {
//				first = int_A;
				if (int_B > int_C) {
					second = int_B;
//					third = int_C;
				} else {
					second = int_C;
//					third = int_B;
				}
			} else {
//				first = int_C;
				second = int_A;
//				third = int_B;
			}
		} else {
			if (int_B > int_C) {
//				first = int_B;
				if (int_A > int_C) {
					second = int_A;
//					third = int_C;
				} else {
					second = int_C;
//					third = int_A;
				}
			} else {
//				first = int_C;
				second = int_B;
//				third = int_A;
			}
		}
//		System.out.println(first);
		System.out.println(second);
//		System.out.println(third);

	}
}
