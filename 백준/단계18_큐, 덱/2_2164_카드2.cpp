#include <iostream>
#include <queue>
using namespace std;

int a[1000000];

int main(int argc, char* argv[]) {
	// 2019-11-02-토
	// 백준_단계18	큐, 덱 관련 문제
	// 2	2164	카드2 : https://www.acmicpc.net/problem/2164
	// 큐를 이용해 동작을 구현하는 문제. 위 문제와 달리 큐의 시간 복잡도가 O(1)이어야 풀 수 있습니다.

	// 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 
	// 1. 제일 위에 있는 카드를 바닥에 버린다. 
	// 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

	// 첫째 줄에 정수 N(1≤N≤500, 000)이 주어진다.
	int n; cin >> n;
	queue<int> q;

	// 1. 1~N 카드 덱 [=큐]을 만들고
	for (int i = 1; i <= n; i++) q.push(i);

	// 2. 큐가 한장이 남을 때 까지 반복한다.
	while (q.size() > 1) {
		// 2.1. 제일 위에 있는 카드를 바닥에 버린다. 
		q.pop();

		// 2.2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
		q.push(q.front()); q.pop();
	}

	// 3. 남게 되는 카드의 번호를 출력한다.
	cout << q.front() << endl;

	return 0;
}