#include <cstdio>
#include <algorithm>
using namespace std;
int N;// (1 ≤ n ≤ 100,000)
int a[100000];
int d[100000];

void go(); // 바텀업(Bottom-up) 방식 풀이 [반복문 이용]

int main(int argc, char* argv[]) {
	// 2019-04-25-목
	// 다이나믹 프로그래밍 문제풀이3 관련문제
	// 6. 연속합 : https://www.acmicpc.net/problem/1912

	// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
	scanf("%d", &N); // (1 ≤ n ≤ 100,000)
	for (int i = 0; i < N; i++) scanf("%d", &a[i]);
	go();
	printf("%d\n", *max_element(d, d + N));

	return 0;
}

// 바텀업(Bottom-up) 방식 풀이 [반복문 이용]
void go() {
	for (int i = 0; i < N; i++) {
		d[i] = a[i];
		if (i == 0) continue;
		if (a[i] < a[i] + d[i - 1]) {
			d[i] = a[i] + d[i - 1];
		}
	}
}