#include <cstdio>
#include <utility>
#include <algorithm>
using namespace std;

pair<int, int> a[100000];

int main(int argc, char* argv[]) {
	// 2019-10-10-목
	// 백준_단계11	정렬
	// 6	11650	좌표 정렬하기 : https://www.acmicpc.net/problem/11650
	// 좌표를 정렬하는 문제 - 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램

	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d %d", &a[i].first, &a[i].second);
	sort(a, a + n);
	for (int i = 0; i < n; i++) printf("%d %d\n", a[i].first, a[i].second);

	return 0;
}