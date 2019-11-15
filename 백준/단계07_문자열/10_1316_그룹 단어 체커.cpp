#include <iostream>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 단계7	문자열	문자열을 다루는 문제들을 해결해 봅시다.
	// 10_1316_그룹 단어 체커
	// https://www.acmicpc.net/problem/1316

	int N; cin >> N;
	string str;
	int cnt = 0;
	while (N--) {
		cin >> str;
		bool ok = true;
		for (int i = 1; i < (int) str.size(); i++) {
			if (str[i - 1] != str[i] && (int) str.find(str[i]) != i) {
				ok = false;
				break;
			}
		}
		if (ok) cnt++;
	}
	cout << cnt << endl;
	return 0;
}