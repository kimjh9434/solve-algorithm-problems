import java.util.Scanner;

public class Main {

	static public void main(String args[]) {
		// Q6	1546	평균
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		float[] scoreArr = new float[N];
		
		//N번 입력받으면서, 동시에 최대값을 구하기
		float maxScore=0;
		for(int i=0;i<N;i++){
			scoreArr[i] = scan.nextInt();
			if(scoreArr[i] > maxScore){
				maxScore = scoreArr[i];
			}
		}
		
		// 바뀐 점수로 변환하면서 총합을 구하기
		float sum=0;
		for(int i=0;i<N;i++){
			sum += (scoreArr[i]/maxScore*100);
		}
		
		// 평균을 구한다.
		float average = sum / (float)N;
		System.out.println(average);
	}
}
