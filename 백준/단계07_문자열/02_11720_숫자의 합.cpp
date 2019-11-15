#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// 단계7	문자열
	// 2	11720	숫자의 합

	// 풀이 : char[] 이용
	int N;
	char sNumber[101];
	int sum = 0;
	// 입력받기
	cin >> N;
	cin >> sNumber;

	// 쪼개기
	for (int i = 0; i < N; i++) {
		sum += sNumber[i] - '0';
	}

	cout << sum << endl;

	return 0;
}