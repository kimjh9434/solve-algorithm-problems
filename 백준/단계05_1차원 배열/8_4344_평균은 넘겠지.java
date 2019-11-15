import java.util.Scanner;

public class Main {
	static public void main(String args[]) {
        // Q8	4344	평균은 넘겠지
		Scanner scan = new Scanner(System.in);
		int testcaseN = scan.nextInt();
		int i, j;
		int personN;
		int[] scores = new int[1000];
		int sum;
		float average;
		int overAverageN;
		float overAverageRate_float;
		String overAverageRate_Str;
		
		// 테스트케이스의 수[testcaseN]만큼 반복한다.
		for(i=0;i<testcaseN;i++){
			personN = scan.nextInt();
			sum=0;
			overAverageN=0;
			
			// 점수를 받으면서 총점도 구한다.
			for(j=0;j<personN;j++){// 사람수[personN]만큼 반복한다.
				scores[j] = scan.nextInt();
				sum += scores[j];
			}
			average = sum / (float)personN;
//			System.out.println("총합 : " + sum);
//			System.out.println("평균 : " + average);
			
			// 평균을 넘는 사람의 수를 구한다.
			for(j=0;j<personN;j++){// 사람수[personN]만큼 반복한다.
				if(scores[j]>average){
					overAverageN++;
				}
			}
			
			// 평균을 넘는 학생들의 비율을 구한뒤, 
			overAverageRate_float = (float)overAverageN*100/(float)personN;
			
			// 소수점 넷째자리에서 반올림하고, 
			overAverageRate_Str = String.format("%04.3f", overAverageRate_float);
					
//			overAverageRate = Math.round(overAverageRate*1000f) / 1000f;
//			System.out.println("넘는수 : " + overAverageN);
//			System.out.println("비율 : " + overAverageRate);
			// 출력한다.
			System.out.println(overAverageRate_Str + "%");
		}
	}
}
