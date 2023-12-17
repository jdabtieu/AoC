#include <bits/stdc++.h>

using namespace std;

char grid[145][145];
bool vis[145][145][4][11];

struct loc {
    int x, y, dir, streak, dis;
};

struct cmpr {
    bool operator()(const loc& a, const loc& b) {
        return a.dis > b.dis;
    }
};

priority_queue<loc, vector<loc>, cmpr> q;
int nlines;

int main(int argc, char **argv) {
    (void) argv;
    if (argc == 1) {
        if (!freopen("../../in/2023/17.in", "r", stdin)) {
            freopen("in/2023/17.in", "r", stdin);
        }
        nlines = 141;
        
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }
    for (int i = 0; i < nlines; i++) {
        for (int j = 0; j < nlines; j++) grid[i][j] -= '0';
    }
    loc a = {0, 0, 1, 0, 0};
    q.push(a);
    a = {0, 0, 2, 0, 0};
    q.push(a);
    while (!q.empty()) {
        loc cur = q.top(); q.pop();
        if (cur.x < 0 || cur.y < 0 || cur.x >= nlines || cur.y >= nlines || vis[cur.x][cur.y][cur.dir][cur.streak]) continue;
        vis[cur.x][cur.y][cur.dir][cur.streak] = true;
        if (cur.x == nlines - 1 && cur.y == nlines - 1) {
            printf("%d\n", cur.dis + grid[cur.x][cur.y] - grid[0][0]);
            return 0;
        }
        if (cur.streak < 10) {
            if (cur.dir % 2 == 0) {
                a = {cur.x + cur.dir - 1, cur.y, cur.dir, cur.streak + 1, cur.dis + grid[cur.x][cur.y]};
            } else {
                a = {cur.x, cur.y - cur.dir + 2, cur.dir, cur.streak + 1, cur.dis + grid[cur.x][cur.y]};
            }
            q.push(a);
        }
        if (cur.dir % 2 == 0 && cur.streak > 3) {
            a = {cur.x, cur.y - 1, 3, 1, cur.dis + grid[cur.x][cur.y]};
            q.push(a);
            a = {cur.x, cur.y + 1, 1, 1, cur.dis + grid[cur.x][cur.y]};
            q.push(a);
        } else if (cur.dir % 2 == 1 && cur.streak > 3) {
            a = {cur.x - 1, cur.y, 0, 1, cur.dis + grid[cur.x][cur.y]};
            q.push(a);
            a = {cur.x + 1, cur.y, 2, 1, cur.dis + grid[cur.x][cur.y]};
            q.push(a);
        }
    }
}