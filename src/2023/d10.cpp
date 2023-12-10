#include <bits/stdc++.h>

using namespace std;

char grid[140][140];
int dist[140][140];
int s1, s2;

void run(char dir) {
    int c1 = s1, c2 = s2;
    do {
        int oc1 = c1, oc2 = c2;
        if (dir == 'u') c1--;
        else if (dir == 'd') c1++;
        else if (dir == 'r') c2++;
        else c2--;
        if (c1 == s1 && c2 == s2) break;
        if (dist[c1][c2] == 0) dist[c1][c2] = dist[oc1][oc2] + 1;
        else dist[c1][c2] = min(dist[oc1][oc2] + 1, dist[c1][c2]);
        if (grid[c1][c2] == '|' || grid[c1][c2] == '-') continue;
        else if (grid[c1][c2] == 'L') {
            if (dir == 'd') dir = 'r';
            else dir = 'u';
        } else if (grid[c1][c2] == 'J') {
            if (dir == 'd') dir = 'l';
            else dir = 'u';
        } else if (grid[c1][c2] == '7') {
            if (dir == 'r') dir = 'd';
            else dir = 'l';
        } else if (grid[c1][c2] == 'F') {
            if (dir == 'l') dir = 'd';
            else dir = 'r';
        }
    } while (!(c1 == s1 && c2 == s2));
}

int main(int argc, char **argv) {
    int nlines;
    char sc1, sc2;
    char replacestart;
    if (argc == 1) {
        freopen("../../in/2023/10.in", "r", stdin);
        nlines = 140;
        s1 = 30;
        s2 = 72;
        sc1 = 'u';
        sc2 = 'r';
        replacestart = 'L';
    } else {
        scanf("%d", &nlines);
        scanf("%d %d", &s1, &s2);
        scanf(" %c %c", &sc1, &sc2);
        scanf(" %c", &replacestart);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }
    assert(grid[s1][s2] == 'S');
    run(sc1);
    run(sc2);
    int ans1 = 0;
    for (int i = 0; i < 140; i++) {
        for (int j = 0; j < 140; j++) ans1 = max(ans1, dist[i][j]);
    }
    printf("%d\n", ans1);

    for (int i = 0; i < 140; i++) {
        for (int j = 0; j < 140; j++) {
            if (dist[i][j] == 0) grid[i][j] = '.';
        }
    }

    int ans2 = 0;
    grid[s1][s2] = replacestart;
    for (int i = 0; i < 140; i++) {
        bool in = false;
        bool up = false;
        bool active = false;
        for (int j = 0; j < 140; j++) {
            if (grid[i][j] == '.' && in) {
                ans2++;
                continue;
            } else if (grid[i][j] == '.' || grid[i][j] == '-') {
                continue;
            }
            if (grid[i][j] == '|') {
                in = !in;
                continue;
            }
            if (!active) {
                if (grid[i][j] == 'L') up = true;
                else if (grid[i][j] == 'F') up = false;
                active = true;
            } else {
                if (grid[i][j] == 'J' && !up) in = !in;
                if (grid[i][j] == '7' && up) in = !in;
                active = false;
            }
        }
    }
    printf("%d\n", ans2);
}