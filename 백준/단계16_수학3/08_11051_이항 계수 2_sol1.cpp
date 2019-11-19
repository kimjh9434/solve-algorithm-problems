#include <iostream>
using namespace std;
int m = 10007;
int d[1001][1001];
int cal(int n, int k);
int main(int argc, char* argv[]) {
	// 2019-07-09-화
	// 08. 이항 계수2 : https://www.acmicpc.net/problem/11051
	// 자연수 N과 정수 K가 주어졌을 때 이항 계수 (N | K)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
	// sol : nCk = (n-1)Ck + (n-1)C(k-1)

	int n, k; cin >> n >> k;
	cout << cal(n, k) << "\n";
	return 0;
}
int cal(int n, int k) {
	if (k == 0 or k == n) return 1;
	if (d[n][k] > 0) return d[n][k];
	d[n][k] = (cal(n - 1, k) + cal(n - 1, k - 1)) % m;
	return d[n][k];
}