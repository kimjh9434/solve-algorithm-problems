// 2	2231	분해합
#include <cstdio>
using namespace std;

int a[100];

int main(int argc, char* argv[]) {
	// 2019-10-15-화
	// 백준_단계10	브루트 포스 관련 문제
	// 2	2231	분해합 : https://www.acmicpc.net/problem/2231
	// 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

	int n; scanf("%d", &n); // N(1 ≤ N ≤ 1,000,000)
	int ans = 0;
	int sum, num;
	for (int i = 1; i < n; i++) {
		sum = num = i;

		while (num) {
			sum += num % 10;
			num /= 10;
		}

		if (n == sum) {
			ans = i; break;
		}
	}
	printf("%d\n", ans);

	return 0;
}