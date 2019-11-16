#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	int N;
	int count = 0;

	// 1. N을 입력받는다.  (3 ≤ N ≤ 5000)
	cin >> N;

	// 2. N이 4또는 7이 아닐 때,
	if (N != 4 && N != 7) {
		int c5, c3; // 5kg, 3kg 봉지의 개수
		int remainder;

		// 2.1. 5와 3으로 딱 나눠떨어질 때 까지 반복한다.
		c5 = N / 5;
		remainder = N % 5;
		c3 = remainder / 3;
		remainder = remainder % 3;

		while (remainder != 0) {
			c5--;
			remainder = remainder + c3 * 3 + 5;
			c3 = remainder / 3;
			remainder = remainder % 3;
		}

		// 2. . 봉지 합의 개수를 구한다.
		count = c5 + c3;
	}
	// 3. N이 4또는 7이면,
	else {
		// 딱 나눠떨어지지 않으므로 -1.
		count = -1;
	}

	// 4. 구한 결과물을 출력한다.
	cout << count << endl;

	// 5. 종료한다.
	return 0;
}