#include <cstdio>
#include <algorithm>
using namespace std;
int N;// (1 ≤ n ≤ 1,000)
int a[1001];
int d[1001];
int d1[1001];
int d2[1001];

void go(); // 바텀업(Bottom-up) 방식 풀이 [반복문 이용]

int main(int argc, char* argv[]) {
	// 2019-04-25-목
	// 다이나믹 프로그래밍 문제풀이3 관련문제
	// 5. 가장 긴 바이토닉 부분 수열 : https://www.acmicpc.net/problem/11054

	// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
	scanf("%d", &N); // (1 ≤ n ≤ 1,000)
	int i;
	for (i = 1; i <= N; i++) scanf("%d", &a[i]);
	go();
	printf("%d\n", *max_element(d, d + (N + 1)));

	return 0;
}

// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
void go() {
	for (int i = 1; i <= N; i++) {
		d1[i] = 1;
		for (int j = i - 1; j >= 1; j--) {
			// j번째 값이 지금 자신 값보다 더 작은데, 거기서부터 1을 더한 값이 현재 값보다 더 크다면,
			if (a[j] < a[i] && d1[j] + 1 > d1[i]) {
				d1[i] = d1[j] + 1; // 가장 증가하는 순열의 길이가 갱신된다.
			}
		}
	}
	for (int i = N; i >= 1; i--) {
		d2[i] = 1;
		for (int j = i + 1; j <= N; j++) {
			// j번째 값이 지금 자신 값보다 더 작은데, 거기서부터 1을 더한 값이 현재 값보다 더 크다면, 
			if (a[j] < a[i] && d2[j] + 1 > d2[i]) {
				d2[i] = d2[j] + 1; // 가장 감소하는 순열이 갱신된다.
			}
		}
	}
	for (int i = 1; i <= N; i++) {
		d[i] = d1[i] + d2[i] - 1;
	}
}