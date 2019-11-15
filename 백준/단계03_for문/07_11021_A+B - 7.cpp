#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// for문 7	10950	A+B - 7 : https://www.acmicpc.net/problem/11021
	// : A+B를 조금 더 아름답게 출력하는 문제

	int T, A, B; cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> A >> B;
		cout << "Case #" << i << ": " << A + B << endl;
	}
	return 0;
}