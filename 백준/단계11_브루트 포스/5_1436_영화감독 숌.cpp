// 5	1436	영화감독 숌
#include <iostream>
using namespace std;

bool isEndNum(int num) {
	bool isEndNum = false;

	int cnt = 0;
	while (num) {
		if (num % 10 == 6) cnt++;
		else cnt = 0;
		if (cnt == 3) return true;
		num /= 10;
	}
	return isEndNum;
}

int main(int argc, char* argv[]) {
	// 2019-10-16-수
	// 백준_단계10	브루트 포스 관련 문제
	// 5	1436	영화감독 숌 : https://www.acmicpc.net/problem/1436
	// N번째 종말의 수가 나올 때까지 차례대로 시도하는 문제

	// 종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수 : 666, 1666, 2666, 3666, .... , 16661, 16662, ~~
	// N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램

	// N은 10,000보다 작거나 같은 자연수

	// 풀이구상 : 그냥 모든 경우의 수를 구한다.
	// 브루트 포스라고 나와있는 만큼 그냥 N번째 종말의 수를 구해본다.

	int n, cnt;
	cin >> n; cnt = 0;
	int num = 666;
	while (1) {
		if (isEndNum(num)) {
			cnt++;
			// cout << cnt << " " << num << "\n";
		}
		if (n == cnt) break;
		num++;
	}
	cout << num << "\n";

	return 0;
}