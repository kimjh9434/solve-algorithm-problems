import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
		// Q2 2839 설탕 배달
		Scanner scan = new Scanner(System.in);
		int N_KG; // 입력받은 Nkg
		int count_total = 0;
		int count_3KG = 0;
		int count_5KG = 0;

		// 0. N의 값을 입력받는다.
		N_KG = scan.nextInt();

		if (N_KG != 4 && N_KG != 7) {// 1. 만약 N이 4과 7이 아닐경우,
			// 3kg 봉지와 5kg 봉지의 개수를 구한다.

			int remainder; // 나머지

			// 1.1. 5kg에 있어서 몫과 나머지를 구한다.
			count_5KG = N_KG / 5;
			remainder = N_KG % 5;

			// 1.2. 만약 나머지가 0이 아니라면,
			if (remainder != 0) {
				N_KG = remainder;

				// 1.2.1. 3kg에 있어서 몫과 나머지를 구한다.
				count_3KG = N_KG / 3;
				remainder = N_KG % 3;
	
				// 1.2.2. 만약 나머지가 0이 될때까지 반복한다.
				while(remainder !=0){
					// 1.2.2.1. 5kg 봉지의 개수를 1개 줄이고,
					count_5KG -= 1;
					// 1.2.2.2. N_kg을 복원 시킨 후에
					N_KG = count_3KG * 3 + remainder + 5;
					// 1.2.2.3. 다시 3으로 나눠본다.
					count_3KG = N_KG / 3;
					remainder = N_KG % 3;
				}
			} else { 
				// 만약 나머지가 0이라면 그대로 끝
			}
			
			// 1.3. 전체 봉지의 개수를 구한다.
			count_total = count_3KG + count_5KG;
		} else {
					// 2.1. count_total는 -1이다.
			count_total = -1;
		}

		// 2. 전체 봉지의 개수를 출력한다.
//		System.out.println(count_3KG);//3kg 봉지의 개수
//		System.out.println(count_5KG);//3kg 봉지의 개수
		System.out.println(count_total);//총 봉지의 개수
	}
}
