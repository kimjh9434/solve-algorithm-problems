#include <cstdio>

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// for문 4	15552	빠른 A+B : https://www.acmicpc.net/problem/15552
	// : 빠르게 입력받고 출력하는 문제 
	int T, A, B; scanf("%d", &T); // T는 최대 1,000,000이다.
	while (T--) {
		scanf("%d %d", &A, &B);
		printf("%d\n", A + B);
	}
	return 0;
}

// cin, ios::sync_with_stdio(false); 이용
//#include <iostream>
//using namespace std;
//
//int main(int argc, char* argv[]) {
//	// 2019-10-08-화
//	// for문 4	15552	빠른 A+B : https://www.acmicpc.net/problem/15552
//
//	cin.tie(NULL);
//	ios::sync_with_stdio(false);
//
//	// : 빠르게 입력받고 출력하는 문제 
//	int T, A, B; cin >> T; // T는 최대 1,000,000이다.
//	while (T--) {
//		cin >> A >> B;
//		cout << A + B << "\n";
//	}
//	return 0;
//}