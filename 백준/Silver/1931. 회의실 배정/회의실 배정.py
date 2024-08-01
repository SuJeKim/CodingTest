# 회의실 배정 문제 풀이

# 회의 수 입력
n = int(input())

# 회의 정보를 저장할 리스트
meetings = []

# 회의 시작 시간과 종료 시간 입력
for _ in range(n):
    start, end = map(int, input().split())
    meetings.append((start, end))

# 종료 시간 기준으로 정렬 (끝나는 시간, 시작 시간 순)
meetings.sort(key=lambda x: (x[1], x[0]))

# 회의 수 세기
count = 0
last_end_time = 0

# 회의 선택
for start, end in meetings:
    if start >= last_end_time:  # 현재 회의의 시작 시간이 마지막 선택한 회의의 종료 시간과 같거나 클 경우
        count += 1
        last_end_time = end  # 마지막 선택한 회의의 종료 시간을 업데이트

# 결과 출력
print(count)
