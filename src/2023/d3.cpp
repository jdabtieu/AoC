#include <bits/stdc++.h>

using namespace std;

char grid[142][142];

unordered_map<long long, vector<int>> gears;

long long parse(int row, int l, int r) {
    long long ans = 0;
    for (; l <= r; l++) {
        if (grid[row][l] < '0' || grid[row][l] > '9') return -1;
        ans = ans * 10 + grid[row][l] - '0';
    }
    return ans;
}

bool issym(char c) {
    if (c == '.' || c <= 23) return false;
    if (c >= '0' && c <= '9') return false;
    if (c >= 'A' && c <= 'Z') return false;
    if (c >= 'a' && c <= 'z') return false;
    return true;
}

bool sym(long long row, int l, int r, long long num) {
    bool ret = false;
    for (int i = l - 1; i <= r + 1; i++) {
        if (issym(grid[row-1][i])) {
            ret = true;
            if (grid[row-1][i] == '*') gears[((row-1 << 32) + i)].push_back(num);
        }
        if (issym(grid[row][i])) {
            ret = true;
            if (grid[row][i] == '*') gears[((row << 32) + i)].push_back(num);
        }
        if (issym(grid[row+1][i])) {
            ret = true;
            if (grid[row+1][i] == '*') gears[((row+1 << 32) + i)].push_back(num);
        }
    }
    return ret;
}

int main(int argc, char **argv) {
    int nlines = 10;
    if (argc == 1) {
        freopen("../../in/2023/3.in", "r", stdin);
        nlines = 140;
    }
    for (int i = 1; i <= nlines; i++) {
        scanf("%s", &grid[i][1]);
    }

    long long ans = 0;
    for (int i = 1; i <= 140; i++) { // row
        for (int j = 1; j <= 140; j++) { // l
            for (int k = 140; k >= j; k--) { // r
                long long num = parse(i, j, k);
                if (num == -1) continue;
                if (sym(i, j, k, num)) {
                    ans += num;
                }
                j = k;
                break;
            }
        }
    }
    printf("%lld\n", ans);

    ans = 0;
    for (auto const& [key, val] : gears) {
        if (val.size() != 2) continue;
        ans += (long long) val[0] * val[1];
    }
    printf("%lld\n", ans);
}