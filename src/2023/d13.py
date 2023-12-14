import sys
import json
import functools

lines = None

try:
    f = open("../../in/2023/13.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging

grids = []
grid = []
for line in f.readlines():
    line = line.strip()
    if len(line) == 0:
        grids.append(grid)
        grid = []
    else:
        grid.append([x for x in line])
if grid: grids.append(grid)


def try_grid(grid):
    answers = []
    # try vertical reflect
    for i in range(1, len(grid[0])):
        flag = True
        for j in range(i):
            for k in range(len(grid)):
                try:
                    if grid[k][j] != grid[k][2*i-j-1]:
                        flag = False
                        break
                except IndexError:
                    pass
        if flag:
            answers.append(i)
    
    # try horizontal reflect
    a = 0
    for i in range(1, len(grid)):
        flag = True
        for j in range(i):
            for k in range(len(grid[0])):
                try:
                    if grid[j][k] != grid[2*i-j-1][k]:
                        flag = False
                        break
                except IndexError:
                    pass
        if flag:
            answers.append(i * 100)
    return answers

ans = 0
ans2 = 0
for grid in grids:
    cur = try_grid(grid)
    assert(len(cur) == 1)
    ans += cur[0]
    part2 = False
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            grid[i][j] = chr(ord(grid[i][j]) ^ 13)
            n = try_grid(grid)
            if len(n) == 0:
                grid[i][j] = chr(ord(grid[i][j]) ^ 13)
                continue
            elif len(n) == 1:
                if n[0] == cur[0]:
                    grid[i][j] = chr(ord(grid[i][j]) ^ 13)
                    continue
                else:
                    ans2 += n[0]
                    part2 = True
                    break
            else:
                if n[0] == cur[0]:
                    ans2 += n[1]
                else:
                    ans2 += n[0]
                part2 = True
                break
        if part2:
            break
    assert(part2)

print(ans, ans2)