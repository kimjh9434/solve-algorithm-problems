// 7. 연산자 끼워넣기 https://www.acmicpc.net/problem/14888
#pragma warning (disable: 4996)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void seting(int N, vector<int>& n, vector<int>& d);
int func(vector<int>& n, vector<int>& d);

int main(int argc, char* argv[]) {

	// 2019-04-16-화
	// 백준_브루트포스
	// 순열 사용 방법 관련 문제
	// 7. 연산자 끼워넣기 https://www.acmicpc.net/problem/14888

	// 접근 방법 : 순열을 이용. 덧셈(+) -> 0, 뺄셈(-) -> 1, 곱셈(×) -> 2, 나눗셈(÷) -> 3 으로 대응후, 순열을 돌린다.

	//freopen("test_input_values.txt", "r", stdin); // 디버깅 편의용 코드 - 제출시 주석처리

	int N;
	cin >> N; // (2 ≤ N ≤ 11)

	vector<int> n(N);
	vector<int> d;
	seting(N, n, d);

	int m = 1000000000;
	int M = -1000000000;
	do {
		int tmp = func(n, d);// 이경우의 결과값을 구한다.
		M = max(tmp, M); // 최대값 및
		m = min(tmp, m); // 최소값 갱신
	} while (next_permutation(d.begin(), d.end()));

	cout << M << endl << m << endl;

	return 0;
}

void seting(int N, vector<int>& n, vector<int>& d)
{
	for (int i = 0; i < N; i++) {
		cin >> n[i];
	}
	int x;
	for (int i = 0; i < 4; i++) {
		cin >> x;
		for (int j = 0; j < x; j++) {
			d.push_back(i);
		}
	}
}

int func(vector<int>& n, vector<int>& d)
{
	int ret = n[0];
	for (int i = 1; i < n.size(); i++) {
		switch (d[i - 1]) {
		case 0: ret += n[i]; break;
		case 1: ret -= n[i]; break;
		case 2: ret *= n[i]; break;
		case 3: ret /= n[i]; break;
		default:break;
		}
	}

	return ret;
}