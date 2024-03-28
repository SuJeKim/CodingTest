word = input().upper()
word_list = list(set(word)) # 중복된 알파벳을 제거
lst = []


for i in word_list:
    count = word.count(i)
    lst.append(count)

# [1,2,2,1] -> max(lst)=2 -> lst.count(2) -> 2: 중복
# [1,3,3,4] -> max(lst)=4 -> lst.count(4) -> 1: 유일한 값
if lst.count(max(lst)) >= 2:
    print("?") 
else:
    print(word_list[lst.index(max(lst))])
