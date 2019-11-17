#include <cstdio>
#include <algorithm>
using namespace std;
int n, k;
int w[101];
int v[101];
int d[101][100001]; // d[i][j] : i번째 물건까지 고려했고, 배낭에 넣은 물건의 합이 j일때 가치의 최댓값
int main() {
	// 2019-05-27-월
	// 다이나믹 프로그래밍 
	// 문제풀이 1 관련문제
	// 3. 평범한 배낭 : https://www.acmicpc.net/problem/12865
	// N개의 물건. 각 물건 : 무게 W와 가치 V. 최대 K무게까지의 배낭
	// 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 구하라
	// Top-down 방식 적용
	scanf("%d %d", &n, &k);
	for (int i = 1; i <= n; i++) scanf("%d %d", &w[i], &v[i]);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			d[i][j] = d[i - 1][j];
			if (j - w[i] >= 0) {
				d[i][j] = max(d[i][j], d[i - 1][j - w[i]] + v[i]);
			}
		}
	}
	printf("%d\n", d[n][k]);
	return 0;
}