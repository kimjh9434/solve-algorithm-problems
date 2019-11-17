#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-06-수
	// 백준_단계15	15	그리디 알고리즘 관련 문제
	// 4	2217	로프 : https://www.acmicpc.net/problem/2217
	// 각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램

	int n; // N(1≤n≤100,000)
	int a[100000];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);

	sort(a, a + n);

	int MAX = 0;
	int w = 0;

	for (int i = 0; i < n; i++) {
		w = a[i] * (n - i);
		if (MAX < w) MAX = w;
	}

	printf("%d\n", MAX);
}