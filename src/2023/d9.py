import sys

lines = None

with open("../../in/2023/9.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging
    lines = [x.strip().split() for x in f.readlines()]
    lines = [[int(x) for x in y] for y in lines]

def find_diff(e):
    diff = []
    for i in range(1, len(e)):
        diff.append(e[i] - e[i-1])
    if not any([x - diff[0] for x in diff]): # matches
        return e[-1] + diff[0]
    else:
        return e[-1] + find_diff(diff)

def find_diff2(e):
    diff = []
    for i in range(1, len(e)):
        diff.append(e[i] - e[i-1])
    if not any([x - diff[0] for x in diff]): # matches
        return e[0] - diff[0]
    else:
        return e[0] - find_diff2(diff)

ans1, ans2 = 0, 0
for line in lines:
    ans1 += find_diff(line)
    ans2 += find_diff2(line)

print(ans1, ans2)