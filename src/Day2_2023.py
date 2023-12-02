lines = None

with open("../in/Day2_2023.in", "r") as f:
    lines = [x.strip() for x in f.readlines()]

ans = 0
for line in lines:
    gameid = int(line.split(":")[0].split(" ")[1])
    rounds = [x.strip() for x in line.split(":")[1].split(";")]
    flag = True
    for r in rounds:
        col = [x.strip() for x in r.split(", ")]
        for c in col:
            if (("red" in c and int(c.split(" ")[0]) > 12) or
                ("green" in c and int(c.split(" ")[0]) > 13) or
                ("blue" in c and int(c.split(" ")[0]) > 14)):
                flag = False
                break
        if not flag:
            break
    if flag:
        ans += gameid

print(ans)

ans = 0
for line in lines:
    rounds = [x.strip() for x in line.split(":")[1].split(";")]
    b, g, r = 0, 0, 0
    for rd in rounds:
        col = [x.strip() for x in rd.split(", ")]
        for c in col:
            if "red" in c:
                r = max(r, int(c.split(" ")[0]))
            if "blue" in c:
                b = max(b, int(c.split(" ")[0]))
            if "green" in c:
                g = max(g, int(c.split(" ")[0]))
    ans += b * g * r

print(ans)