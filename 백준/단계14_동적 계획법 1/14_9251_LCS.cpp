#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int a[1005][1005];

int main(int argc, char* argv[]) {
	// 2019-10-16-수
	// 백준_단계12	동적 계획법 1 관련 문제
	// 14	9251	LCS : https://www.acmicpc.net/problem/9251
	// LCS(Longest Common Subsequence)를 구하는 문제
	// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
	// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

	// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

	// String str1과 str2를 비교한다고 가정하자.
	// str1의 i번째 글자와 str2의 j번째 글자가 다르다면
	//   a[i-1][j], a[i][j-1] 값 중 큰 값이 들어간다.
	// 같다면,  
	//  a[i][j]=a[i-1][j-1]+1의 값이 들어간다.

	string str1, str2; cin >> str1 >> str2;
	for (int i = 1; i <= (int)str1.length(); i++) {
		for (int j = 1; j <= (int)str2.length(); j++) {
			if (str1[i - 1] != str2[j - 1])
				a[i][j] = max(a[i - 1][j], a[i][j - 1]);
			else
				a[i][j] = a[i - 1][j - 1] + 1;
		}
	}
	cout << a[str1.length()][str2.length()] << "\n";

	return 0;
}