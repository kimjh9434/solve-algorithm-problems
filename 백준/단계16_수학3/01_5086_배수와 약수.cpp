#include <cstdio>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-07-목
	// 백준_단계16 수학3 관련 문제
	// 1	5086	배수와 약수 : https://www.acmicpc.net/problem/5086

	while (1) {
		int a, b; scanf("%d %d", &a, &b);
		if (a == 0 && b == 0) break;
		if (b % a == 0) {
			printf("factor\n");
		}
		else if (a % b == 0) {
			printf("multiple\n");
		}
		else {
			printf("neither\n");
		}
	}
	return 0;
}