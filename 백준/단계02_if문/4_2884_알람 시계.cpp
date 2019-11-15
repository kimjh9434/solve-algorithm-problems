#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// if문 4	2884	알람 시계 : https://www.acmicpc.net/problem/2884
	// : 시간 뺄셈 문제 - 주어진 시간의 45분 전의 시간을 구하라

	int H, M; cin >> H >> M;
	M -= 45;
	if (M < 0) {
		H -= 1;
		M += 60;
		if (H < 0) H += 24;
	}
	cout << H << " " << M << endl;

	return 0;
}