#include <iostream>
using namespace std;

int N, M;
int a[10];

void go(int index, int start) {
	// 1. 끝에 도달한 경우 : M개의 수를 고른 경우
	if (index == M) {
		// 출력한다.
		for (int i = 0; i < M; i++) {
			cout << a[i] << " ";
		}
		cout << "\n";
		return;
	}

	// 2. 계속 진행해야하는 경우.
	for (int i = start; i <= N; i++) {
		a[index] = i;
		go(index + 1, i + 1);
	}
}

int main(int argc, char* argv[]) {
	// 2019-04-19-금
	// 백준_브루트포스_N과M
	// 2. N과 M(2) : https://www.acmicpc.net/problem/15650
	// 추가조건 : 오름차순
	cin >> N >> M; // (1 ≤ M ≤ N ≤ 8)
	go(0, 1);
	return 0;
}