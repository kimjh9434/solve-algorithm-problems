#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-06-수
	// 백준_단계15	15	그리디 알고리즘 관련 문제
	// 3	11399	ATM : https://www.acmicpc.net/problem/11399

	int n;
	int a[1000];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);

	sort(a, a + n);

	int sum = 0;
	int ans = 0;

	for (int i = 0; i < n; i++) {
		sum += a[i];
		ans += sum;
	}

	printf("%d\n", ans);
}