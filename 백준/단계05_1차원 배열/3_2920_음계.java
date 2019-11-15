import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q3	2920	음계
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int i;
		if(num == 1){
			for(i=0;i<7;i++){
				num++;
				if(num != scan.nextInt()){
					break;
				}
			}
			if(i==7){
				System.out.println("ascending");
			}else{
				System.out.println("mixed");
			}
		}else if(num == 8){
			for(i=0;i<7;i++){
				num--;
				if(num != scan.nextInt()){
					break;
				}
			}
			if(i==7){
				System.out.println("descending");
			}else{
				System.out.println("mixed");
			}
		}else{
			System.out.println("mixed");
		}
		
		scan.close();
	}
}