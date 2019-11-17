#include <cstdio>
#include <algorithm>
#include <string.h>
using namespace std;
int N;// (1 ≤ n ≤ 100)
long long d[101];
long long d_[101][10];
long long mod = 1000000000;

long long go1(int n); //  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용]
long long go1_(int n, int m);// 풀이1 보조
long long go2(int n); //  풀이2. 바텀업(Bottom-up) 방식이 [반복문 이용]


int main(int argc, char* argv[]) {
	// 2019-04-24-수
	// 다이나믹 프로그래밍 문제풀이1 관련문제
	// 2. 쉬운 계단 수 : https://www.acmicpc.net/problem/10844
	// - N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램 [정답을 1,000,000,000으로 나눈 나머지를 출력]
	// 조건 : 0으로 시작하는 수는 없다

	//  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용]
	scanf("%d", &N);
	printf("%lld\n", go1(N));

	return 0;
}

//  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용]
long long go1(int n) {
	if (d[n] > 0) return d[n];
	for (int i = 1; i < 10; i++) d_[1][i] = 1;

	for (int i = 0; i < 10; i++) d_[n][i] = go1_(n, i);

	for (int i = 0; i < 10; i++) d[n] = (d[n] + d_[n][i]) % mod;

	return d[n];
}
long long go1_(int n, int m) {
	if (d_[n][m] > 0) return d_[n][m];
	if (n < 0) return 0;

	switch (m) {
	case 0: d_[n][m] = go1_(n - 1, 1); break;
	case 9: d_[n][m] = go1_(n - 1, 8); break;
	default:d_[n][m] = (go1_(n - 1, m - 1) + go1_(n - 1, m + 1)) % mod; break;
	}

	return d_[n][m];
}