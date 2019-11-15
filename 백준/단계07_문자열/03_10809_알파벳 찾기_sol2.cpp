#include <iostream>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 문자열 사용하기
	// 3	10809	알파벳 찾기 - https://www.acmicpc.net/problem/10809

	string str;
	cin >> str;
	for (int i = 'a'; i <= 'z'; i++) {
		cout << (int)str.find((char)i) << " ";
	}

	return 0;
}