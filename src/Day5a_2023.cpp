#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

vector<ll> seeds;

map<ll, ll> maps[7];
int nlines[6] = {8, 35, 45, 14, 28, 11};

int main(int argc, char **argv) {
    if (argc == 1) {
        freopen("../in/Day5_2023.in", "r", stdin);
    } else {
        // scanf("%d", &nlines);
    }
    scanf("seeds:");
    for (int i = 1; i <= 20; i++) {
        ll x; scanf("%lld", &x); seeds.push_back(x);
        maps[0][x] = x;
    }
    sort(seeds.begin(), seeds.end());

    char *garbage = (char*)malloc(1000);
    scanf("%s map:", garbage);
    for (int i = 0; i < 18; i++) {
        ll dst, src, len;
        scanf("%lld %lld %lld", &dst, &src, &len);
        for (auto it = lower_bound(seeds.begin(), seeds.end(), src); it != upper_bound(seeds.begin(), seeds.end(), src + len - 1); ++it) {
            maps[0][*it] = dst + (*it - src);
        }
    }
    for (int j = 0; j < 6; j++){
        scanf("%s map:", garbage);
        for (auto &[k, v]: maps[j]) maps[j+1][v] = v;
        for (int i = 0; i < nlines[j]; i++) {
            ll dst, src, len;
            scanf("%lld %lld %lld", &dst, &src, &len);
            for (auto &[k, v]: maps[j]) {
                if (v > src && v < src + len) {
                    maps[j+1][v] = dst + v - src;
                }
            }
        }
    }

    ll ans = 1LL<<60;
    for (auto &[k, v]: maps[6]) {
        ans = min(ans, v);
    }
    printf("%lld\n", ans);
}