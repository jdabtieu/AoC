import sys

lines = None
part2 = None

with open("../in/Day4_2023.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging

    lines = [x.strip() for x in f.readlines()]
    part2 = lines

ans = 0
cnt = [1]*192
for i in range(len(lines)):
    line = lines[i]
    cur = 1
    c = 0
    wins = [int(x.strip()) for x in line.split("|")[0].split(":")[1].strip().split()]
    ours = [int(x.strip()) for x in line.split("|")[1].strip().split()]
    for a in ours:
        if a in wins:
            cur *= 2
            c += 1
    for j in range(c):
        cnt[i + j + 1] += cnt[i]
    ans += cur // 2

print(ans)
print(sum(cnt))