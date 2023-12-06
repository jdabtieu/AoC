stuff = []

with open('../../in/2022/3.in', 'r') as f:
    stuff = [x.strip() for x in f.readlines()]
    stuff = [(x[:len(x)//2], x[len(x)//2:]) for x in stuff]
ans = 0
for item in stuff:
    x = set()
    for c in item[0]:
        x.add(c)
    for c in item[1]:
        if c in x:
            if ord(c) >= ord('a'):
                ans += ord(c) - ord('a') + 1
            else:
                ans += ord(c) - ord('A') + 27
            break

print(ans)

stuff = [x[0] + x[1] for x in stuff]
ans = 0
for i in range(0, len(stuff), 3):
    cnt = [0]*128
    for c in stuff[i]:
        cnt[ord(c)] |= 1
    for c in stuff[i+1]:
        cnt[ord(c)] |= 2
    for c in stuff[i+2]:
        cnt[ord(c)] |= 4
    for j in range(128):
        if cnt[j] == 7:
            if j >= ord('a'):
                ans += j - ord('a') + 1
            else:
                ans += j - ord('A') + 27
            break

print(ans)