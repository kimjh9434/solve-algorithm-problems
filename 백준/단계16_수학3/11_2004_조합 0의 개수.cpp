// 11	2004	조합 0의 개수
#include <iostream>
#include <algorithm>
using namespace std;
using ll = long long;

ll two(ll n);
ll five(ll n);

int main() {
	ll n, m;
	cin >> n >> m;
	ll t1 = two(n), f1 = five(n);
	ll t2 = two(n - m), f2 = five(n - m), t3 = two(m), f3 = five(m);
	cout << min(t1 - t2 - t3, f1 - f2 - f3) << "\n";
	return 0;
}

// n!에서 2의 개수를 세는 함수
ll two(ll n) {
	ll ret = 0;
	for (ll i = 2; n / i >= 1; i *= 2) {
		ret += n / i;
	}
	return ret;
}
// n!에서 5의 개수를 세는 함수
ll five(ll n) {
	ll ret = 0;
	for (ll i = 5; n / i >= 1; i *= 5) {
		ret += n / i;
	}
	return ret;
}