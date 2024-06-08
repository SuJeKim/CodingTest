import math

def binary_search(n):
    l = 1
    r = int(math.sqrt(n) * 2)
    ans = 0
    while l <= r:
        mid = (l + r) // 2
        if mid * (mid + 1) <= 2 * n:
            ans = max(ans, mid)
            l = mid + 1
        else:
            r = mid - 1
    return ans

def main():
    t = int(input())
    results = []
    for _ in range(t):
        n = int(input())
        results.append(binary_search(n))
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
