#include <cstdio>

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// for문 8	11022	A+B - 8 : https://www.acmicpc.net/problem/11022
	// : A+B를 바로 위 문제보다 아름답게 출력하는 문제

	int T, A, B; scanf("%d", &T);
	for (int i = 1; i <= T; i++) {
		scanf("%d %d", &A, &B);
		printf("Case #%d: %d + %d = %d\n", i, A, B, A + B);
	}
	return 0;
}