# Day 9, golfed
# Python 3, 163 chars, part 1 only

f=lambda e,d:e[-1]+(f(d,[b-a for a,b in zip(d,d[1:])])if any([x-d[0] for x in d])else d[0]);print(sum([f([0],l) for l in[[*map(int, y.split())]for y in open(0)]]))