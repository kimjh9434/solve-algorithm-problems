#include <cstdio>
#include <vector>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-30-화
	// 비트마스크 관련문제
	// 1. 스타트와 링크 : https://www.acmicpc.net/problem/14889
	int N; scanf("%d", &N); // (4 ≤ N ≤ 20, N은 짝수)
	int S[20][20]; for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) scanf("%d", &S[i][j]);
	int ans = -1;
	int MAX = 1 << N;
	for (int i = 0; i < MAX; i++) { // EX. N = 4일때, 0000 ~ 1111을 반복함.
		// 1. 1의 개수를 세서 절반인지 확인한다.
		int cnt = 0;
		for (int j = 0; j < N; j++) if (i & (1 << j)) cnt++;

		// 2. 1의 개수가 2의 절반이라면,
		if (cnt != N / 2) continue; // 절반이 아닐때는 무시
		vector<int> t1, t2;
		// 두팀으로 나누고, 
		for (int j = 0; j < N; j++) {
			if (i & (1 << j))
				t1.push_back(j);
			else
				t2.push_back(j);
		}
		// 각 팀의 점수를 구한다.
		int s1 = 0, s2 = 0;
		for (int ii = 0; ii < N / 2; ii++) {
			for (int jj = 0; jj < N / 2; jj++) {
				s1 += S[t1[ii]][t1[jj]];
				s2 += S[t2[ii]][t2[jj]];
			}
		}
		// 팀 점수의 차이값의 절대값을 구한다.
		int diff = s1 - s2;
		if (diff < 0) diff = -diff;

		// 최솟값이 갱신된다면 갱신한다.
		if (ans == -1 || ans > diff) ans = diff;
	}
	// 최솟값을 출력한다.
	printf("%d\n", ans);

	return 0;
}
