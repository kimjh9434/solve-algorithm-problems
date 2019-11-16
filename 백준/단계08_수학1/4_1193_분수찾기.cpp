#include <stdio.h>
#include <string.h>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-26-금
	// 문자열 사용하기
	// 4	2675	문자열 반복 - https://www.acmicpc.net/problem/2675
	int t; scanf("%d", &t);
	while (t--) {
		int n; scanf("%d", &n);
		char str[21]; scanf("%s", str);
		int i = 0;
		while (str[i] != '\0') {
			for (int j = 0; j < n; j++) printf("%c", str[i]);
			i++;
		}
		printf("\n");
	}

	return 0;
}


//#include <iostream>
//#include <stdio.h>
//#include <string>
//using namespace std;
//
//int main(int argc, char* argv[]) {
//	// 2019-04-26-금
//	// 문자열 사용하기
//	// 4	2675	문자열 반복 - https://www.acmicpc.net/problem/2675
//	int t; scanf("%d", &t);
//	while (t--) {
//		int n; string str;
//		cin >> n >> str;
//		string str2;
//		for (char c : str) {
//			for (int j = 0; j < n; j++) str2 += c;
//		}
//		cout << str2 << "\n";
//	}
//
//	return 0;
//}