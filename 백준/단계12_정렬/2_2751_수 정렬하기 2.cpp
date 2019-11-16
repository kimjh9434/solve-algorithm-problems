#include <cstdio>
#include <algorithm>
using namespace std;

int a[1000000];

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계11	정렬
	// 2	2751	수 정렬하기 2 : https://www.acmicpc.net/problem/2751
	// 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 병합 정렬, 힙 정렬 등이 있습니다.

	// 전엔 맞았을텐데 재채점되더니 틀렸다고 나온다.
	// 뭐 그까이꺼 그냥 정렬 알고리즘 갖다 써야겠다. 내가 구현할 필요가 뭐가 있는가...

	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	sort(a, a + n);
	for (int i = 0; i < n; i++) printf("%d\n", a[i]);

	return 0;
}