#include<iostream>
using namespace std;
int main(int argc, char* argv[]) {
	// 2019-10-08-화
	// 단계8	수학 1 : 1	1712	손익분기점 : https://www.acmicpc.net/problem/1712
	// : 이익이 발생하는 지점을 찾는 문제
	long long a, b, c;
	cin >> a >> b >> c;
	long long interest = c - b;
	long long b_point = 0;
	if (b >= c) {
		b_point = -1;
	}
	else {
		b_point = a / interest;
		b_point++;
	}
	cout << b_point << endl;
}