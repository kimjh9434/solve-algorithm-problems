#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

pair<int, string> a[100000];

bool cmp(const pair<int, string>& p1, const pair<int, string>& p2) {
	return p1.first < p2.first;
}

int main(int argc, char* argv[]) {
	// 2019-10-10-목
	// 백준_단계11	정렬
	// 9	10814	나이순 정렬 : https://www.acmicpc.net/problem/10814
	// 값이 같은 원소의 전후관계가 바뀌지 않는 정렬 알고리즘을 안정 정렬(stable sort)이라고 합니다.
	// - 나이 순, 나이가 같으면 가입한 순으로 출력
	int n; cin >> n;
	string str;
	for (int i = 0; i < n; i++) cin >> a[i].first >> a[i].second;
	stable_sort(a, a + n, cmp);
	for (int i = 0; i < n; i++) cout << a[i].first << " " << a[i].second << "\n";

	return 0;
}