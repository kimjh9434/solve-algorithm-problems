#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int get(int N, int n[][20], vector<int>& team) {
	// 팀을 나눈다.
	vector<int> t1, t2;
	for (int i = 0; i < N; i++) {
		if (team[i]) t1.push_back(i);
		else t2.push_back(i);
	}

	// 각 점수를 구한다.
	int sum1 = 0, sum2 = 0;
	N /= 2;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			sum1 += n[t1[i]][t1[j]];
			sum2 += n[t2[i]][t2[j]];
		}
	}

	return abs(sum1 - sum2); // 차이값의 절대값을 반환한다.
}

int main(int argc, char* argv[]) {
	// 2019-04-28-일
	// 순열 사용하기 관련문제
	// 3. 스타트와 링크 : https://www.acmicpc.net/problem/14889

	// 입력받기
	int N; cin >> N; // N(4 ≤ N ≤ 20, N은 짝수)
	int n[20][20]; for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) cin >> n[i][j];

	// 팀 후보군 생성
	vector<int> team(N, 1); for (int i = 0; i < N / 2; i++) team[i] = 0;

	// 최솟값 찾기
	int MIN = 1000;
	do {
		int num = get(N, n, team);
		if (MIN > num) MIN = num;
	} while (next_permutation(team.begin(), team.end()));

	// 최솟값 출력
	cout << MIN << "\n";

	return 0;
}