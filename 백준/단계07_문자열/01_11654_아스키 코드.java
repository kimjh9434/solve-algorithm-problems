import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q1 11654 아스키 코드
		// 입력 : 알파벳 소문자, 대문자 숫자 0-9 중 하나가 첫째 줄에 주어진다.
		// 출력 : 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char aski = str.charAt(0);
		System.out.println((int)aski);
		scan.close();
	}
}
