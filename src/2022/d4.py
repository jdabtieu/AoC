with open('../../in/2022/4.in') as f:
    data = [x.strip() for x in f.readlines()]
    data = [((int(x.split(",")[0].split("-")[0]), int(x.split(",")[0].split("-")[1])), (int(x.split(",")[1].split("-")[0]), int(x.split(",")[1].split("-")[1]))) for x in data]

    ans = 0
    for item in data:
        if (item[0][0] <= item[1][0] and item[0][1] >= item[1][1]) or (item[1][0] <= item[0][0] and item[1][1] >= item[0][1]):
            ans += 1
    print(ans)

    ans = 0
    for item in data:
        if (item[1][0] <= item[0][0] <= item[1][1]) or (item[0][0] <= item[1][0] <= item[0][1]):
            ans += 1
    print(ans)