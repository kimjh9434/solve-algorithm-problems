import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static public void main(String args[]) {

		// Q2	4673	셀프 넘버

		Scanner scan = new Scanner(System.in);
		
		ArrayList<Integer> non_selfNumbers = new ArrayList<Integer>();
		int nun_selfNumber;
		for(int i=1;i<10001;i++){
			// 기본 구상 : i가 논셀프넘버 목록에 없으면, 
			if(!non_selfNumbers.contains(i)){
				// 셀프넘버이므로 출력한다.
				System.out.println(i);
				
				// 이후, i로부터 파생되는 논셀프넘버들을 10000전까지 논셀프넘버 목록에 저장한다.
				nun_selfNumber=i;
				while(nun_selfNumber<10000){
					// 논셀프넘버들 생성하고, 
					nun_selfNumber = make_nun_selfNumber(nun_selfNumber);
					
					//  논셀프넘버 목록에 없으면 추가한다. [중복방지]
					if(!non_selfNumbers.contains(nun_selfNumber)){
						non_selfNumbers.add(nun_selfNumber);
					}
				}
				// 넘어가기 전에 간단하게 정렬한다.
				non_selfNumbers.sort(null);
			}else{
				// i가 논셀프넘버 목록에 있으면, 넘어간다.
			}
		}
	}
	
	// 입력 받은 어떤 수로부터 파생되는 논 셀프넘버를 구하는 함수 
	// = d(n) : n과 n의 각 자리수를 더하는 함수
	public static int make_nun_selfNumber(int number){
		int nun_selfNumber=0;
		
		// 논 셀프넘버는 어떤 수(number) 그 자체와,
		nun_selfNumber += number;
		
		// 해당 어떤 수(number)의 각 자리 수의 합으로 이루어진다.
		while(number > 0){
			nun_selfNumber += number%10;
			number/=10;
		}
		return nun_selfNumber;
	}
}