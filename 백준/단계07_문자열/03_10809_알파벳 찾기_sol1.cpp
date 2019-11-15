#include <stdio.h>
#include <string.h>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 문자열 사용하기
	// 3	10809	알파벳 찾기 - https://www.acmicpc.net/problem/10809
	char str[101];
	int indexes[26];
	memset(indexes, -1, sizeof(indexes));
	scanf("%s", str);
	int i = 0;
	while (str[i] != '\0') {
		if (indexes[(int)str[i] - (int)'a'] == -1) indexes[(int)str[i] - (int)'a'] = i;
		i++;
	}
	for (int i = 0; i < 26; i++) printf("%d ", indexes[i]);

	return 0;
}