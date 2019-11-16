#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계9	수학 2
	// 6	1085	직사각형에서 탈출 : https://www.acmicpc.net/problem/1085

	// 풀이구상 : 그냥 각 모서리까지의 거리가 제일 작은 값을 출력한다.
	int x, y, w, h;
	cin >> x >> y >> w >> h;
	int n1, n2, ans;

	if (x < w - x) n1 = x; else n1 = w - x;
	if (y < h - y) n2 = y; else n2 = h - y;
	if (n1 < n2) ans = n1; else ans = n2;
	cout << ans << endl;

	return 0;
}