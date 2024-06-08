def dfs(graph, start, end, visited, count):
    visited[start] = True

    if start == end:
        return count

    for neighbor in graph[start]:
        if not visited[neighbor]:
            result = dfs(graph, neighbor, end, visited, count + 1)
            if result != -1:
                return result

    return -1

n = int(input())  # 전체 사람 수
a, b = map(int, input().split())  # 촌수를 계산할 두 사람
m = int(input())  # 관계의 수

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n + 1)
result = dfs(graph, a, b, visited, 0)
print(result)
