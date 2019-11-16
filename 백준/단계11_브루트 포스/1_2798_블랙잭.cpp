#include <cstdio>
using namespace std;

int a[100];

int main(int argc, char* argv[]) {
	// 2019-10-15-화
	// 1	2798	블랙잭 : https://www.acmicpc.net/problem/2798
	int n, m; scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	int sum = 0, s = 0;
	int min = 300000;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (i == j) continue;
			for (int k = j + 1; k < n; k++) {
				if (i == k) continue;
				if (j == k) continue;
				s = a[i] + a[j] + a[k];
				if (s > m) continue;
				if (m - s > min) continue;
				sum = s;
				min = m - s;
			}
		}
	}
	printf("%d\n", sum);

	return 0;
}