import sys

lines = None
part2 = None

with open("../in/Day5_2015.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging

    lines = [x.strip() for x in f.readlines()]
    part2 = lines

ans = 0

for line in lines:
    x = line.count('a') + line.count('e') + line.count('i') + line.count('o') + line.count('u')
    if x < 3: continue
    flag = False
    for i in range(26):
        if line.count(chr(i + ord('a'))*2): flag = True
    if not flag: continue
    if "ab" in line or "cd" in line or "pq" in line or "xy" in line: continue
    ans += 1

print(ans)

ans = 0

for line in lines:
    flag = False
    for i in range(26):
        for j in range(26):
            idx = 0
            cnt = 0
            while idx < len(line) - 1:
                if line[idx] == chr(i + ord('a')) and line[idx+1] == chr(j + ord('a')):
                    idx += 2
                    cnt += 1
                else:
                    idx += 1
                if cnt >= 2:
                    flag = True
                    break
            if flag:
                break
        if flag:
            break
    if not flag: continue
    flag = False
    for i in range(len(line) - 2):
        if line[i] == line[i+2]:
            flag = True
            break
    if not flag: continue
    ans += 1

print(ans)