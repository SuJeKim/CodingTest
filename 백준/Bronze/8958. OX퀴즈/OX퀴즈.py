n = int(input())

for _ in range(n):
    ox_list = list(input())
    cnt = 0  
    sum = 0  # 새로운 ox리스트를 입력 받으면 점수 합계를 리셋한다.
    for ox in ox_list:
        if ox == 'O':
            cnt += 1  # 'O'가 연속되면 점수가 1점씩 커진다.
            sum += cnt  
        else:
            cnt = 0
    print(sum)