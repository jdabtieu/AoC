import sys
import math

seq = None
lines = None
part2 = None

with open("../../in/2023/8.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging
    seq = f.readline()
    f.readline()
    lines = [x.strip() for x in f.readlines()]
    part2 = lines.copy()

rts = {}
for line in lines:
    x = line.split("=")
    src = x[0].strip()
    d1 = x[1].strip()[1:4]
    d2 = x[1].strip()[6:9]
    rts[src] = (d1, d2)

def solve(cur, part2=False):
    steps = 0
    while True:
        for e in seq.strip():
            if e == 'L':
                cur = rts[cur][0]
            else:
                cur = rts[cur][1]
            steps += 1
            if part2:
                if cur.endswith('Z'):
                    return steps
            else:
                if cur == "ZZZ":
                    return steps

print(solve("AAA"))

ans = 1
for a in range(ord('A'), ord('Z')+1):
    for b in range(ord('A'), ord('Z')+1):
        if chr(a)+chr(b)+'A' not in rts: continue
        print(chr(a)+chr(b)+'A', solve(chr(a)+chr(b)+'A', True))
        ans = math.lcm(ans, solve(chr(a)+chr(b)+'A', True))
print(ans)

# This question is so bad
# There's a secret property that the length of every cycle equals
# exactly how long it takes to go from XXA to XXZ for each path so
# we can use LCM. Also there will only ever be one XXZ on each cycle.
# Given the input below, it simply would produce the wrong answer
"""
L

AAA = (AAX, XXX)
AAX = (BBZ, XXX)
BBZ = (ZZZ, XXX)
BBA = (CCC, XXX)
CCC = (DDD, XXX)
XXX = (XXX, XXX)
DDD = (BBZ, XXX)
"""