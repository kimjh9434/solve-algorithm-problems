// C++ 소스코드
#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {

	// 2019-04-11-목
	// https://www.acmicpc.net/problem/10430

	int A, B, C;
	cin >> A >> B >> C;

	cout << (A + B) % C << endl;
	cout << (A % C + B % C) % C << endl;
	cout << (A * B) % C << endl;
	cout << (A % C * B % C) % C << endl;

	return 0;
}