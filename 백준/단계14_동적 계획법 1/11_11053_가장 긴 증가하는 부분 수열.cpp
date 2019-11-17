// 11	11053	가장 긴 증가하는 부분 수열
#include <cstdio>
using namespace std;
int N;// (1 ≤ n ≤ 1,000)
int a[1001];
int d[1001];
int MAX = 1;

void go(); // 바텀업(Bottom-up) 방식 풀이 [반복문 이용]

int main(int argc, char* argv[]) {
	// 전에 코드 작성했던 날짜 : 2019-04-25-목
	// 다이나믹 프로그래밍 문제풀이3 관련문제
	// 1. 가장 긴 증가하는 수열 : https://www.acmicpc.net/problem/11053
	// - 수열 A의 가장 긴 증가하는 부분 수열의 길이를 구하는 프로그램

	// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
	scanf("%d", &N); // (1 ≤ n ≤ 1,000)
	for (int i = 1; i <= N; i++) scanf("%d", &a[i]);
	go();
	printf("%d\n", MAX);

	return 0;
}

// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
void go() {
	for (int i = 1; i <= N; i++) { // 2중 for문
		d[i] = 1;
		for (int j = i - 1; j >= 1; j--) {
			if (a[j] < a[i] && d[j] + 1 > d[i]) { // j번째 값이 지금 자신 값보다 더 작은데, 거기서부터 1을 더한 값이 현재 값보다 더 크다면,
				// 가장 증가하는 순열의 길이가 갱신된다.
				d[i] = d[j] + 1;
				if (MAX < d[i]) MAX = d[i]; // 최댓값도 기존보다 길면 갱신한다.
			}
		}
	}
}