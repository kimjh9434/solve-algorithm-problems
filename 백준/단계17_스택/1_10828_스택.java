import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q1 10828 스택

		// 2018-07-27-금

		// 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

		// 명령은 총 다섯 가지이다.

		// push X: 정수 X를 스택에 넣는 연산이다.
		// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 스택에 들어있는 정수의 개수를 출력한다.
		// empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		// top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		// 입력
		// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
		// 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		// 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

		// 출력
		// 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

		// 필요한 단계들
		// 1. 명령의 개수 N을 입력받는다.
		// 2. N번 반복한다.
		// 2.1. 명령을 입력받는다.
		// 2.2. 명령의 유형[push, pop, size, empty, top]에 따라 처리한다.

		// 다양한 방법으로 스택을 구현할 수 있지만, 맨 처음이므로, 그냥 젤 단순하게 배열록 구현해보겠다.
		
		Scanner scan = new Scanner(System.in);
		int N;
		int[] stack = new int[10000];
		int top = -1;
		String command;
		int num;
		int i;
		
		// 알고리즘 수행
		// 1. 명령의 개수 N을 입력받는다.
		N = scan.nextInt();
		command = scan.nextLine();
		
		// 2. N번 반복한다.
		for(i=0;i<N;i++){
			// 2.1. 명령을 입력받는다.
			command = scan.nextLine();
			
			// 2.2. 명령의 유형[push, pop, size, empty, top]에 따라 처리한다.
			if(command.contains("push")){
//				System.out.println("push command");
				num = Integer.parseInt(command.substring(5, command.length()));
				stack[++top]=num;
			}else if(command.contains("pop")){
//				System.out.println("pop command");
				if(top!=-1){
					num=stack[top--];
					System.out.println(num);
				}else{
					System.out.println(-1);
				}
			}else if(command.contains("size")){
//				System.out.println("size command");
				System.out.println(top+1);
			}else if(command.contains("empty")){
//				System.out.println("empty command");
				if(top==-1){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
			}else{
//				System.out.println("top command");
				if(top!=-1){
					System.out.println(stack[top]);
				}else{
					System.out.println(-1);
				}
			}
		}
	}
}