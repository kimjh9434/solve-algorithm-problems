// 4	4949	균형잡힌 세상

#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-30-수
	// 백준_단계15	스택 관련 문제
	// 4	4949	균형잡힌 세상 : https://www.acmicpc.net/problem/4949
	// 위와 같은데 괄호의 종류가 다양해진 문제

	// 각 줄마다 해당 문자열 '(', ')', '[', ']'이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.

	while (true) {
		stack<int> s;
		string str;
		bool isCorrect = true;

		getline(cin, str);
		if (str == ".") break;

		for (int i = 0; i < (int)(str.length()); i++) {
			char x = str[i];

			switch (x) {
			case '(':
			case '[': s.push(x); break;
			case ')':
				if (s.empty() || s.top() != '(') {
					isCorrect = false;
				}
				else {
					s.pop();
				}
				break;
			case ']':
				if (s.empty() || s.top() != '[') {
					isCorrect = false;
				}
				else {
					s.pop();
				}
				break;
			default: break;
			}
			if (!isCorrect) break;
		}
		if (!s.empty()) isCorrect = false;

		(isCorrect) ? (cout << "yes\n") : (cout << "no\n");
	}
	return 0;
}