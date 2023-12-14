#include <bits/stdc++.h>

using namespace std;

vector<char**> history;
int nlines;

char grid[101][101];

void cycle() {
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
        }
    }
    for (int i = 0; i < nlines; i++) {
        for (int j = 0; j < nlines; j++) {
            if (grid[i][j] != 'O') continue;
            int k = j - 1;
            for (; k >= 0; k--) {
                if (grid[i][k] != '.') break;
            }
            k++;
            grid[i][j] = '.';
            grid[i][k] = 'O';
        }
    }
    for (int i = nlines - 1; i >= 0; i--) {
        for (int j = 0; j < nlines; j++) {
            if (grid[i][j] != 'O') continue;
            int k = i + 1;
            for (; k < nlines; k++) {
                if (grid[k][j] != '.') break;
            }
            k--;
            grid[i][j] = '.';
            grid[k][j] = 'O';
        }
    }
    for (int i = 0; i < nlines; i++) {
        for (int j = nlines - 1; j >= 0; j--) {
            if (grid[i][j] != 'O') continue;
            int k = j + 1;
            for (; k < nlines; k++) {
                if (grid[i][k] != '.') break;
            }
            k--;
            grid[i][j] = '.';
            grid[i][k] = 'O';
        }
    }
}

int check_history() {
    for (int i = history.size() - 1; i >= 0; i--) {
        bool match = true;
        for (int j = 0; j < nlines; j++) {
            for (int k = 0; k < nlines; k++) {
                if (history[i][j][k] != grid[j][k]) {
                    match = false;
                    break;
                }
            }
            if (!match) break;
        }
        if (match) return i;
    }
    return -1;
}

int main(int argc, char **argv) {
    if (argc == 1) {
        freopen("../../in/2023/14.in", "r", stdin);
        nlines = 100;
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }

    for (int i = 0; i < 1000000000; i++) {
        char ** cpy = new char*[100];
        for (int j = 0; j < nlines; j++) {
            cpy[j] = new char[100];
            memcpy(cpy[j], grid[j], nlines);
        }
        history.push_back(cpy);
        cycle();
        int res = check_history();
        if (res != -1) {
            // printf("After %d cycles is the same as after %d cycles.\n", i+1, res);
            int cyclen = i+1 - res;
            i += ((1000000000 - i) / cyclen) * cyclen;
        }
    }
    int ans = 0;
    for (int i = 0; i < nlines; i++) {
        for (int j = 0; j < nlines; j++) {
            if (grid[i][j] != 'O') continue;
            ans += nlines - i;
        }
    }
    printf("%d\n", ans);
}