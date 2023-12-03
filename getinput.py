import requests
from datetime import datetime

with open("session.key", "r") as f:
  session_key = f.read().strip()

year = datetime.today().year
month = datetime.today().month
day = datetime.today().day

assert(month == 12)

data = requests.get(f'https://adventofcode.com/{year}/day/{day}/input', cookies={'session': session_key}).text
with open(f"in/Day{day}_{year}.in", "w") as f:
  f.write(data)
nlines = data.count('\n')
print(f"Downloaded {nlines} lines")