def solve(N, M):
    result = []
    def backtrack(start, path):
        if len(path) == M:
            result.append(path[:])
            return
        for i in range(start, N + 1):
            path.append(i)
            backtrack(i, path)
            path.pop()
    
    backtrack(1, [])
    return result

N, M = map(int, input().split())
result = solve(N, M)
for seq in result:
    print(" ".join(map(str, seq)))
