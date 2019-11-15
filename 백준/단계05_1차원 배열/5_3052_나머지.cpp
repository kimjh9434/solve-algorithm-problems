#include <iostream>
#include <set>
using namespace std;

int main()
{
	// 2019-10-08-화
	// 단계5	1차원 배열 : 5	3052	나머지 : https://www.acmicpc.net/problem/3052
	// : 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램

	int n;
	set<int> s;
	for (int i = 1; i <= 10; i++) {
		cin >> n;
		s.insert(n % 42);
	}
	cout << s.size() << endl;
	return 0;
}