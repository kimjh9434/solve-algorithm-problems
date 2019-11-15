import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q8	5622	다이얼
		
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		int len = word.length();
		char ch;
		int time = 0;
		int plus = 0;
		for(int i=0;i<len;i++){
			ch = word.charAt(i);
			
			if('A'<=ch && ch<='C'){
				plus=3;
			}else if('D'<=ch && ch<='F'){// D E F 
				plus=4;
			}else if('G'<=ch && ch<='I'){// G H I
				plus=5;
			}else if('J'<=ch && ch<='L'){// J K L
				plus=6;
			}else if('M'<=ch && ch<='O'){// M N O
				plus=7;
			}else if('P'<=ch && ch<='S'){// P Q R S
				plus=8;
			}else if('T'<=ch && ch<='V'){// T U V
				plus=9;
			}else if('W'<=ch && ch<='Z'){// W X Y Z
				plus=10;
			}
			time += plus;
		}
		System.out.println(time);
		
		scan.close();
	}
}