import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 2018-08-25-토

		// 14 9251 LCS

		// 문제
		// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
		// 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

		// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

		// 입력
		// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

		// 출력
		// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

		// 문제 구상
		// 이 문제 자체는 동적계획법으로 유명한 문제라서 그냥 풀 수 있었다. -- 그러다가 틀렸다...

		// 두 문자열을 각각 Str1, Str2 라고 할 때,
		// LCS[Str1.length+1][Str2.length+1]의 배열을 선언한다.

		// LCS[i][j]의 값을 구한다고 할 때, 일단 LCS[i-1][j-1], LCS[i-1][j], LCS[i][j-1] 3값
		// 중 최댓값을 찾고,
		// str1.charAt(i) == str2.charAt(j) 일 경우에만 1을 더해서 LCS[i][j]값을 채워주면 되는
		// 경우였다.

		// 맞다... (LCS[i][j] < i && LCS[i][j] < j)조건을 까먹었다... -- 아니었다.

		// 미친... 다시 생각해보니 뭔가 심각하게 잘못 생각하고 있었다...

		// 미친... 오래되서 아예 잘못생각하고 있었내...

		// str1.charAt(i) == str2.charAt(j) 일 경우에만 1을 더하는 것이 아니라,
		// str1.charAt(i) == str2.charAt(j) 일 경우에 LCS[i][j-1]+1이고,
		// str1.charAt(i) != str2.charAt(j) 일 경우에 LCS[i-1][j], LCS[i][j-1] 중
		// 최댓값을 넣어야 했다...

		Scanner sc = new Scanner(System.in);

		int[][] LCS;
		String str1;
		String str2;

		int i, j;

		str1 = sc.nextLine();
		str2 = sc.nextLine();

		LCS = new int[str1.length() + 1][str2.length() + 1];

		for (i = 1; i <= str1.length(); i++) {
			for (j = 1; j <= str2.length(); j++) {
				if ((str1.charAt(i - 1) != str2.charAt(j - 1))) {
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
				} else {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				}
			}
		}
		System.out.println(LCS[str1.length()][str2.length()]);

		sc.close();
	}
}