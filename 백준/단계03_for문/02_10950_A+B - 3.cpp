#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// for문 2	10950	A+B - 3 : https://www.acmicpc.net/problem/10950
	// : A+B를 여러 번 출력하는 문제

	int T, A, B; cin >> T;
	while (T--) {
		cin >> A >> B;
		cout << A + B << endl;;
	}
	return 0;
}