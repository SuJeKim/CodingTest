skills = list(map(int, input().split()))
skills.sort()
# 팀 실력 차이 계산
difference = abs((skills[0] + skills[3]) - (skills[1] + skills[2]))
print(difference)
