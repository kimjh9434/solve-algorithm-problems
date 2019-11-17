#include <cstdio>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-11-06-수
	// 백준_단계15	15	그리디 알고리즘 관련 문제
	// 5	1541	잃어버린 괄호 : https://www.acmicpc.net/problem/1541
	// 괄호를 적절히 쳐서, 식의 값을 최소로 만드는 프로그램

	// 최소가 된다는 것은, -값은 최대한 크게!

	// 생각을 해보면, 맨 처음의 +기호를 제외하고, 중간에 -기호가 나오면, 그 뒤는 모두다 -값으로 만들 수가 있다!
	// Ex. a + b + c - d - e - f + g + h - i + j
	//   = a + b + c - d - e -(f + g + h)-(i + j)

	// 결국, -가 나오기 전까지만 더하고, 그외의 숫자는 모두 빼면 된다.

	char cmd;
	int num, sum, minus = 0;

	scanf("%d", &sum);
	if (sum < 0) minus = 1;

	scanf("%c", &cmd);

	while (cmd != '\n') {
		if (cmd == '-') minus = 1;
		scanf("%d", &num);
		if (minus) sum -= num;
		else sum += num;

		scanf("%c", &cmd);
	}
	printf("%d\n", sum);
	return 0;
}