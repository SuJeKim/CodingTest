import sys
input = sys.stdin.readline

N = int(input().strip())
coords = []

for _ in range(N):
    x, y = map(int, input().split())
    coords.append((x, y))

coords.sort()

for x, y in coords:
    print(x, y)
