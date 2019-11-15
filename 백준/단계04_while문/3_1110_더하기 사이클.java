import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
        // Q3	1110	더하기 사이클
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int cycleNum = 0; // 사이클 길이
		int firstNum = N/10; // 10의자리 숫자
		int secondNum = N%10;// 1의 자리 숫자
		
		int next_firstNum = secondNum; // 10의자리 숫자
		int next_secondNum = (firstNum+secondNum)%10;// 1의 자리 숫자
		cycleNum++;
//		System.out.println(firstNum+""+secondNum);
//		System.out.println(next_firstNum+""+next_secondNum);
		
		while(!(N/10==next_firstNum && N%10==next_secondNum)){
			firstNum = next_firstNum;
			secondNum = next_secondNum;
			
			next_firstNum = secondNum; 
			next_secondNum = (firstNum+secondNum)%10;
			cycleNum++;
			
//			System.out.println(firstNum+""+secondNum);
//			System.out.println(next_firstNum+""+next_secondNum);
		}
		System.out.println(cycleNum);
    }
}
