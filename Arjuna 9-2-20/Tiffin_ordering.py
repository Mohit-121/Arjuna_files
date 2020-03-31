from itertools import combinations as comb
user=list(input().split())
time=list(map(int,input().split()))
food=list(input().split())
ans_list=[]
for i in range(len(user)):
    ans_list.append([user[i],time[i],food[i]])
ans_list.sort(key=lambda x:x[1])
food_ordered={}
for i in range(len(ans_list)):
    food_ordered.setdefault(ans_list[i][0],[]).append(ans_list[i][2])
max_count=0
ans=""
dict_food={}
for i in food_ordered.keys():
    if(len(food_ordered[i])>=3):
        sub_ans=list(comb(food_ordered[i],3))
        for f in sub_ans:
            i=' '.join(f)
            dict_food[i]=dict_food.get(i,0)+1
            if(dict_food[i]>max_count):
                max_count=dict_food[i]
                ans=i
            elif(dict_food[i]==max_count and i<ans):
                ans=i
final_ans=list(ans.split(" "))
for i in final_ans:
    print(i)