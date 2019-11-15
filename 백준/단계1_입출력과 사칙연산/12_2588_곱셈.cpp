// C++ 소스코드

#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08
	// 12	2588	곱셈
	// 빈 칸에 들어갈 수는?

	int num1, num2; cin >> num1 >> num2;
	int num3 = 0, num4 = 0, num5 = 0, num6 = 0;

	num3 = num1 * (num2 % 10);
	num4 = num1 * ((num2 % 100) / 10);
	num5 = num1 * (num2 / 100);
	num6 = num3 + num4 * 10 + num5 * 100;

	cout << num3 << endl;
	cout << num4 << endl;
	cout << num5 << endl;
	cout << num6 << endl;

	return 0;
}