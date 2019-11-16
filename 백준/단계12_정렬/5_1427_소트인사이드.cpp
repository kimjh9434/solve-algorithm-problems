#include <cstdio>
using namespace std;

int a[10];

int main(int argc, char* argv[]) {
	// 2019-10-10-목
	// 백준_단계11	정렬
	// 5	1427	소트인사이드 : https://www.acmicpc.net/problem/1427
	// 숫자를 정렬하는 문제

	char ch = ' ';
	while (ch != '\n') {
		scanf("%1c", &ch);
		a[ch - '0']++;
	}
	for (int i = 9; i >= 0; i--)
		if (a[i] != 0)
			for (int j = 0; j < a[i]; j++)
				printf("%d", i);
	printf("\n");
	return 0;
}