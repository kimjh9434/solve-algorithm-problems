#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계9	수학 2
	// 8	4153	직각삼각형 : https://www.acmicpc.net/problem/4153
	// 피타고라스의 정리에 대해 배우는 문제 - 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하라

	// 풀이구상 : 그냥 a^2 + b^2 = c^2가 되는지 확인한다.
	long a[3];
	string ans;
	cin >> a[0] >> a[1] >> a[2];
	do {
		sort(a, a + 3);
		if (a[0] * a[0] + a[1] * a[1] == a[2] * a[2]) ans = "right"; else ans = "wrong";
		cout << ans << endl;
		cin >> a[0] >> a[1] >> a[2];
	} while (a[0] != 0 && a[1] != 0 && a[2] != 0);

	return 0;
}