#include <iostream>
#include <tuple>
#include <algorithm>
using namespace std;
int dat[302];
tuple<int, int, int> edge[100'000];
int find(int x) {
	if (dat[x] == 0) return x;
	return dat[x] = find(dat[x]);
}
void Union(int a, int b) {
	a = find(a); b = find(b);
	dat[max(a, b)] = min(a, b);
}
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n, a, i, sum = 0;
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> a;
		edge[i] = { a,n+1,i+1 };
	}
	for (int k = 1; k <= n; k++) {
		for (int j = 1; j <= n; j++) {
			cin >> a;
			if(k<j)
				edge[i++] = { a,k,j };
		}
	}
	sort(edge, edge + i);
	for (int j = 0; j < i; j++) {
		if (n == 0) break;
		int now, next, value;
		tie(value, now, next) = edge[j];
		if (find(now) == find(next)) continue;
		Union(now, next);
		sum += value;
		n--;
	}
	cout << sum;
	return 0;
}