#include<iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-10-08-화
	// 단계8	수학 1 : 6	2869	달팽이는 올라가고 싶다 : https://www.acmicpc.net/problem/2869
	// : 달팽이의 움직임을 계산하는 문제 - 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램

	// 대충 구상
	// 1) 달팽이는 하루에 dist[=a-b] 만큼의 거리를 움직인다.
	// 2) 달팽이는 v-a의 위치까지 day[(v-a)/dist]일 동안 이동한다.
	// 3.1) (v-a)/dist의 값이 딱 떨어졌다면, 하루(a)만큼 더가면 v에 딱 도착한다.
	// 3.2) (v-a)/dist의 값이 부족하다면, 이틀(2a)만큼 더가면 v를 넘어서 도착한다.

	long long a, b, v; // (1 ≤ B < A ≤ V ≤ 1,000,000,000)
	cin >> a >> b >> v;
	long long dist = a - b;
	long long day = (v - a) / dist;
	if ((v - a) % dist == 0) day += 1;
	else day += 2;
	cout << day << endl;
	return 0;
}