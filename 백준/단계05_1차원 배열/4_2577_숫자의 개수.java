import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q4	2577	숫자의 개수
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		int product = A * B * C;
		int[] numbers = new int[10];
		int digits;
		
		while(product>0){
			digits = product%10;
			
			switch(digits){
			case 0 : numbers[0]++; break;
			case 1 : numbers[1]++; break;
			case 2 : numbers[2]++; break;
			case 3 : numbers[3]++; break;
			case 4 : numbers[4]++; break;
			case 5 : numbers[5]++; break;
			case 6 : numbers[6]++; break;
			case 7 : numbers[7]++; break;
			case 8 : numbers[8]++; break;
			case 9 : numbers[9]++; break;
			}
			product = product/10;
		}
		for(int i=0;i<10;i++){
			System.out.println(numbers[i]);
		}
		scan.close();
	}
}