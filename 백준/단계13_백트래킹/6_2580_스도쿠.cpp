#include <cstdio>
using namespace std;

int board[10][10];
bool c1[10][10];// x축
bool c2[10][10];// y축
bool c3[10][10];// 3x3 박스

int square(int x, int y) {
	return (y / 3 * 3 + x / 3);
}

bool go(int z) {
	if (z == 81) {
		for (int y = 0; y < 9; y++) { for (int x = 0; x < 9; x++) printf("%d ", board[y][x]);  printf("\n"); }
		printf("\n");
		return true;
	}
	int y = z / 9;
	int x = z % 9;
	if (board[y][x] != 0) return go(z + 1);
	else {
		for (int i = 1; i <= 9; i++) {
			if (!c1[x][i] && !c2[y][i] && !c3[square(x, y)][i]) {
				c1[x][i] = c2[y][i] = c3[square(x, y)][i] = true;
				board[y][x] = i;
				if (go(z + 1)) {
					return true;
				}
				board[y][x] = 0;
				c1[x][i] = c2[y][i] = c3[square(x, y)][i] = false;
			}
		}
	}
	return false;
}

int main(int argc, char* argv[]) {
	// 2019-04-29-월
	// 백트레킹 관련문제
	// 5. 스도쿠 : https://www.acmicpc.net/problem/2580
	for (int y = 0; y < 9; y++) {
		for (int x = 0; x < 9; x++) {
			scanf("%d", &board[y][x]);
			c1[x][board[y][x]] = c2[y][board[y][x]] = c3[square(x, y)][board[y][x]] = true;
		}
	}
	go(0);
	return 0;
}
