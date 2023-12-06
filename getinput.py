import requests
from datetime import datetime
import sys

with open("session.key", "r") as f:
  session_key = f.read().strip()

if len(sys.argv) == 1:
  year = datetime.today().year
  month = datetime.today().month
  day = datetime.today().day
else:
  year = input("Year: ")
  month = 12
  day = input("Day: ")

assert(month == 12)

data = requests.get(f'https://adventofcode.com/{year}/day/{day}/input', cookies={'session': session_key}).text
with open(f"in/{year}/{day}.in", "w") as f:
  f.write(data)
nlines = data.count('\n')
print(f"Downloaded {nlines} lines")