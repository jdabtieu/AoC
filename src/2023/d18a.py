import sys

lines = None

try:
    f = open("../../in/2023/18.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging
lines = [x.strip() for x in f.readlines()]

grid = []
for i in range(2000):
    grid.append([0]*2000)

x,y = 1000, 1000
grid[x][y] = 1
for line in lines:
    d, l, c = line.split()
    l = int(l)
    if d == 'R':
        for i in range(l):
            x += 1
            grid[x][y] = 1
    elif d == 'L':
        for i in range(l):
            x -= 1
            grid[x][y] = 1
    elif d == 'U':
        for i in range(l):
            y -= 1
            grid[x][y] = 1
    else:
        for i in range(l):
            y += 1
            grid[x][y] = 1


print(grid[999][995:1005])
print(grid[1000][995:1005])
print(grid[1001][995:1005])

q = []
q.append((1001, 1003))  # Inside, for my input
grid[1001][1003] = 1
while len(q) != 0:
    x, y = q.pop(0)
    if grid[x+1][y] == 0:
        grid[x+1][y] = 1
        q.append((x+1, y))
    if grid[x-1][y] == 0:
        grid[x-1][y] = 1
        q.append((x-1, y))
    if grid[x][y+1] == 0:
        grid[x][y+1] = 1
        q.append((x, y+1))
    if grid[x][y-1] == 0:
        grid[x][y-1] = 1
        q.append((x, y-1))

print(sum([sum(x) for x in grid]))