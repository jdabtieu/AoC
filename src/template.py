import sys

lines = None
part2 = None

try:
    f = open("../../in/2023/9.in", "r")
except:
    f = sys.stdin  # Debugging
if len(sys.argv) > 1:
    f = sys.stdin  # Debugging
lines = [x.strip() for x in f.readlines()]
part2 = lines
