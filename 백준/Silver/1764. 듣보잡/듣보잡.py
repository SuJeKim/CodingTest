n, m = map(int, input().split())
heard = {input().strip() for _ in range(n)}
seen = {input().strip() for _ in range(m)}

# 교집합을 이용하여 듣도 보도 못한 사람의 명단을 얻음
result = sorted(list(heard & seen))

print(len(result))
for name in result:
    print(name)
