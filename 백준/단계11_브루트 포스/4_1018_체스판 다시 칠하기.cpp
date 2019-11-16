// 4	1018	체스판 다시 칠하기
#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main(int argc, char* argv[]) {
	// 2019-10-16-수
	// 백준_단계10	브루트 포스 관련 문제
	// 4	1018	체스판 다시 칠하기 : https://www.acmicpc.net/problem/1018
	// M*N 크기의 보드를 잘라서, 8*8 크기의 체스판을 만들고 한다.
	// 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램

	// 풀이구상 : 그냥 모든 경우의 수를 구한다.
	// == (0,0) ~ (n-8, m-8)까지 모두 구한다.
	// 해당 영역의 시작위치를 (x, y)라고 가정시,
	// 1) 시작을 W로하는 경우와, 
	// 2) B로 하는 경우 각각 구해야한다.
	// 각각의 경우에서, (x, y) ~ (x+7, y+7)까지 확인을 하는데,
	// W or H에 따라 다시 칠해야 하는 수를 센다.
	// 최솟값이면 갱신한다.

	int n, m; cin >> n >> m; // N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수
	vector<string> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];

	int min = 50 * 50;
	int cnt;
	// 풀이구상 : 그냥 모든 경우의 수를 구한다.
	// == (0,0) ~ (n-8, m-8)까지 모두 구한다.
	for (int i = 0; i <= n - 8; i++) {
		for (int j = 0; j <= m - 8; j++) {
			//cout << "(" << i << ", "<< j << ") : ";
			// 해당 영역의 시작위치를 (x, y)라고 가정시,
			// 1) 시작을 W로하는 경우 : x+y의 합이 짝수가 모두 W, 홀수면 B
			// (x, y) ~ (x+7, y+7)까지 확인을 하는데,
			cnt = 0;
			for (int x = i; x < i + 8; x++) {
				for (int y = j; y < j + 8; y++) {
					// W or B에 따라 다시 칠해야 하는 수를 센다.
					if (((x + y) % 2 == 0 && a[x][y] == 'B') || ((x + y) % 2 != 0 && a[x][y] == 'W')) {
						cnt++;
					}
				}
			}
			// 최솟값이면 갱신한다.
			if (cnt < min) min = cnt;
			//cout << cnt << " ";

			// 2) B로 하는 경우 : x+y의 합이 짝수가 모두 B, 홀수면 W
			// (x, y) ~ (x+7, y+7)까지 확인을 하는데,
			cnt = 0;
			for (int x = i; x < i + 8; x++) {
				for (int y = j; y < j + 8; y++) {
					// W or B에 따라 다시 칠해야 하는 수를 센다.
					if (((x + y) % 2 == 0 && a[x][y] == 'W') || ((x + y) % 2 != 0 && a[x][y] == 'B')) {
						cnt++;
					}
				}
			}
			// 최솟값이면 갱신한다.
			if (cnt < min) min = cnt;
			//cout << cnt << " \n";
		}
		//cout << "\n";
	}
	cout << min << "\n";

	return 0;
}