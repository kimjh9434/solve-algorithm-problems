#include <iostream>
#include <string.h>   //strupr,strlwr가 있다.

using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// 단계7	문자열
	// 6	1152	단어의 개수
	// https://www.acmicpc.net/problem/1157


	// 1. 단어를 입력받는다.
	char str[1000001]; // 이 문자열의 길이는 1,000,000을 넘지 않는다.
	cin.getline(str, sizeof(str));

	// 2. 단어의 길이를 구한다.
	int strLen = strlen(str);

	// 3. 각각의 알파벳 중 소문자가 있으면 대문자로 변환한다. 
	int i;
	for (i = 0; i < strLen; i++) {
		if (str[i] >= 'a' && str[i] <= 'z') {
			// 방법 1. 아스키 코드의 차이값을 이용한 변환
			str[i] -= 32;

			// 방법 2. 구현 되어 있는 함수를 이용한 변환 - #include <string.h> 이용
			// _strupr_s(str, sizeof(str)); // <- 왜인지는 모르겠지만 컴파일 에러가 난다.
		}
	}

	// 4. 각각의 알파벳의 개수를 샌다.
	int cnt[26] = { 0, };
	for (i = 0; i < strLen; i++) {
		cnt[str[i] - 65]++;
	}

	// 5. 가장 많은 알파벳의 index를 구한다.
	int max = 0;
	int maxIndex = 0;
	bool isMaxOverlap = false;

	for (i = 0; i < 26; i++) {
		//알파벳 '?'의 개수가 기존의 최댓값보다 더 크다면,
		if (cnt[i] > max) {
			// 알파벳 '?'가 가장 많이 사용된 알파벳이다.
			max = cnt[i];
			maxIndex = i;

			// 최댓값은 중복되지 않는다.
			isMaxOverlap = false;
		}
		//알파벳 '?'의 개수가 기존의 최댓값과 같다면,
		else if (cnt[i] == max) {
			// 최댓값이 중복된다.
			isMaxOverlap = true;
		}
	}

	// 최댓값의 중복여부에 따라 결과값을 출력한다.
	if (isMaxOverlap) {
		cout << "?" << endl;
	}
	else {
		cout << (char)(65 + maxIndex) << endl;
	}

	return 0;
}