import sys
import json
import functools

lines = None

try:
    f = open("../../in/2023/12.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging
lines = [x.strip() for x in f.readlines()]

lines = [x.split() for x in lines]

@functools.cache
def tryy(s, idx, dataj, didx):
    data = json.loads(dataj)
    if s.replace('?', '#')[idx:idx+data[didx]] != '#'*data[didx]:
        return 0
    if idx+data[didx] < len(s) and s[idx+data[didx]] == '#':
        return 0
    if didx == len(data) - 1:
        if '#' in s[idx+data[didx]:].replace('?', '.'):
            return 0
        return 1
    ans = 0
    for i in range(idx+data[didx]+1, len(s)):
        ans += tryy(s, i, dataj, didx + 1)
        if s[i] == '#': break
    return ans

ans = 0
ans2 = 0
for line in lines:
    grid = line[0]
    grid2 = ((grid+'?')*5)[:-1]
    data = [int(x) for x in line[1].split(",")]
    for i in range(len(grid2)):
        if i < len(grid):
            ans += tryy(grid, i, json.dumps(data), 0)
        ans2 += tryy(grid2, i, json.dumps(data*5), 0)
        if grid2[i] == '#': break
print(ans, ans2)