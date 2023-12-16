#include <bits/stdc++.h>

using namespace std;

char grid[111][111];
bool vis[111][111][4][4];
int nlines;

void f(int x, int y, int dx, int dy) {
    if (x < 0 || x >= nlines || y < 0 || y >= nlines) return;
    if (vis[x][y][dx+1][dy+1]) return;
    vis[x][y][dx+1][dy+1] = true;
    if (grid[x][y] == '.') {
        f(x+dx, y+dy, dx, dy);
    } else if (grid[x][y] == '/') {
        f(x-dy, y-dx, -dy, -dx);
    } else if (grid[x][y] == '\\') {
        f(x+dy, y+dx, dy, dx);
    } else if (grid[x][y] == '|') {
        if (dx != 0) f(x+dx, y+dy, dx, dy);
        else {
            f(x+1, y, 1, 0);
            f(x-1, y, -1, 0);
        }
    } else {
        if (dy != 0) f(x+dx, y+dy, dx, dy);
        else {
            f(x, y+1, 0, 1);
            f(x, y-1, 0, -1);
        }
    }
}

int count() {
    int cnt = 0;
    for (int i = 0; i < nlines; i++) {
        for (int j = 0; j < nlines; j++) {
            if (vis[i][j][1][2] || vis[i][j][1][0] || vis[i][j][2][1] || vis[i][j][0][1]) cnt++;
        }
    }
    return cnt;
}

int main(int argc, char **argv) {
    (void) argv;
    if (argc == 1) {
        if (!freopen("../../in/2023/16.in", "r", stdin)) {
            freopen("in/2023/16.in", "r", stdin);
        }
        nlines = 110;
        
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }

    f(0, 0, 0, 1);
    printf("%d\n", count());
    memset(vis, 0, sizeof(vis));

    int ans = 0;
    for (int i = 0; i < nlines; i++) {
        f(i, 0, 0, 1);
        ans = max(ans, count());
        memset(vis, 0, sizeof(vis));
        
        f(0, i, 1, 0);
        ans = max(ans, count());
        memset(vis, 0, sizeof(vis));

        f(i, nlines-1, 0, -1);
        ans = max(ans, count());
        memset(vis, 0, sizeof(vis));

        f(nlines-1, i, -1, 0);
        ans = max(ans, count());
        memset(vis, 0, sizeof(vis));
    }
    printf("%d\n", ans);
}