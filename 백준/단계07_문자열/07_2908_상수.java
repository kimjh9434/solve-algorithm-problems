import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q7	2908	상수
		
		Scanner scan = new Scanner(System.in);
		int num_A = scan.nextInt();
		int num_B = scan.nextInt();
		
		int reverse_num_A=0;
		int reverse_num_B=0;
		
		int digits;
		int multiple=100;
		for(int i=0;i<3;i++){
			digits = num_A%10;
			reverse_num_A+=digits*multiple;
			digits = num_B%10;
			reverse_num_B+=digits*multiple;
			
			multiple/=10;
			num_A/=10;
			num_B/=10;
		}
		
		if(reverse_num_A > reverse_num_B){
			System.out.println(reverse_num_A);
		}else{
			System.out.println(reverse_num_B);
		}
		scan.close();
	}
}