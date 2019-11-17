#include <cstdio>
#include <algorithm>
using namespace std;

struct time {
	int s, e;
};
bool comp(time a, time b)
{
	if (a.e != b.e) return a.e < b.e;
	else return a.s < b.s;
}
int main(int argc, char* argv[]) {
	// 2019-11-06-수
	// 백준_단계15	15	그리디 알고리즘 관련 문제
	// 2	1931	회의실배정 : https://www.acmicpc.net/problem/1931

	int n, i;
	time g[100001];
	scanf("%d", &n);
	for (i = 0; i < n; i++) scanf("%d %d", &g[i].s, &g[i].e);
	sort(g, g + n, comp);
	int ans = 1, end = g[0].e;
	for (i = 1; i < n; i++)
	{
		if (end <= g[i].s)
		{
			ans++;
			end = g[i].e;
		}
	}
	printf("%d\n", ans);
}