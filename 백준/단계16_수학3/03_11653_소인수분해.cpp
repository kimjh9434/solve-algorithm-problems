#include <cstdio>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-07-목
	// 백준_단계16 수학3 관련 문제
	// 3	11653	소인수분해 : https://www.acmicpc.net/problem/11653
	// 정수 N이 주어졌을 때, 소인수분해하는 프로그램

	// 풀이 구상 : 음... 그냥 n이 0이 될때까지 나눈다.
	int n = 0; scanf("%d", &n); // 정수 N (1 ≤ n ≤ 10,000,000)

	int num = n;
	if (n != 1) {
		for (int i = 2; i <= n; ) {
			if (num % i == 0) {
				num /= i;
				printf("%d\n", i);
			}
			else {
				i++;
			}
		}
		if (num != 1) {
			printf("%d\n", num);
		}
	}

	return 0;
}