import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Step8 - 수학1
		// Q8_2775_부녀회장이_될테야
		// 2018-03-28-수

		Scanner scan = new Scanner(System.in);
		int testcastN = scan.nextInt();
		int i, j, k;
		int h, n; // 높이 및 방번호
		int[][] rooms;
		for(i=0;i<testcastN;i++){
			h = scan.nextInt();
			n = scan.nextInt();
			
			// k x n 이차원 배열을 만든다.
			rooms = new int[h+1][n];	
			
			for(j=0;j<n;j++){
				rooms[0][j] = j+1;
			}
			
			for(k=1;k<=h;k++){
				rooms[k][0] = 1;
				
				for(j=1;j<n;j++){
					rooms[k][j] = rooms[k][j-1] + rooms[k-1][j];
				}
			}
			
//			for(k=0;k<=h;k++){
//				for(j=0;j<n;j++){
//					System.out.print(rooms[k][j] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.println(rooms[h][n-1]);
		}
		
		scan.close();
	}
}