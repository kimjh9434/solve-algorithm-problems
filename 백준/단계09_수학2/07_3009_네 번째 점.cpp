#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계9	수학 2
	// 7	3009	네 번째 점 : https://www.acmicpc.net/problem/3009
	// 직사각형을 완성하는 문제

	// 풀이구상 : 그냥 x, y에서 각각 1번만 나온 값을 출력한다. 
	int x1, y1, x2, y2, x3, y3, x = 0, y = 0;
	cin >> x1 >> y1;
	cin >> x2 >> y2;
	cin >> x3 >> y3;
	if (x1 == x2) x = x3;
	else if (x1 == x3) x = x2;
	else x = x1;
	if (y1 == y2) y = y3;
	else if (y1 == y3) y = y2;
	else y = y1;
	cout << x << " " << y << endl;
	return 0;
}