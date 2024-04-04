t = int(input())

for i in range(t):
    a = int(input())        # 층
    b = int(input())        # 호
    people = [i for i in range(1, b+1)]     # 0층

    for x in range(a):
        for y in range(1,b):
            people[y] += people[y-1] # 아래층의 1~n호 까지의 합
    print(people[-1])       # K층 n호