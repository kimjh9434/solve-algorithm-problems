#include <cstdio>

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// 단계4	while문 : 1	10952	A+B - 5 : https://www.acmicpc.net/problem/10952
	// : 0 0이 들어올 때까지 A+B를 출력하는 문제 - 입력의 마지막에는 0 두 개가 들어온다.

	int A = 1, B = 1;
	while (1) {
		scanf("%d %d", &A, &B);
		if (A == 0 && B == 0) break;
		printf("%d\n", A + B);
	}
	return 0;
}