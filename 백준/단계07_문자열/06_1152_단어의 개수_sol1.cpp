#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// 단계7	문자열
	// 6	1152	단어의 개수
	// https://www.acmicpc.net/problem/1152


	// 1. 문자열을 입력받는다.
	char str[1000001]; // 이 문자열의 길이는 1,000,000을 넘지 않는다.
	cin.getline(str, sizeof(str));

	int i = 0;
	// 예외처리1. 첫 문자가 ' '인지 확인한다.
	if (str[i] == ' ') {
		i++;
	}

	// 이후 문장의 끝(\0)이 나오기 전까지, 공백 ' '의 숫자를 샌다.
	int wcnt = 1;
	for (; str[i] != '\0'; i++) {
		if (str[i] == ' ')
			wcnt++;
	}
	// 예외처리2. 마지막 문자가 ' '인지 확인한다.
	if (str[i - 1] == ' ') {
		wcnt--;
	}

	// 결과물을 출력한다.
	cout << wcnt << endl;
}