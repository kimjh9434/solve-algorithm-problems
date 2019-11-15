#include <cstdio> 

int main(int argc, char* argv[])
{
	// 2019-10-08-화
	// 단계4	while문 : 2	10951	A+B - 4 : https://www.acmicpc.net/problem/10951
	// : 입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.

	// CF. scanf는 성공적으로 받아온 수를 return합니다.
	// 만약 에러가 발생하거나 EOF(End of File)을 만나면 - 1을 리턴합니다.

	int A, B;
	while (scanf("%d %d", &A, &B) != EOF) { // ==  (scanf(~~) != -1)     ==     (~scanf(~~))
		printf("%d\n", A + B);
	}
	return 0;
}