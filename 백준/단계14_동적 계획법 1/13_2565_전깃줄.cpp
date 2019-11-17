// 13	2565	전깃줄 : LIS 응용 문제 2
#include <cstdio>
#include <algorithm>
using namespace std;
int N;// (1 ≤ n ≤ 100)
pair<int, int> a[101];
int d[101];
int MAX = 1;

void go(); // 바텀업(Bottom-up) 방식 풀이 [반복문 이용]

int main(int argc, char* argv[]) {
	// 2019-10-16-수
	// 백준_단계12	동적 계획법 1 관련 문제
	// 13	2565	전깃줄 : https://www.acmicpc.net/problem/2565
	// LIS 응용 문제 2

	// 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 
	// 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성

	// 없애야 하는 전깃줄의 최소 개수 == N개의 전기줄 중, 최대한 많이 연결한 상황에서 N과의 차이 값

	// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
	scanf("%d", &N); // (1 ≤ n ≤ 100)
	int i;
	for (i = 1; i <= N; i++) scanf("%d %d", &a[i].first, &a[i].second);
	sort(a, a + N + 1);
	go();
	printf("%d\n", N - MAX);

	return 0;
}

// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
void go() {
	for (int i = 1; i <= N; i++) { // 2중 for문
		d[i] = 1;
		for (int j = i - 1; j >= 1; j--) {
			// j번째 줄이 지금 자신과 안겹치는데 , 거기서부터 1을 더한 값이 현재 값보다 더 크다면,
			if (a[j].first < a[i].first && a[j].second < a[i].second && d[j] + 1 > d[i]) {
				// 전기줄의 최대 개수가 갱신된다.
				d[i] = d[j] + 1;
				if (MAX < d[i]) MAX = d[i]; // 최댓값도 기존보다 길면 갱신한다.
			}
		}
	}
}