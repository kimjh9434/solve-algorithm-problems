#include <iostream>
#include <stack>
using namespace std;


int main(int argc, char* argv[]) {
	// 2019-10-30-수
	// 백준_단계17	스택 관련 문제
	// 2	10773	제로 : https://www.acmicpc.net/problem/10773
	// 가장 최근에 쓴 수를 지우는 문제

	// 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
	// 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다.재민이를 도와주자!

	// 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.

	stack<int> s;
	int k, n;
	cin >> k;
	while (k--) {
		cin >> n;
		if (n != 0) {
			s.push(n);
		}
		else {
			s.pop();

		}
	}
	int sum = 0;
	while (!s.empty()) {
		sum += s.top();
		s.pop();
	}
	cout << sum << endl;

	return 0;
}