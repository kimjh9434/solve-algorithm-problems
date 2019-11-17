#include <iostream>
using namespace std;

// 최대공약수 - 재귀함수를 이용
int GCD(int a, int b) {
	if (b == 0) {
		return a;
	}
	else {
		return GCD(b, a % b);
	}
}

// 최대공약수 - 반복문을 이용
int GCD2(int a, int b) {
	int r;
	while (b != 0) {
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}

// 최소공배수
int LCM(int a, int b) {
	int gcd = GCD(a, b);
	return (a * b / gcd);
}

int main(int argc, char* argv[]) {

	// 2019-04-11-목
	// 백준_수학
	// 최대공약수, 최소공배수 관련 문제
	// https://www.acmicpc.net/problem/2609

	int a, b;
	cin >> a >> b;

	cout << GCD(a, b) << endl;
	cout << LCM(a, b) << endl;

	return 0;
}