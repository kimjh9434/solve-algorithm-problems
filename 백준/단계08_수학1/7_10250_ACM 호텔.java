import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Step8 - 수학1
		// Q7	10250	ACM 호텔
		// 2018-03-28-수

		Scanner scan = new Scanner(System.in);
		int testcastN = scan.nextInt();
		int roomNumber;
		int H, W, N;
		for(int i=0;i<testcastN;i++){
			H = scan.nextInt();
			W = scan.nextInt();
			N = scan.nextInt();
			
			roomNumber=0;
			
			if(N%H!=0){
				roomNumber += (N%H)*100;
				roomNumber += (N/H)+1;
			}else{
				roomNumber += H*100;
				roomNumber += (N/H);
			}
			
			System.out.println(roomNumber);
		}
		scan.close();
	}
}