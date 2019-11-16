#include <cstdio>
#include <algorithm>
using namespace std;

int a[10001];

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계11	정렬
	// 3	10989	수 정렬하기 3
	// 수의 범위가 작다면 카운팅 정렬을 사용하여 더욱 빠르게 정렬할 수 있습니다.

	int n; scanf("%d", &n);
	int num = 0;
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		a[num]++;
	}
	for (int i = 0; i <= 10000; i++)
		if (a[i] != 0)
			for (int j = 0; j < a[i]; j++)
				printf("%d\n", i);

	return 0;
}