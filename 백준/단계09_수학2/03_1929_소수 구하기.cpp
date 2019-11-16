#include <iostream>
#include <stdio.h>
using namespace std;

// 전역변수 선언
int prime[1000000];                // 소수들
int pcnt;                          // 소수개수
bool isPrime[1000001];  // 소수인지 여부

void Eratos(int n); // 함수 선언

int main(int argc, char* argv[]) {
	// 2019-04-11-목
	// 백준_수학
	// 소수 관련 문제
	// 3 1929 소수 구하기. https://www.acmicpc.net/problem/1929 : M이상 N이하의 소수를 모두 출력하는 프로그램

	// 접근 방법.  
	// 1. 에라토스테네스 체 방식을 이용해서 N이하의 소수들을 구한다.
	// 2. 이렇게 구한 소수 중 M 이상인 소수들만 출력한다.

	// 시간초과가 났다. 이제 
	//cin.tie(NULL);
	// ios_base::sync_with_stdio(false); 을 적용할 때가 왔나보다.   CF. https://www.acmicpc.net/problem/15552
	// 맞았다!

	// 방법2. 결국 빠른 입출력을 위해서는 저것도 있지만, 내가 저걸 정확하게 외울것이란 보장이 없기 때문에...
	// 그냥 scanf, printf방식을 써야겠다.

	// 1. 에라토스테네스 체 방식을 이용해서 N이하의 소수들을 구한다.
	//cin.tie(NULL);
	//ios_base::sync_with_stdio(false);

	int M, N;
	scanf("%d %d", &M, &N); // cin >> M >> N;
	Eratos(N);

	// 2. 이렇게 구한 소수 중 M 이상인 소수들만 출력한다.
	for (int i = 0; i < pcnt; i++) {
		if (prime[i] >= M) {
			printf("%d\n", prime[i]); // cout << prime[i] << "\n";
		}
	}
	return 0;
}

// 1~n [1000000] 사이의 소수를 구하는 함수
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