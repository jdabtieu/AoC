#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
struct pll {
    ll ds, de, len;
};

map<ll, pll> maps[7];
int nlines[7] = {18, 8, 35, 45, 14, 28, 11};

vector<pll> seeds;

int main(int argc, char **argv) {
    if (argc == 1) {
        freopen("../in/Day5_2023.in", "r", stdin);
    } else {
        // scanf("%d", &nlines);
    }
    scanf("seeds:");
    for (int i = 1; i <= 10; i++) {
        ll x, y; scanf("%lld %lld", &x, &y); seeds.push_back({x, x+y, y});
    }
    char *garbage = (char*)malloc(1000);
    for (int j = 0; j < 7; j++) {
        scanf("%s map:", garbage);
        for (int i = 0; i < nlines[j]; i++) {
            ll dst, src, len;
            scanf("%lld %lld %lld", &dst, &src, &len);
            maps[j][src] = {dst, dst+len, len};
        }
    }

    { // seeds
        map<ll, pll> ans;
        for(auto &[s, e, l]: seeds) {
            ll src = s, end = e, len = l;
            while (src < end) {
                auto it = --maps[0].upper_bound(src);
                if (it == maps[0].end()) {
                    ans[src] = {src, end, len};
                    src = end;
                } else if (src >= (*it).first+(*it).second.len) {
                    ++it;
                    ans[src] = {src, (*it).first, (*it).first - src};
                    src = (*it).first;
                } else {
                    ll tl = min(len, (*it).second.len-(src-(*it).first));
                    ans[src] = {(*it).second.ds+src-((*it).first), (*it).second.ds+src-((*it).first)+tl, tl};
                    src += tl;
                }
                len = end - src;
            }
        }
        maps[0] = ans;
    }

    for (int j = 0; j < 6; j++) {
        map<ll, pll> ans;
        for(auto &[s, b]: maps[j]) {
            ll os = b.ds, src = b.ds, end = b.de, len = b.len;
            while (src < end) {
                auto it = --maps[j+1].upper_bound(src);
                if (it == maps[j+1].end()) {
                    ans[os] = {src, end, len};
                    os += len;
                    src += len;
                } else if (src >= (*it).first+(*it).second.len) {
                    ++it;
                    ans[os] = {src, (*it).first, (*it).first - src};
                    os += (*it).first - src;
                    src += (*it).first - src;
                } else {
                    ll tl = min(len, (*it).second.len-(src-(*it).first));
                    ans[os] = {(*it).second.ds+src-((*it).first), (*it).second.ds+src-((*it).first)+tl, tl};
                    os += tl;
                    src += tl;
                }
                len = end - src;
            }
        }
        maps[j+1] = ans;
    }

    ll ans = 1LL<<60;
    for (auto &[k, v]: maps[6]) {
        ans = min(ans, v.ds);
    }
    printf("%lld\n", ans);
}