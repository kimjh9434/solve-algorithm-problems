#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// 3	2753	윤년 : https://www.acmicpc.net/step/4
	// : 윤년을 판별하는 문제 : 윤년이면 1, 아니면 0을 출력

	// 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때 이다.

	int year; cin >> year;
	bool isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)); // CF. 윤년 = leap year
	cout << isLeapYear << endl;
	return 0;
}