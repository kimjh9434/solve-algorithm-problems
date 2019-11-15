import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q7	8958	OX퀴즈
		
		Scanner scan = new Scanner(System.in);
		
		int testcase_N = scan.nextInt();
		String OX_Sentance;
		int OX_Sentance_length;
		char OX;
		int total_score, part_score;
		OX_Sentance = scan.nextLine();
		for(int i=0;i<testcase_N;i++){
			total_score=0;
			part_score = 0;
			
			OX_Sentance = scan.nextLine();
			OX_Sentance_length = OX_Sentance.length();
			
			for(int j=0;j<OX_Sentance_length;j++){
				OX = OX_Sentance.charAt(j);
				if(OX == 'O'){
					part_score++;
				}else{ // OX == 'X'
					part_score=0;
				}
				total_score += part_score;
			}
			System.out.println(total_score);
		}
		scan.close();
	}
}