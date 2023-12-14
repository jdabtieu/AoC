#include <bits/stdc++.h>

using namespace std;

char grid[101][101];

int main(int argc, char **argv) {
    int nlines;
    if (argc == 1) {
        freopen("../../in/2023/14.in", "r", stdin);
        nlines = 100;
        
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }

    int ans = 0;
    for (int i = 0; i < nlines; i++) {
        for (int j = 0; j < nlines; j++) {
            if (grid[i][j] != 'O') continue;
            int k = i - 1;
            for (; k >= 0; k--) {
                if (grid[k][j] != '.') break;
            }
            k++;
            grid[i][j] = '.';
            grid[k][j] = 'O';
            ans += nlines - k;
        }
    }
    printf("%d\n", ans);
}