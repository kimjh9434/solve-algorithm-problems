import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// Q3 10809 알파벳 찾기
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char ch;
		int len = str.length();
		int[] indexs = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				         -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int index;
		for (int i = 0; i < len; i++) {
			ch = str.charAt(i);
			
			switch(ch){
			case 'a' : index = 0; break;
			case 'b' : index = 1; break;
			case 'c' : index = 2; break;
			case 'd' : index = 3; break;
			case 'e' : index = 4; break;
			case 'f' : index = 5; break;
			case 'g' : index = 6; break;
			case 'h' : index = 7; break;
			case 'i' : index = 8; break;
			case 'j' : index = 9; break;
			case 'k' : index = 10; break;
			case 'l' : index = 11; break;
			case 'm' : index = 12; break;
			case 'n' : index = 13; break;
			case 'o' : index = 14; break;
			case 'p' : index = 15; break;
			case 'q' : index = 16; break;
			case 'r' : index = 17; break;
			case 's' : index = 18; break;
			case 't' : index = 19; break;
			case 'u' : index = 20; break;
			case 'v' : index = 21; break;
			case 'w' : index = 22; break;
			case 'x' : index = 23; break;
			case 'y' : index = 24; break;
			case 'z' : index = 25; break;
			default : index = 0; break;
			}
			
			if(indexs[index]<0){
				indexs[index] = i;
			}
		}
		
		System.out.print(indexs[0]);
		for(int i=1;i<26;i++){
			System.out.print(" "+indexs[i]);
		}

		scan.close();
	}
}