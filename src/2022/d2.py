score = 0

with open('../../in/2022/2.in', 'r') as f:
    data = [x.strip() for x in f.readlines()]
    for line in data:
        opp = ord(line.split(" ")[0]) - ord('A') + 1
        you = ord(line.split(" ")[1]) - ord('X') + 1
        if opp == you:
            score += 3 + opp
        elif (opp == 1 and you == 2) or (opp == 2 and you == 3) or (opp == 3 and you == 1):
            score += 6 + you
        else:
            score += you
    print(score)

    score = 0
    for line in data:
        opp = ord(line.split(" ")[0]) - ord('A') + 1
        res = ord(line.split(" ")[1]) - ord('X') + 1
        if res == 1:
            score += [0, 3, 1, 2][opp]
        elif res == 2:
            score += 3 + opp
        else:
            score += 6 + [0, 2, 3, 1][opp]
    print(score)