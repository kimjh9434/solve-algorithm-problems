#include <iostream>
#include <string>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;

set<string> s[51];

int main(int argc, char* argv[]) {
	// 2019-10-10-목
	// 백준_단계11	정렬
	// 8	1181	단어 정렬 : https://www.acmicpc.net/problem/1181
	// 단어의 순서를 정의하여 정렬하는 문제 - N개의 단어를 1) 길이가 짧은 것부터, 2) 길이가 같으면 사전 순으로 출력
	int n; cin >> n;
	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		s[str.length()].insert(str);
	}
	for (int i = 1; i <= 50; i++) {
		if (s[i].size() != 0) {
			vector<string> v(s[i].begin(), s[i].end());
			sort(v.begin(), v.end());
			for (string x : v) cout << x << "\n";
		}
	}

	return 0;
}