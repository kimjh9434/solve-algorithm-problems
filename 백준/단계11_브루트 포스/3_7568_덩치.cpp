// 3	7568	덩치
#include <cstdio>
#include <utility>
using namespace std;
pair<int, int> a[50];
int rankings[50];

int main(int argc, char* argv[]) {
	// 2019-10-15-화
	// 백준_단계10	브루트 포스 관련 문제
	// 3	7568	덩치 : https://www.acmicpc.net/problem/7568

	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d %d", &a[i].first, &a[i].second);

	int i, j, ranking;
	for (i = 0; i < n; i++) {
		ranking = 1;
		for (j = 0; j < n; j++) {
			if (a[i].first < a[j].first && a[i].second < a[j].second) {
				ranking++;
			}
		}
		rankings[i] = ranking++;
	}

	for (i = 0; i < n; i++) {
		printf("%d ", rankings[i]);
	}
	printf("\n");

	return 0;
}