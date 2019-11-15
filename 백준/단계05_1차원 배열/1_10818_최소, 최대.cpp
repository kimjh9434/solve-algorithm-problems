#include <cstdio>

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// 단계5	1차원 배열 : 1	10818	최소, 최대 : https://www.acmicpc.net/problem/10818
	// : 최솟값과 최댓값을 찾는 문제

	// 풀이 1 : 그냥 풀이 - 배열 사용 X
	int N;
	int M = -1000000;
	int m = 1000000;

	scanf("%d", &N);
	int n;
	while (N--) {
		scanf("%d", &n);
		if (n > M) M = n;
		if (n < m) m = n;
	}
	printf("%d %d\n", m, M);
	return 0;
}


//#include <cstdio>
//#include <limits.h>
//
//int main(int argc, char* argv[])
//{
//	// 2019-10-08-화
//	// 단계5	1차원 배열 : 1	10818	최소, 최대 : https://www.acmicpc.net/problem/10818
//	// : 최솟값과 최댓값을 찾는 문제
//
//	// 풀이 1 : 그냥 풀이 - 배열 사용 X
//	int N;
//	int M = INT_MIN; // -1000000;
//	int m = INT_MAX; // 1000000;
//
//	scanf("%d", &N);
//	int n;
//	while (N--) {
//		scanf("%d", &n);
//		if (n > M) M = n;
//		if (n < m) m = n;
//	}
//	printf("%d %d\n", m, M);
//	return 0;
//}
//
//
//#include <cstdio>
//#include <limits.h>
//
//int a[1000000];
//
//int main(int argc, char* argv[])
//{
//	// 2019-10-08-화
//	// 단계5	1차원 배열 : 1	10818	최소, 최대 : https://www.acmicpc.net/problem/10818
//	// : 최솟값과 최댓값을 찾는 문제
//
//	// 풀이 2 : 배열(array) 사용 O
//	int N;
//	int M = INT_MIN; // -1000000;
//	int m = INT_MAX; // 1000000;
//
//	scanf("%d", &N);
//	for (int i = 0; i < N; i++) {
//		scanf("%d", &a[i]);
//	}
//	int n;
//	for (int i = 0; i < N; i++) {
//		n = a[i];
//		if (n > M) M = n;
//		if (n < m) m = n;
//	}
//	printf("%d %d\n", m, M);
//	return 0;
//}
//
//
//#include <cstdio>
//#include <vector>
//#include <limits.h>
//using namespace std;
//
//int main(int argc, char* argv[])
//{
//	// 2019-10-08-화
//	// 단계5	1차원 배열 : 1	10818	최소, 최대 : https://www.acmicpc.net/problem/10818
//	// : 최솟값과 최댓값을 찾는 문제
//
//	// 풀이 3 : 백터(vector)
//	int N;
//	int M = INT_MIN; // -1000000;
//	int m = INT_MAX; // 1000000;
//	scanf("%d", &N);
//	vector<int> a(N);
//
//	for (int i = 0; i < N; i++) {
//		scanf("%d", &a[i]);
//	}
//	int n;
//	for (int i = 0; i < N; i++) {
//		n = a[i];
//		if (n > M) M = n;
//		if (n < m) m = n;
//	}
//	printf("%d %d\n", m, M);
//	return 0;
//}
//
//
//#include <cstdio>
//#include <vector>
//#include <limits.h>
//#include <algorithm>
//using namespace std;
//
//int main(int argc, char* argv[])
//{
//	// 2019-10-08-화
//	// 단계5	1차원 배열 : 1	10818	최소, 최대 : https://www.acmicpc.net/problem/10818
//	// : 최솟값과 최댓값을 찾는 문제
//
//	// 풀이 4 : 백터(vector) + sort
//	int N; scanf("%d", &N);
//	vector<int> a(N);
//
//	for (int i = 0; i < N; i++) {
//		scanf("%d", &a[i]);
//	}
//	sort(a.begin(), a.end());
//
//	printf("%d %d\n", a.front(), a.back());
//	return 0;
//}