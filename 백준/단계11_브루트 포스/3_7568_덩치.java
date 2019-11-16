import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-09-17-월

		// 3 7568 덩치

		// 문제
		// 우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 메겨보려고 한다.
		// 키, 몸무게 둘다 큰경우만, 덩치가 크다고 판단 가능, 키는 크고, 몸무게는 작은 등의 경우에는 판단 불가능.
		// 여러분은 N명 학생들의 몸무게와 키가 담긴 입력파일을 읽어서 각 사람들의 덩치 등수를 계산하여 출력해야 한다.

		// 입력
		// 첫 줄에는 전체 사람의 수 N이 주어진다.
		// 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
		// 단, 2 ≤ N ≤ 50, 10 ≤ x,y ≤ 200 이다.

		// 출력
		// 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다.
		// 단 각 덩치 등수는 공백문자로 분리되어야 한다

		// 풀이 방법
		// 1. 일단은 각 사람들의 정보를 쭉 받고,
		// 2. 무게순으로 쭉 정렬을 한 다음에, - 정렬을 하면 안됬내...
		// 3. 각 사람으로부터, 자기보다 더 큰 사람들만 구해본다.
		// 걍 무식하게 해봐야겠다.

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Person[] p = new Person[N];
		int[] rankings = new int[N];
		int ranking;
		int i, j;

		for (i = 0; i < N; i++) {
			p[i] = new Person(sc.nextInt(), sc.nextInt());
		}

		for (i = 0; i < N; i++) {
			ranking = 1;
			for (j = 0; j < N; j++) {
				if (p[i].w < p[j].w && p[i].h < p[j].h) {
					ranking++;
				}
			}
			rankings[i] = ranking;
		}

		for (i = 0; i < N; i++) {
			System.out.print(rankings[i] + " ");
		}

		sc.close();
	}
}

class Person {
	int w; // weight
	int h; // height

	Person(int w, int h) {
		this.w = w;
		this.h = h;
	}
}