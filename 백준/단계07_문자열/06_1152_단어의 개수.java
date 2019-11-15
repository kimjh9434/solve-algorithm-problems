import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 06_1152_단어의 개수
		/*
		 * 슈방 여러번 틀리니까 빡치내...
		 * 그냥 공백이 몇개든 상관없이 단어의 개수를 파악하는 알고리즘으로 가야겠다.
		 * 공백이 한번만 있을거라는 말을 하질 말지...
		 */

		Scanner sc = new Scanner(System.in);
		String sentance = sc.nextLine();
		int wordcount = 0;
		char ch;
		int i=0;
		int length = sentance.length();
		int keep = -1;
		while(i<length){
			ch = sentance.charAt(i);
			if(ch != ' '){
				if(keep < 0){
					wordcount++;
					keep = 1;
				}
			}else{ // ch == ' '
				if(keep > 0){
					keep = -1;
				}
			}
			i++;
		}
		System.out.println(wordcount);
	}
}
