import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q9	2438	별찍기 - 1
		 Scanner scan = new Scanner(System.in);
		 int N = scan.nextInt();
		 StringBuilder[] str = new StringBuilder[N];
		 
		 int i,j;
		 for(i=1;i<=N;i++){
			 str[i-1] = new StringBuilder();
			 for(j=1;j<=i;j++){
				 str[i-1].append("*");
			 }
		 }
		 for(i=0;i<N;i++){
			System.out.println(str[i]);
		 }
		 scan.close();
    }
}