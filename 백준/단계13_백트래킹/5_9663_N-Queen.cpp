#include <iostream>
using namespace std;

int N; // (1 ≤ N < 15)
bool cols[15];
bool diags1[30];
bool diags2[30];

bool check(int row, int col) {
	if (cols[col]) return false;             // 세로열
	if (diags1[row + col]) return false;     // 왼  쪽 위 대각선
	if (diags2[row - col + N]) return false; // 오른쪽 위 대각선
	return true;
}

int go(int row) {
	if (row == N) return 1;
	int cnt = 0;
	for (int col = 0; col < N; col++) {
		if (check(row, col)) {
			cols[col] = true;
			diags1[row + col] = true;
			diags2[row - col + N] = true;
			cnt += go(row + 1);
			cols[col] = false;
			diags1[row + col] = false;
			diags2[row - col + N] = false;
		}
	}
	return cnt;
}
int main(int argc, char* argv[]) {
	// 2019-04-29-월
	// 백트레킹 관련문제
	// 4. N-Queen : https://www.acmicpc.net/problem/9663
	cin >> N;
	cout << go(0) << endl;;
	return 0;
}