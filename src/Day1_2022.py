lines = None

with open("../in/Day1_2022.in", "r") as f:
 lines = [x.strip() for x in f.readlines()]

print(max([eval(x) for x in '+'.join(lines).split('++')]))

print(sum(sorted([eval(x) for x in '+'.join(lines).split('++')])[-3:]))
