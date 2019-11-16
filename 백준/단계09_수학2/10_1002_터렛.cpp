#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계9	수학 2
	// 10	1002	터렛 : https://www.acmicpc.net/problem/1002
	// 두 원의 교점의 개수를 구하는 문제

	// 풀이구상
	// 두 점 사이의 거리를 d라 할 때, d*d = dx*dx+dy*dy

	int t; cin >> t;
	while (t--)
	{
		long long x1, y1, r1, x2, y2, r2;
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		long long dx = x1 - x2;
		long long dy = y1 - y2;

		if (r1 > r2) swap(r1, r2);
		long long add = r1 + r2;
		add = add * add;
		long long sub = r2 - r1;
		sub = sub * sub;
		long long d = dx * dx + dy * dy;

		if (d < add && d > sub) {
			cout << 2;
		}
		else if (d == add || (d == sub && d != 0)) {
			cout << 1;
		}
		else if (d < sub || d > add) {
			cout << 0;
		}
		else if (d == 0) {
			if (r1 == r2) cout << -1;
			else cout << 0;
		} cout << '\n';
	}

	return 0;
}