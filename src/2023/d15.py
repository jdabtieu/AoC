import sys

lines = None

try:
    f = open("../../in/2023/15.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging
steps = f.read().strip().split(",")

ans = 0
hmap = []
for i in range(256): hmap.append(dict())
for s in steps:
    a = 0
    for e in s:
        a = ((a + ord(e)) * 17) % 256
    ans += a
    a = 0
    for e in s:
        if e == '=' or e == '-': break
        a = ((a + ord(e)) * 17) % 256
    if '=' in s:
        x = s.split('=')
        hmap[a][x[0]] = int(x[1])
    else:
        x = s.split('-')
        try:
            del hmap[a][x[0]]
        except KeyError:
            pass
print(ans)
ans = 0
for i in range(256):
    j = 0
    for k, v in hmap[i].items():
        j += 1
        ans += (i+1)*j*v
print(ans)