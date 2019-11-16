#include <iostream>
#include <stdio.h>
using namespace std;

// 전역변수 선언
int prime[10000];     // 소수들
int pcnt;               // 소수개수
bool isPrime[10001];  // 소수인지 여부

void Eratos(int n); // 함수 선언

int main(int argc, char* argv[]) {
	// 2019-04-11-목
	// 백준_수학
	// 소수 관련 문제
	// 5 9020 골드바흐의 추측. https://www.acmicpc.net/problem/9020
	// : 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력하는 프로그램

	// 접근 방법.  
	// 1. 에라토스테네스 체 방식을 이용해서 10000이하의 소수들을 구한다.
	// 2. n을 입력받을 때, n에서 소수 목록의 소수를 뺀 값이 소수인지 판단해서, 소수이면 두 쌍을 출력한다.


	// 1. 에라토스테네스 체 방식을 이용해서 10000이하의 소수들을 구한다.
	Eratos(10000);


	int T, n, i;
	int gol1 = 0, gol2 = 0;
	scanf("%d", &T);
	while (T--) {
		// 2. n을 입력받을 때, n에서 소수 목록의 소수를 뺀 값이 소수인지 판단해서, 소수이면 두 쌍을 출력한다.
		// 단 여기서 소수라고 끝이 아니라 차이가 가장 작은 것을 출력해야 한다. 차이값을 계속 확인해야 한다.
		// 생각해보니 그럴필요가 없다. 어차피 새로운 소수쌍이 등장한다면 무조건 gap차이값은 줄어들 것이다.
		// prime[i]의 값이  n의 절반인 n/2을 넘지 않을 때 까지만 비교해주면 될것이다.

		scanf("%d", &n);
		for (i = 0; prime[i] <= n / 2; i++) {
			if (isPrime[n - prime[i]]) {
				gol1 = prime[i];
				gol2 = n - prime[i];
			}
		}
		printf("%d %d\n", gol1, gol2);
	}
	return 0;
}

// 1~n 사이의 소수를 구하는 함수
void Eratos(int n) {
	std::fill_n(isPrime, n + 1, true); // isPrime 배열을 n+1번째까지 true로 초기화하는 함수
	int i, j;
	for (i = 2; i <= n; i++) { // 2~n까지 검사한다.
		if (isPrime[i]) {      // i번째 수가 소수이면 = 아직 걸러지지 않았으면
			prime[pcnt++] = i; // 소수배열에 저장한다.
			for (j = i + i; j <= n; j += i) { // 이후 n까지 i의 배수를 
				isPrime[j] = false;           // 모두 소수목록에서 지운다.
			}
		}
	}
}