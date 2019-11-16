import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 2018-08-28-화

		// 9	3053	택시 기하학
		
		// 문제
		// 택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
		// D(T1,T2) = |x1-x2| + |y1-y2|
		// 원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합
		
		// 반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.

		// 입력
		// 첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수이다.

		// 출력
		// 첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이를, 둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력한다.
		// 넓이는 소수점 여섯째 자리까지 출력한다.
		
		
		// 대충 구상.
		// 음... 이건 뭐???
		// 에초에 반지름의 길이인 R이 주어지니까,
		//  유클리드 기하학에서 반지름이 R인 원의 넓이는 R*R*π을 소수 6째까지 나타내면 되는 것이고,
		//  택시 기하학에서 반지름이 R인 원의 넓이는  R*R*2이다.
		
		Scanner sc = new Scanner(System.in);
		double R = sc.nextInt();
		System.out.println(String.format("%f", R * R * Math.PI));
		System.out.println(String.format("%f", R * R * 2));
		sc.close();
	}
}