#include <cstdio>
using namespace std;

void solve();

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 9_6064_카잉 달력 : https://www.acmicpc.net/problem/6064
	int k; scanf("%d", &k);
	while (k--) {
		solve();
	}
	return 0;
}

void solve() {
	int	M, N, x, y;
	scanf("%d %d %d %d", &M, &N, &x, &y);

	x--; y--;
	int ans = x;
	int MAX = N * M;
	bool ok = false;
	while (ans < MAX) {
		if (ans % N == y) {
			printf("%d \n", ans + 1);
			ok = true;
			break;
		}
		ans += M;
	}
	if (!ok) printf("%d \n", -1);
}