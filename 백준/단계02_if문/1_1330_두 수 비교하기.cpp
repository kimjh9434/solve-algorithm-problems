#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// 1	1330	두 수 비교하기 : https://www.acmicpc.net/problem/1330
	// : 두 수를 비교한 결과를 출력하는 문제

	int A, B; cin >> A >> B;
	string ans = "";
	if (A > B) ans = ">";
	else if (A < B) ans = "<";
	else  ans = "==";
	cout << ans << endl;
	return 0;
}