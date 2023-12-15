#include <bits/stdc++.h>

using namespace std;

char grid[101][101];

int main(int argc, char **argv) {
    (void) argv;
    int nlines;
    if (argc == 1) {
        if (!freopen("../../in/2023/15.in", "r", stdin)) {
            freopen("in/2023/15.in", "r", stdin);
        }
        nlines = 100;
        
    } else {
        scanf("%d", &nlines);
    }

    for (int i = 0; i < nlines; i++) {
        scanf("%s", &grid[i]);
    }

    
}