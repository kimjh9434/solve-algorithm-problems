#include <cstdio>

int N;//첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N
int d[1000001];

int go1(int n); //  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용] 
int go2(int n); //  풀이2. 바텀업(Bottom-up) 방식이 [반복문 이용] 

int main(int argc, char* argv[]) {
	// 2019-04-24-수
	// 다이나믹 프로그래밍 문제풀이1 관련문제
	// 1. 1로 만들기 : https://www.acmicpc.net/problem/1463
	//  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용] 

	scanf("%d", &N);
	printf("%d\n", go1(N));

	return 0;
}

//  풀이1. 탑다운(Top-down) 방식 [재귀함수 이용] 
int go1(int n) {
	if (n == 1) return 0;
	if (d[n] > 0) return d[n];
	d[n] = go1(n - 1) + 1;
	int tmp;
	if (n % 2 == 0) {
		tmp = go1(n / 2) + 1;
		if (d[n] > tmp) d[n] = tmp;
	}
	if (n % 3 == 0) {
		tmp = go1(n / 3) + 1;
		if (d[n] > tmp) d[n] = tmp;
	}
	return d[n];
}