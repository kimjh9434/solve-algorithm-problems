import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q10	1316	그룹 단어 체커
		
		Scanner scan = new Scanner(System.in);
		int testcase_N = scan.nextInt();
		int group_N = 0;
		String word;
		char ch;
		char preCh;
		int len;
		int[] count = new int[26];
		int i,j;
		int index;
		boolean isGroup;
        
        scan.nextLine();
		
		for(i=0;i<testcase_N;i++){
			// count 배열 초기화
			for(j=0;j<26;j++){
				count[j]=0;
			}
			
			word = scan.nextLine();// 단어를 받고
			len = word.length();//단어의 알파벳수를 구한 후,
			preCh='A';
			isGroup = true;
			
			// 단어의 알파벳 수만큼 반복한다.
			for (j = 0; j < len; j++) {
				ch = word.charAt(j);
				
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
				// 해당 알파벳이 완전 처음 나올때 또는 해당 알파벳이 연속해서 나올때
				
				if((ch != preCh && count[index]==0) || (ch == preCh && count[index]>0)){
					count[index]++;
					preCh = ch;
				}else if(ch != preCh && count[index]>0){
					// 해당 단어가 이미 등장했다면,
					isGroup = false;
					break;
				}
			}
			if(isGroup){
				group_N++;
			}
		}
		
		System.out.println(group_N);
		
		scan.close();
	}
}