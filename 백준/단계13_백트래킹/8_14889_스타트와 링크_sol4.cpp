#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, n_;
int s[20][20];
vector<int> t1, t2;

int get(int index);

int main(int argc, char* argv[]) {
	cin >> n; n_ = n / 2;
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cin >> s[i][j];
	cout << get(0) << '\n';
}

int get(int index) {
	if ((int)t1.size() > n_) return -1;
	if ((int)t2.size() > n_) return -1;
	if (index == n) {
		if ((int)t1.size() != n_) return -1;
		if ((int)t2.size() != n_) return -1;
		int s1 = 0, s2 = 0; // 팀이 다 정해졌다면, 팀1과 팀2의 점수를 구한다.
		for (int i = 0; i < n_; i++) {
			for (int j = 0; j < n_; j++) {
				if (i == j) continue;
				s1 += s[t1[i]][t1[j]];
				s2 += s[t2[i]][t2[j]];
			}
		}
		return abs(s1 - s2); // 팀1과 팀2의 점수의 차이값을 반환한다.
	}
	int min = -1;
	t1.push_back(index);
	int s1 = get(index + 1);
	if (min == -1 || (s1 != -1 && min > s1)) min = s1;
	t1.pop_back();
	t2.push_back(index);
	int s2 = get(index + 1);
	if (min == -1 || (s2 != -1 && min > s2)) min = s2;
	t2.pop_back();

	return min;
}