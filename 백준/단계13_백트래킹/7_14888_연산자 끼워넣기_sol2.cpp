#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> n;
int Max = -1000000000;
int Min = +1000000000;

// 재귀함수
void go(int cal, int p, int m, int M, int d, int i) {
	// 1. 불가능한 경우 : 연산자 중 하나가 마이너스인 경우
	if (p < 0 || m < 0 || M < 0 || d < 0) return;

	// 2. 끝난 경우 : 인덱스가 수열의 길이와 같아진 경우
	if (i == (int)n.size()) {
		// 그동안의 cal을 비교한다.
		Max = max(Max, cal);
		Min = min(Min, cal);
		//cout << Max << " " << Min << endl;
		return;
	}

	// 3. 다음 경우 호출
	go(cal + n[i], p - 1, m, M, d, i + 1);
	go(cal - n[i], p, m - 1, M, d, i + 1);
	go(cal * n[i], p, m, M - 1, d, i + 1);
	go(cal / n[i], p, m, M, d - 1, i + 1);
}

int main(int argc, char* argv[])
{
	// 2019-04-18-목
	// 백준_브루트포스
	// 재귀함수 사용 방법 관련 문제
	// 연산자 끼워넣기

	int N, x;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x;
		n.push_back(x);
	}

	int p, m, M, d; // plus, minus, Multiple, division
	cin >> p >> m >> M >> d;
	go(n[0], p, m, M, d, 1);

	cout << Max << endl;
	cout << Min << endl;

	return 0;
}