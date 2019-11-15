#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 문자열 사용하기
	// 5	1157	단어 공부
	// https://www.acmicpc.net/problem/1157


	// 1. 단어를 입력받는다.
	string str; // 이 문자열의 길이는 1,000,000을 넘지 않는다.
	cin >> str;

	// 2. 각각의 알파벳을 모두 대문자로 변환한다. 
	transform(str.begin(), str.end(), str.begin(), ::toupper); // CF. 소문자로 변환시 tolower 사용

	// 3. 각 알파벳의 개수를 센다.
	int cnt[26] = { 0, };
	for (char c : str) cnt[c - 'A']++;

	// 4. 가장 많은 알파벳의 index를 구한다.
	int MAX = *max_element(cnt, cnt + 26);
	int maxIndex, ok = 0;
	for (int i = 0; i < 26; i++) {
		if (cnt[i] == MAX) {
			maxIndex = i;
			ok++;
		}
	}

	// 최댓값의 중복여부에 따라 결과값을 출력한다.
	if (ok == 1) cout << (char)(65 + maxIndex) << endl;
	else cout << "?" << endl;

	return 0;
}