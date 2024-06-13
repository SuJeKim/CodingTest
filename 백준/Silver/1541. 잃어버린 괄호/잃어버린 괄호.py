expression = input()
parts = expression.split('-')

# 첫 번째 부분은 무조건 더합니다.
initial_sum = sum(map(int, parts[0].split('+')))

# 나머지 부분은 모두 빼줍니다.
for part in parts[1:]:
    initial_sum -= sum(map(int, part.split('+')))

print(initial_sum)
