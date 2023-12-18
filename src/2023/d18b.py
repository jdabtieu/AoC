import sys
import numpy as np

lines = None

try:
    f = open("../../in/2023/18.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging
lines = [x.strip() for x in f.readlines()]


def PolyArea(x,y):
    return 0.5*np.abs(np.dot(x,np.roll(y,1))-np.dot(y,np.roll(x,1)))

xs = [0]
ys = [0]
x = 0
y = 0
p = 0

for line in lines:
    a, b, c = line.split()
    a = int(c[2:7], 16)
    b = int(c[7])
    p += a
    if b == 0:
        x += a
    elif b == 1:
        y += a
    elif b == 2:
        x -= a
    else:
        y -= a
    xs.append(x)
    ys.append(y)

print(PolyArea(np.array(xs, dtype=object), np.array(ys, dtype=object)) + p/2 + 1)