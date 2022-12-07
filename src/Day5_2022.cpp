#include <bits/stdc++.h>

using namespace std;

deque<char> ss[10];
deque<char> sb[10];
char buf[100];
int main() {
    FILE *f = fopen("../in/Day5_2022.in", "r");

    // why is the input format so annoying today
    for (int i = 0; i < 8; i++) {
        fscanf(f, "%100[^\n]\n", &buf);
        for (int j = 1; j < 10; j++) {
            if (buf[j*4-3] == ' ') continue;
            ss[j].push_front(buf[j*4-3]);
            sb[j].push_front(buf[j*4-3]);
        }
    }
    int cnt, src, dst;
    while (fscanf(f, "move %d from %d to %d\n", &cnt, &src, &dst) == 3) {
        deque<char> tmp;
        for (int i = 0; i < cnt; i++) {
            tmp.push_front(sb[src].back());
            sb[src].pop_back();
        }
        while (!tmp.empty()) {
            sb[dst].push_back(tmp.front());
            tmp.pop_front();
        }
        while (cnt--) {
            ss[dst].push_back(ss[src].back());
            ss[src].pop_back();
        }
    }
    for (int i = 1; i < 10; i++) {
        printf("%c", ss[i].back());
    }
    printf("\n");
    for (int i = 1; i < 10; i++) {
        printf("%c", sb[i].back());
    }
    printf("\n");
}