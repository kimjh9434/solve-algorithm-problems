#include <cstdio>
#include <vector>
#include <map>
#include <algorithm>
#include <numeric>
#include <cmath>
using namespace std;

int a[500000];
int b[8001];

bool desc(int a, int b) {
	return a > b;
}

int main(int argc, char* argv[]) {
	// 2019-10-09-수
	// 백준_단계11	정렬
	// 4	2108	통계학 : https://www.acmicpc.net/problem/2108
	// 정렬을 활용하는 문제

	// n개 수 입력받기
	int n; scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);

	// 산술평균: N개의 수들의 합을 N으로 나눈 값
	int ans1 = round((double)accumulate(a, a + n, 0) / n);
	printf("%d\n", ans1);

	// 중앙 값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	sort(a, a + n);
	int ans2 = a[n / 2];
	printf("%d\n", ans2);

	// 최빈 값 : N개의 수들 중 가장 많이 나타나는 값
	for (int i = 0; i < n; i++) b[a[i] + 4000]++;
	int* max1 = max_element(b, b + 8001); // CF. 이 최댓값이 중복이 있으면 그 다음으로 큰 수를 고른다.
	int ans3 = distance(b, max1) - 4000;

	int* max2 = max_element(b + ans3 + 4001, b + 8001);
	if (*max1 == *max2) ans3 = distance(b, max2) - 4000;
	printf("%d\n", ans3);

	// 범   위 : N개의 수들 중 최댓값과 최솟값의 차이
	int max = *max_element(a, a + n);
	int min = *min_element(a, a + n);
	int ans4 = max - min;
	printf("%d\n", ans4);

	return 0;
}