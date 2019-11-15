#include <iostream>
using namespace std;

bool isOneNumber(int n);

int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// Step05_함수 사용하기
	// 3	1065	한수
	// https://www.acmicpc.net/problem/1065

	// 기본 개념. '한수' 라는 것이 각 자리수가 등차수열을 이루는 것이라고 했는데
	// 등차수열이라는 개념 자체가 3개 이상의 수가 있어야 가능하다.
	// 따라서 99이하의 수는 한수의 개수가 N 그 자체이며, 100 이상부터 한수의 개수를 추가로 파악해야 한다.

	int N;
	int cnt = 0;
	int i;

	// 1,000보다 작거나 같은 자연수 N을 입력받고,
	cin >> N;

	if (N < 100) { // N이 99이하인 경우,
		cnt = N; // 그때까지 한수의 개수는 N개이다.
	}
	if (N == 1000) { // N이 1000일 경우,
		N = 999; // N을 999로 바꿔준다.
	}

	if (N > 99) { // N이 100이상인 경우,
		cnt = 99; // 한수의 개수는 99개 이상.

		// 1부터 N까지의 수 중 한수의 개수를 구한다.
		for (i = 100; i <= N; i++) {
			if (isOneNumber(i)) {
				cnt++;
			}
		}
	}
	// 개수를 출력한다.
	cout << cnt;

	return 0;
}

bool isOneNumber(int n) {
	int d100, d10, d1;
	bool isOneNumber = false;

	// i의 100, 10, 1의 자리 수를 구한다.
	d100 = n / 100;
	d10 = (n - d100 * 100) / 10;
	d1 = n - d100 * 100 - d10 * 10;

	if (d100 - d10 == d10 - d1)
		isOneNumber = true;
	return isOneNumber;
}