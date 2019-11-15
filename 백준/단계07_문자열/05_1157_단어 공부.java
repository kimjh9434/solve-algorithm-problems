import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q5	1157	단어 공부
		
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		char ch;
		int len = word.length();
		int[] count = new int[26];
		
		int length;
		
		int index;
		for (int i = 0; i < len; i++) {
			ch = word.charAt(i);
			
			switch(ch){
			case 'a' : index = 0; break;case 'A' : index = 0; break;
			case 'b' : index = 1; break;case 'B' : index = 1; break;
			case 'c' : index = 2; break;case 'C' : index = 2; break;
			case 'd' : index = 3; break;case 'D' : index = 3; break;
			case 'e' : index = 4; break;case 'E' : index = 4; break;
			case 'f' : index = 5; break;case 'F' : index = 5; break;
			case 'g' : index = 6; break;case 'G' : index = 6; break;
			case 'h' : index = 7; break;case 'H' : index = 7; break;
			case 'i' : index = 8; break;case 'I' : index = 8; break;
			case 'j' : index = 9; break;case 'J' : index = 9; break;
			case 'k' : index = 10; break;case 'K' : index = 10; break;
			case 'l' : index = 11; break;case 'L' : index = 11; break;
			case 'm' : index = 12; break;case 'M' : index = 12; break;
			case 'n' : index = 13; break;case 'N' : index = 13; break;
			case 'o' : index = 14; break;case 'O' : index = 14; break;
			case 'p' : index = 15; break;case 'P' : index = 15; break;
			case 'q' : index = 16; break;case 'Q' : index = 16; break;
			case 'r' : index = 17; break;case 'R' : index = 17; break;
			case 's' : index = 18; break;case 'S' : index = 18; break;
			case 't' : index = 19; break;case 'T' : index = 19; break;
			case 'u' : index = 20; break;case 'U' : index = 20; break;
			case 'v' : index = 21; break;case 'V' : index = 21; break;
			case 'w' : index = 22; break;case 'W' : index = 22; break;
			case 'x' : index = 23; break;case 'X' : index = 23; break;
			case 'y' : index = 24; break;case 'Y' : index = 24; break;
			case 'z' : index = 25; break;case 'Z' : index = 25; break;
			default : index = 0; break;
			}
			count[index]++;
		}
		
		int maxIndex=0, max=count[0];
		boolean isMaxOverlap = false;
		for(int i=1;i<26;i++){
			if(max <= count[i]){
				if(max != count[i]){
					max = count[i];
					maxIndex = i;
					isMaxOverlap = false;
				}else{
					isMaxOverlap = true;
				}
			}
		}
		if(isMaxOverlap){
			System.out.println("?");
		}else{
			System.out.println((char)('A'+maxIndex));
		}
		
		scan.close();
	}
}