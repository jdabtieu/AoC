import sys
from math import *

times = []
dis = []

with open("../../in/2023/6.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging
    times = [x.strip() for x in f.readline().split()]
    times = [int(x) for x in times[1:]]
    ttime = int("".join([str(x) for x in times]))
    dis = [x.strip() for x in f.readline().split()]
    dis = [int(x) for x in dis[1:]]
    tdis = int("".join([str(x) for x in dis]))

ans = 1
for i in range(len(times)):
    cnt = 0
    for t in range(times[i]):
        if t*(times[i]-t) > dis[i]:
            cnt += 1
    ans *= cnt

print(ans)

# cnt = 0
# for t in range(ttime):  # lol this is bruteforceable, < 3s
#     if t*(ttime-t) > tdis:
#         cnt += 1
# print(cnt)
r1 = ceil((-ttime+sqrt(ttime*ttime-4*tdis))/(-2))
r2 = floor((-ttime-sqrt(ttime*ttime-4*tdis))/(-2))
print(r2 - r1 + 1)