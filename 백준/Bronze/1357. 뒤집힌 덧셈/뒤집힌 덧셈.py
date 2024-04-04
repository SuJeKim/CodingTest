def rev(x):
    return int(str(x)[::-1])

x, y = map(int, input().split())
print(rev(rev(x) + rev(y)))
