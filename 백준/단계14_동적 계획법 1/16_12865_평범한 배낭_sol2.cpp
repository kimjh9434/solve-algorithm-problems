#include <cstdio>
#include <algorithm>
using namespace std;
int n, k;
int w[101];
int v[101];
int d[100001]; // d[i] : 물건의 합이 i일때 가치의 최댓값
int main() {
	// 2019-05-27-월
	// 다이나믹 프로그래밍 
	// 문제풀이 1 관련문제
	// 3. 평범한 배낭 : https://www.acmicpc.net/problem/12865
	scanf("%d %d", &n, &k);
	for (int i = 1; i <= n; i++) scanf("%d %d", &w[i], &v[i]);
	for (int i = 1; i <= n; i++) {
		for (int j = k; j >= 1; j--) {
			if (j - w[i] >= 0) {
				d[j] = max(d[j], d[j - w[i]] + v[i]);
			}
		}
	}
	printf("%d\n", d[k]);
	return 0;
}