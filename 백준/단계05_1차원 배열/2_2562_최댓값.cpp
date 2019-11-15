#include <cstdio>

int main()
{
	// 2019-10-08-화
	// 단계5	1차원 배열 : 2	2562	최댓값 : https://www.acmicpc.net/problem/2562
	// : 최댓값이 어디에 있는지 찾는 문제

	int n = 0, idx = 0;
	int Max = 0;
	for (int i = 1; i <= 9; i++) {
		scanf("%d", &n);
		if (n > Max) {
			Max = n;
			idx = i;
		}
	}
	printf("%d %d\n", Max, idx);
	return 0;
}