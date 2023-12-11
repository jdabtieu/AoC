#include <bits/stdc++.h>

using namespace std;

char grid[140][140];
int ridx[140], cidx[140];
int ridx2[140], cidx2[140];

int main(int argc, char **argv) {
    int nlines;
    if (argc == 1) {
        freopen("../../in/2023/11.in", "r", stdin);
        nlines = 140;
        
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }
    {
        int idx = 0, idx2 = 0;
        for (int i = 0; i < 140; i++) {
            ridx[i] = idx++;
            ridx2[i] = idx2++;
            bool flag = false;
            for (int j = 0; j < 140; j++) if (grid[i][j] == '#') flag = true;
            if (!flag) {
                idx++;
                idx2 += (1000000-1);
            }
        }
    }
    {
        int idx = 0, idx2 = 0;
        for (int i = 0; i < 140; i++) {
            cidx[i] = idx++;
            cidx2[i] = idx2++;
            bool flag = false;
            for (int j = 0; j < 140; j++) if (grid[j][i] == '#') flag = true;
            if (!flag) {
                idx++;
                idx2 += (1000000-1);
            }
        }
    }
    vector<pair<int, int>> gals;
    vector<pair<long long, long long>> gals2;
    for (int i = 0; i < 140; i++) {
        for (int j = 0; j < 140; j++) {
            if (grid[i][j] == '#') {
                gals.push_back({ridx[i], cidx[j]});
                gals2.push_back({ridx2[i], cidx2[j]});
            }
        }
    }
    long long ans = 0;
    long long ans2 = 0;
    for (int i = 0; i < gals.size(); i++) {
        for (int j = i + 1; j < gals.size(); j++) {
            ans += abs(gals[i].first - gals[j].first) + abs(gals[i].second - gals[j].second);
            ans2 += abs(gals2[i].first - gals2[j].first) + abs(gals2[i].second - gals2[j].second);
        }
    }
    printf("%d %lld\n", ans, ans2);
}