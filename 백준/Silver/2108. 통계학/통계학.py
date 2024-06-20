import sys
from collections import Counter

input = sys.stdin.readline

N = int(input())
data = [int(input()) for _ in range(N)]

# 산술평균
mean = round(sum(data) / N)

# 중앙값
data.sort()
median = data[N // 2]

# 최빈값
counter = Counter(data).most_common()
if len(counter) > 1 and counter[0][1] == counter[1][1]:
    mode = sorted([counter[0][0], counter[1][0]])[1]
else:
    mode = counter[0][0]

# 범위
range_ = max(data) - min(data)

print(mean)
print(median)
print(mode)
print(range_)
