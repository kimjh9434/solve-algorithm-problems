#include <cstdio>
#include <algorithm>
#include <string.h>
using namespace std;
int N;// (1 ≤ n ≤ 10,000)
int p[10001]; // 포도주
int d[10001]; // 최대로 마실 수 있는 포도주의 양
int d_[100001][3]; // 안마심, 연속1잔, 연속2잔

int go(int n); //  풀이. 바텀업(Bottom-up) 방식 [반복문 이용]

int main(int argc, char* argv[]) {
	// 2019-04-24-수
	// 다이나믹 프로그래밍 문제풀이2 관련문제
	// 6. 포도주 시식 : https://www.acmicpc.net/problem/2156

	//  풀이2. 바텀업(Bottom-up) 방식 [반복문 이용]
	scanf("%d", &N); // (1 ≤ n ≤ 10,000)
	for (int i = 1; i <= N; i++) scanf("%d", &p[i]);
	printf("%d\n", go(N));

	return 0;
}

//  풀이. 바텀업(Bottom-up) 방식 [반복문 이용]
int last = 2;
int go(int n) {
	if (d[n] > 0) return d[n];
	d_[1][1] = p[1];
	d[1] = p[1];

	for (int i = last; i <= n; i++) {
		d_[i][0] = d[i - 1];
		d_[i][1] = d_[i - 1][0] + p[i];
		d_[i][2] = d_[i - 1][1] + p[i];
		d[i] = max(d_[i][0], max(d_[i][1], d_[i][2]));
	}

	return d[n];
}