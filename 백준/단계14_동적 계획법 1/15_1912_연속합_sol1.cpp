#include <iostream>
#include <algorithm>  
using namespace std;


int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// Step16 동적 계획법 기초
	// 15	1912	연속합
	// https://www.acmicpc.net/problem/1912


	// 알고리즘 힌트 : https://www.acmicpc.net/board/view/31672

	// 그러내... 연속합의 결과물은 결국 여기에 달려있었다.
	// i번째까지 진행되었을 때, 지금까지의 최선의 연속합 Max값이 있다고 가정하자

	// i+1번째로 넘어갔을 때의 Max값은
	// 1. Max + num[i]의 값이 num[i]값보다 더 크다면,  Max + num[i]값이 최댓값이고,
	//   그렇지 않다면 num[i]값이 최댓값이다.
	// 2. 그렇게 최댓값 Max값을 구한다.


	int n;
	int num[100000];
	int i;
	cin >> n;

	for (i = 0; i < n; i++) {
		cin >> num[i];
	}

	int value = num[0];
	int Max = value;

	for (i = 1; i < n; i++) {
		value = max(num[i], num[i] + value);
		Max = max(value, Max);
	}

	cout << Max;

	return 0;
}