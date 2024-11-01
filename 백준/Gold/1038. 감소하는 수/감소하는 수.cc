#include <stdio.h>
int n, dit = 1, cnt = -1, num[10];
void back(int depth, int End) {
	if (depth == dit) {
		cnt++;
		return;
	}

	for (int i = 0; i < End; i++) {
		if (dit - (depth + 1) > i) continue;
		back(depth + 1, i);
		if (n == cnt) {
			num[depth] = i;
			return;
		}
	}
}
int main() {
	scanf("%d", &n);
	while (dit < 11) {
		back(0, 10);
		if (cnt == n) {
			for (int i = 0; i < dit; i++)
				printf("%d",num[i]);
			break;
		}
		dit++;
	}
	if (cnt != n) printf("-1");
	return 0;
}