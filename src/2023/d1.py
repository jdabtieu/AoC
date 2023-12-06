lines = None
part2 = []

with open("../../in/2023/1.in", "r") as f:
    lines = [x.strip() for x in f.readlines()]
    m = {"one": "1",
        "two": "2",
        "three": "3",
        "four": "4",
        "five": "5",
        "six": "6",
        "seven": "7",
        "eight": "8",
        "nine": "9"}
    for line in lines:
        out = ""
        i = 0
        while i < len(line):
            flag = False
            for j in range(i + 1, i + 6):
                if line[i:j] in m.keys():
                    out += m[line[i:j]]
                    flag = True
                    break
            if flag:
                i = j
            else:
                out += line[i]
                i += 1
        part2.append(out)

def solve(lines):
    ans = 0
    for line in lines:
        d1 = -1
        d2 = 0
        for c in line:
            if ord(c) <= ord('9'):
                if d1 == -1:
                    d1 = ord(c) - ord('0')
                d2 = ord(c) - ord('0')
        ans += d1 * 10 + d2

    print(ans)

solve(lines)
solve(part2)