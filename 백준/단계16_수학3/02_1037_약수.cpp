#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-07-목
	// 백준_단계16 수학3 관련 문제
	// 2	1037	약수 : https://www.acmicpc.net/problem/1037

	int a[50];
	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	// 띵킹. Ex. A = 100 -> 1, 2, 4, 5, 10, 20, 25, 50, 100 중에서 1과 100을 제외한 2, ~~ 50의 수가 무작위하게 나타난다.
	// 이 경우, 정렬 후, 첫번째 값과 마지막 값을 곱하면 A가 된다.
	// CF. 예외. 9, 49 와 같이 소수의 경우, 중간 약수 값이 1개 밖에 없다. 이 경우 제곱을 하면 된다.

	int ans = 0;
	if (n != 1) {
		sort(a, a + n);
		ans = a[0] * a[n - 1];
	}
	else {
		ans = a[0] * a[0];
	}
	printf("%d\n", ans);

	return 0;
}