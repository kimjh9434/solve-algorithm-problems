#include <iostream>
using namespace std;

bool isPrime(int n) {
	bool isPrime = true;

	if (n < 2)
		isPrime = false;

	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) {
			isPrime = false;
			break;
		}
	}

	return isPrime;
}

int main(int argc, char* argv[]) {

	// 2019-04-11-목
	// 백준_수학
	// 소수 관련 문제
	// 소수 찾기 : https://www.acmicpc.net/problem/1978

	int n, num, cnt = 0;

	cin >> n;
	while (n--) {
		cin >> num;
		if (isPrime(num))
			cnt++;
	}
	cout << cnt << endl;

	return 0;
}