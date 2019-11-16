#include <iostream>
#include <cstring>
using namespace std;

int a[21];

int f(int n);

int main(int argc, char* argv[]) {
	// 2019-11-02-토
	// 백준_단계10	재귀 문제
	// 2	10870	피보나치 수 5 : https://www.acmicpc.net/problem/10870
	// 피보나치 수 역시 단순 for문으로도 구할 수 있지만, 학습을 위해 재귀를 써 봅시다.
	// 0  1  2  3  4  5  6  7   8   9   10  11  12   13   14   15   16   17   ...
	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597 ...
	// n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
	// 첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.

	memset(a, -1, sizeof(a));

	int n; cin >> n;
	cout << f(n) << endl;

	return 0;
}

// n번째 피보나치 수를 반환하는 재귀함수
int f(int n) {
	// n번째 피보나치 수를 이미 구했다면 반환
	if (a[n] != -1) return a[n];

	// n의 값이 0또는 1일 경우, 각각 해당 값을 반환
	if (n == 0) return 0;
	if (n == 1) return 1;

	// n번째 피보나치 수의 값은 f(n-1) + f(n-2)의 값이다.
	a[n] = f(n - 1) + f(n - 2);

	return a[n];
}