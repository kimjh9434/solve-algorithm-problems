#include <cstdio>
#include <cmath>

// N개의 원판을 장대 a 에서, 장대 b로 옮기는 함수
void hanoi(int n, int a, int b) {
	int c;
	if (n <= 1) printf("%d %d\n", a, b); // 크기가 1이면 그냥 옮긴다.
	else {// 크기가 2 이상인 경우,
		c = 6 - a - b;

		hanoi(n - 1, a, c); // 우선, n-1개의 원판을, 장대a 에서 장대c로 옮기고,
		printf("%d %d\n", a, b); // 맨 마지막의 가장 큰 원판을 장대a 에서 장대b로 옮기고,
		hanoi(n - 1, c, b); // 장대 c에 옮겼던 n-1개의 원판을, 장대b로 마저 옮긴다.
	}
}

int main() {
	// 2019-10-08-화
	// 단계10	재귀 : 10	11729	하노이 탑 이동 순서 : https://www.acmicpc.net/problem/11729
	// : 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어질때, 옮긴 횟수 K와 수행 과정을 출력한다.

	// 단순 띵킹
	int N; scanf("%d", &N);// 총 반복횟수는 2*N -1번
	printf("%d\n", (int)pow(2, N) - 1);
	scanf("%d", &N);
	hanoi(N, 1, 3); // 궁극적으로, N개의 원판을 장대1 에서, 장대3 으로 옮기면 된다.
	return 0;
}