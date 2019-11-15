import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q4	2675	문자열 반복

		Scanner scan = new Scanner(System.in);
		int testcase_N = scan.nextInt();
		int repete_N;
		String str;
		int length;
		StringBuilder strBuilder;
		char ch;
		int i,j,k;
		for(i=0;i<testcase_N;i++){
			repete_N = scan.nextInt();
			str = scan.nextLine();
			length = str.length();
			strBuilder = new StringBuilder("");
			
			for(j=1; j<length;j++){
				ch = str.charAt(j);
				
				for(k=0;k<repete_N;k++){
					strBuilder.append(ch);
				}
			}
			System.out.println(strBuilder);
		}
		scan.close();
	}
}