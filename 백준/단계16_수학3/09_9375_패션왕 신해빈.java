import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-15-수
		// 9	9375	패션왕 신해빈
		
		// 문제
		// 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 몇 일동안 밖에 돌아다닐 수 있을까?
		
		// 입력
		// 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
		// 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
		// 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
		// 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
		
		// 출력
		// 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
		
		// 음... 이것도 단순 조합 문제.
		
		// 전체 의상의 수는 n개 (0 ≤ n ≤ 30)이고, 의상의 종류는 k개, 
		// 어떤 의상 종류에 속한 해당 의상의 수를 각각 c1, c2,... ck라고 할 때
		
		Scanner sc = new Scanner(System.in);
		String[] categoryList;
		int listLength;
		int[] categoryCount;
		int T, n;
		int i, j, k;
		int result;
		String str;
		int tmpIndex;
		String category;
		
		T = sc.nextInt();
		
		for(i=0;i<T;i++){
			// 초기화
			categoryList = new String[30];
			categoryCount = new int[30];
			listLength = 0;
			result = 0;
			
			// 입력받기
			n = sc.nextInt();
			sc.nextLine();
			
			for(j=0;j<n;j++){
				str = sc.nextLine();
				tmpIndex=str.indexOf(' ');
				category = str.substring(tmpIndex+1, str.length());
				
				// 해당 의상의 종류가 기존 category 종류에 있었는지 확인한다.
				for(k=0;k<listLength;k++){
					if(categoryList[k].equals(category)){
						break;
					}
				}
				if(k==listLength){
					categoryList[k]=category;
					listLength++;
				}
				categoryCount[k]++;
			}
			
			// 슈방... 이 방법이 훨~~씬 더 간단하고, 더 빠르내...
			for(j=0;j<listLength;j++){
				result += result*categoryCount[j];
				result += categoryCount[j];
			}
//			System.out.println("====");
			System.out.println(result);
		}
		sc.close();
	}
}