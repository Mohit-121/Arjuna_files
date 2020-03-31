n=int(input())
list=[]
arr=[0 for x in range(100)]
for i in range(n):
    x=0
    list=[int(i) for i in input().split()]
    for j in list:
        x+=j
        arr[x]+=1
arr1=[]
for i in range(1,n):
    arr1.append(arr[i])
print(n-max(arr1))

