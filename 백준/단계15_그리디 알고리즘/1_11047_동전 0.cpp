#include <iostream>
using namespace std;

int a[10];

int main(int argc, char* argv[]) {
	// 2019-11-06-수
	// 백준_단계15	15	그리디 알고리즘 관련 문제
	// 1	11047	동전 0 : https://www.acmicpc.net/problem/11047

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++) cin >> a[i];

	int ans = 0;

	n -= 1;
	while (k != 0) {
		if (k >= a[n]) {
			ans += k / a[n];
			k = k % a[n];
		}
		n -= 1;
	}
	cout << ans << "\n";
	return 0;
}