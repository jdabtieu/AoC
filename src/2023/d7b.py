import sys

lines = None
part2 = None

class Hand:
    def __init__(self, cards, bid):
        self.cards = cards.replace('T', 'a').replace('J', '0').replace('Q', 'c').replace('K', 'd').replace('A', 'e')
        self.bid = bid
        self.jokers = self.cards.count('0')
        self.type = self._type()

    def _type(self):
        cnter = [0]*128
        for i in self.cards:
            cnter[ord(i)] += 1
        cnter[ord('0')] = 0
        for i in range(128):
            if cnter[i] + self.jokers == 5:
                return 1
        for i in range(128):
            if cnter[i] + self.jokers == 4:
                return 2
        flag = False
        for i in range(128):
            if cnter[i] + self.jokers == 3:
                flag = True
                for j in range(128):
                    if j == i: continue
                    if cnter[j] == 2:
                        return 3
        if flag:
            return 4
        flag = False
        for i in range(128):
            if cnter[i] + self.jokers == 2:
                flag = True
                for j in range(128):
                    if j == i: continue
                    if cnter[j] == 2:
                        return 5
        if flag:
            return 6
        return 7
        
    
    def __lt__(self, other):
        if self.type < other.type:
            return False
        if other.type < self.type:
            return True
        for i in range(5):
            if ord(self.cards[i]) < ord(other.cards[i]):
                return True
            elif ord(self.cards[i]) > ord(other.cards[i]):
                return False
        return False

with open("../../in/2023/7.in", "r") as f:
    if len(sys.argv) > 1:
        f = sys.stdin  # Debugging
    lines = [x.strip() for x in f.readlines()]
    part2 = lines.copy()

hands = []
for line in lines:
    x = line.split()
    hands.append(Hand(x[0], int(x[1])))

hands.sort()

ans = 0
for i in range(len(hands)):
    # print(i+1, hands[i].bid, hands[i].cards)
    ans += (i+1)*hands[i].bid
print(ans)