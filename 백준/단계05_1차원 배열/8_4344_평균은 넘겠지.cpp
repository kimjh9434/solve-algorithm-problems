#include <iostream>
using namespace std;

int main(int argc, char* argv[]) {
	// 2019-04-10-수
	// Step04_if문 사용해보기
	// 5	4344	평균은 넘겠지


	int C;
	int N;
	int students[1000];
	int i, j;
	int sum;
	float avg;
	int count;
	float rate;

	// 테스트 케이스의 개수 C를 입력받는다.
	cin >> C;

	for (i = 0; i < C; i++) {
		// 학생의 수 N과 N명의 점수를 입력받는다.
		cin >> N;
		sum = 0;
		for (j = 0; j < N; j++) {
			cin >> students[j];
			// 그러면서 총점도 구한다.
			sum += students[j];
		}
		// 이후 구한 총점을 바탕으로 평균점수를 구한다.
		avg = (float)sum / (float)N;

		// 평균점수보다 높은 사람의 수를 구한다.
		count = 0;
		for (j = 0; j < N; j++) {
			if (students[j] > avg)
				count++;
		}

		// 전체 인원 중, 평균을 넘는 학생들의 비율을 구한다.
		rate = (float)count / (float)N * 100;

		// 결과값을 출력한다.
		cout << fixed;
		cout.precision(3);
		cout << rate << "%" << endl;
	}

	return 0;
}