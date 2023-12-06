import sys

lines = None
part2 = None

with open("../../in/2023/2.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging

    lines = [x.strip() for x in f.readlines()]
    part2 = lines

