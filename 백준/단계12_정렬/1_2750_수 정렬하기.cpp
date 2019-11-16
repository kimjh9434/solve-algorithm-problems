#include <cstdio>
#include <algorithm>
using namespace std;

int a[1000];

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계11	정렬
	// 1	2750	수 정렬하기 : https://www.acmicpc.net/problem/2750
	// 시간 복잡도가 O(n²)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 삽입 정렬, 거품 정렬 등이 있습니다.

	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	sort(a, a + n);
	for (int i = 0; i < n; i++) printf("%d\n", a[i]);

	return 0;
}