import sys

input = sys.stdin.readline

# 입력 받기
n, m = map(int, input().split())
string_set = set()

# 문자열 집합 입력
for _ in range(n):
    string_set.add(input().strip())

# 확인할 문자열 개수
count = 0
for _ in range(m):
    query = input().strip()
    if query in string_set:
        count += 1

# 결과 출력
print(count)
