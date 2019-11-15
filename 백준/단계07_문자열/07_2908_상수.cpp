#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-28-일
	// Step07 문자열 사용하기
	// 7	2908	상수 
	// https://www.acmicpc.net/problem/2908

	string n1, n2;
	cin >> n1 >> n2;
	reverse(n1.begin(), n1.end()); reverse(n2.begin(), n2.end());
	cout << max(atoi(n1.c_str()), atoi(n2.c_str())) << endl;
	return 0;
}