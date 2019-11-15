import java.util.Scanner;

public class Main {

	static public void main(String args[]) {

		// Q2 9498 시험 성적
		// 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 
		// 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
		
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		char gradePoint=' ';
		
		if(score >= 90){
			gradePoint = 'A';
		}else if(score >= 80){
			gradePoint = 'B';
		}else if(score >= 70){
			gradePoint = 'C';
		}else if(score >= 60){
			gradePoint = 'D';
		}else{
			gradePoint = 'F';
		}
		
		System.out.println(gradePoint);
    }
}