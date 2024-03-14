n, m = map(int, input().split())
heard = sorted([input().strip() for _ in range(n)])
seen = sorted([input().strip() for _ in range(m)])

def binary_search(array, target):
    start, end = 0, len(array) - 1
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False

result = [name for name in heard if binary_search(seen, name)]
print(len(result))
for name in sorted(result):
    print(name)
