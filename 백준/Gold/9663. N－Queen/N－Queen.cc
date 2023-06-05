#include <stdio.h>
int n, cnt;
bool garo[15], right_up[29], left_down[29]; // 대각선은 n*n 크기일때 2*n-1개수 나옴
void recur(int depth) {
	if (depth == n) {
		cnt++;
		return;
	}

	for (int i = 0; i < n; i++) {

		if (garo[i] == 1) continue; // 세로 줄에서 겹치는 것
		if (right_up[depth + i] == 1) continue; // 오른쪽 위로 올라가는 대각선은 x+y 합치면 같은 대각선 위에 있음
		if (left_down[depth - i + n - 1] == 1) continue; /* 왼쪽 아래로 내려가는 대각선은 x-y 한 값이 같으면 대각선 위에 있음 하지만 음수는 배열의 좌표가 될 수 없음
														  n만큼 더해주고 인덱스가 0부터 시작이라 n이 포함 안되니 1 더 빼준다 */
		garo[i] = 1;
		right_up[depth + i] = 1;
		left_down[depth - i + n - 1] = 1;
		recur(depth + 1);
		garo[i] = 0;
		right_up[depth + i] = 0;
		left_down[depth - i + n - 1] = 0;

	}
}
int main() {
	scanf("%d", &n);
	recur(0);
	printf("%d", cnt);
	return 0;
}