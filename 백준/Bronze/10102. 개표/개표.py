v = input()  # 투표 수
votes = input()  # 투표 결과 문자열
aCount = votes.count('A')
bCcount = votes.count('B')

if aCount > bCcount:
    print('A')
elif aCount < bCcount:
    print('B')
else:
    print('Tie')
